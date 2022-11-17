package com.xbronze.map.factory;

import com.xbronze.map.service.MapService;
import com.xbronze.map.service.impl.BaiduMapService;
import com.xbronze.map.service.impl.GaoDeMapService;

public class MapFactory {

    public MapService createMapService(String type){
        if (type == null) {
            return null;
        } else if ("gaode".equals(type)) {
            return new GaoDeMapService();
        } else if("baidu".equals(type)){
            return new BaiduMapService();
        }
        return null;
    }
}