package com.xbronze.map;

import com.xbronze.map.domain.MapInfoVO;
import com.xbronze.map.factory.MapFactory;
import com.xbronze.map.service.MapService;

import javax.swing.*;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    /**
     * 地图api key
     */
    private static final String KEY = "";

    public static void main( String[] args ) {
        MapFactory factory = new MapFactory();
        MapService mapService = factory.createMapService("baidu");
        try {
            List<MapInfoVO> mapInfoVOList = mapService.administrativeAreaBuilder(KEY, 2, "1", "中华人民共和国", null);
            for (MapInfoVO mapInfoVO : mapInfoVOList) {
                System.out.println(mapInfoVO.toString());
            }
        } catch (Exception e) {
            System.out.println("Exception!!! the message is :" + e.getMessage());
        }

    }


}
