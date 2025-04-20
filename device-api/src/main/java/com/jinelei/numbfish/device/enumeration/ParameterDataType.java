package com.jinelei.numbfish.device.enumeration;

/**
 * @version v1.0.0
 * @description:
 * @author: jinelei
 * @create: 2024/3/13
 **/
public enum ParameterDataType {
    BOOL(0, "布尔"),
    BIT(1, "位"),
    BYTE(2, "字节"),
    SHORT(3, "短整数"),
    INT(4, "整数"),
    LONG(5, "长整数"),
    FLOAT(6, "浮点数"),
    DOUBLE(7, "双精度浮点数"),
    STRING(8, "字符串"),
    DATE(9, "日期"),
    TIME(10, "时间"),
    DATETIME(11, "日期时间"),
    ARRAY(12, "数组"),;

    private final int value;
    private final String name;

    ParameterDataType(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static ParameterDataType parseFrom(Object type) {
        if (type instanceof String) {
            return switch (String.valueOf(type).toLowerCase()) {
                case "boolean" -> BOOL;
                case "integer" -> INT;
                case "float" -> FLOAT;
                default -> STRING;
            };
        } else {
            return STRING;
        }
    }
}
