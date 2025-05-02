package com.jinelei.numbfish.equipment.enumeration;

@SuppressWarnings("unused")
public enum StructureType {
    DEFAULT(0, "默认结构"),
    FACTORY(1, "工厂结构"),
    WORKSHOP(2, "车间结构"),
    LINE(3, "生产线结构"),
    STATION(4, "工位结构"),
    EQUIPMENT(5, "设备结构"),
    ;

    private final int value;
    private final String name;

    StructureType(int value, String name) {
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
