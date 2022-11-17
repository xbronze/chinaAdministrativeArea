package com.xbronze.map.domain;

/**
 * 行政区域VO
 */
public class MapInfoVO {

    /**
     * 行政区域编码
     */
    private String areaCode;

    /**
     * 行政区域名称
     */
    private String areaName;

    /**
     * 行政区域类型（省、市、区/县、街道/乡镇）
     */
    private String areaType;

    /**
     * 行政区域坐标
     */
    private String coordinates;

    /**
     * 父级行政区域编码
     */
    private String parentAreaCode;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getParentAreaCode() {
        return parentAreaCode;
    }

    public void setParentAreaCode(String parentAreaCode) {
        this.parentAreaCode = parentAreaCode;
    }

    @Override
    public String toString() {
        return "MapInfoVO{" +
                "areaCode='" + areaCode + '\'' +
                ", areaName='" + areaName + '\'' +
                ", areaType='" + areaType + '\'' +
                ", coordinates='" + coordinates + '\'' +
                ", parentAreaCode='" + parentAreaCode + '\'' +
                '}';
    }
}