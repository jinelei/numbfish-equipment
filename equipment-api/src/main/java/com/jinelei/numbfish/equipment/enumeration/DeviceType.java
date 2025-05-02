package com.jinelei.numbfish.equipment.enumeration;

/**
 * @Author: jinelei
 * @Description: 设备类型
 * @Date: 2023/04/10
 * @Version: 1.0.0
 */
@SuppressWarnings("unused")
public enum DeviceType {
    METER(0, "计量设备"),
    SWITCH(1, "开关设备"),
    SENSOR(2, "传感器设备"),
    CONTROLLER(3, "控制器设备"),
    MONITOR(4, "监控设备"),
    CAMERA(5, "摄像头设备"),
    SERVER(6, "服务器设备"),
    ROUTER(7, "路由器设备"),
    SWITCHBOARD(8, "配电柜设备"),
    UPS(9, "不间断电源设备"),
    GENERATOR(10, "发电机设备"),
    ;

    private final int value;
    private final String name;

    DeviceType(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

}
