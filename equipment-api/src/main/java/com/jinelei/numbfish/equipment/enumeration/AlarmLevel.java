package com.jinelei.numbfish.equipment.enumeration;

@SuppressWarnings("unused")
public enum AlarmLevel {
    SEVERE(0, "严重"),
    URGENT(1, "紧急"),
    ALARM(2, "警告"),
    NOTICE(3, "通知"),
    ;

    private final int value;
    private final String name;

    AlarmLevel(int value, String name) {
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
