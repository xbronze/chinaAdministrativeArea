package com.xbronze.map.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.xbronze.map.domain.MapInfoVO;
import com.xbronze.map.service.MapService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 高德地图API
 */
public class GaoDeMapService implements MapService {

    @Override
    public List<MapInfoVO> administrativeAreaBuilder(String key, int level, String extensions, String searchWord, Map<String, String> params) throws Exception {
        if (key == null || "".equals(key)) {
            throw new Exception("key不能为空！");
        }
        StringBuilder url = new StringBuilder("https://restapi.amap.com/v3/config/district?key=" + key + "&subdistrict=" + level);
        if (extensions != null && !"".equals(extensions)) {
            url.append("&extensions=").append(extensions);
        }
        if (params != null) {
            for (Object mapKey : params.entrySet()) {
                url.append("&").append(mapKey).append("=").append(params.get(mapKey));
            }
        }

        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url(url.toString()).build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            JSONObject json = JSONObject.parseObject(response.body().string());
            JSONArray districts = json.getJSONArray("districts");
            List<MapInfoVO> mapInfoVOList = new ArrayList<>();
            parsingMapInfo(mapInfoVOList, districts, null);
            return mapInfoVOList;
        } catch (IOException e) {
            throw new Exception("Request execute failure, exception message:" + e.getMessage());
        }
    }

    private void parsingMapInfo(List<MapInfoVO> mapInfoVOList, JSONArray districts, String parentAreaCode) {
        if (districts == null || districts.size() == 0) {
            return;
        }
        for (int i = 0 ; i< districts.size() ; i++) {
            JSONObject object = districts.getJSONObject(i);
            MapInfoVO mapInfoVO = new MapInfoVO();
            // 行政区域编号
            mapInfoVO.setAreaCode(object.getString("adcode"));
            // 行政区域名称
            mapInfoVO.setAreaName(object.getString("name"));
            // 行政区域坐标
            mapInfoVO.setCoordinates(object.getString("center"));
            // 行政区划级别
            mapInfoVO.setAreaType(object.getString("level"));
            // 父级行政区域编码
            mapInfoVO.setParentAreaCode(parentAreaCode);
            mapInfoVOList.add(mapInfoVO);

            JSONArray chilidDistricts = object.getJSONArray("districts");
            parsingMapInfo(mapInfoVOList, chilidDistricts, object.getString("adcode"));
        }
    }
}