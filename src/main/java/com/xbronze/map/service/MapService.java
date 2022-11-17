package com.xbronze.map.service;

import com.xbronze.map.domain.MapInfoVO;

import java.util.List;
import java.util.Map;

public interface MapService {

    /**
     * 构建生成行政区域信息
     * @Param key 地图api_key
     * @Param level 显示子级级数
     * @Param extensions 返回结果控制
     * @Param searchWord 查询关键字
     * @Param params 其他查询条件
     */
    List<MapInfoVO> administrativeAreaBuilder(String key, int level, String extensions, String searchWord, Map<String, String> params) throws Exception;

}