package com.jinelei.numbfish.device.enumeration;

import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: jinelei
 * @Description:
 * @Date: 2023/07/27
 * @Version: 1.0.0
 */
@SuppressWarnings("unused")
public enum EventType {
    UNKNOWN(0, "未知"),
    CLIENT_CONNECTED(1, "设备上线"),
    CLIENT_DISCONNECTED(2, "设备下线");
    private final int value;
    private final String name;

    EventType(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static Boolean isValidValue(Object value) {
        if (ObjectUtils.isEmpty(value)) {
            return false;
        }
        for (EventType state : EventType.class.getEnumConstants()) {
            switch (value) {
                case String s -> {
                    if (state.name().equalsIgnoreCase(s)) {
                        return true;
                    }
                }
                case Byte b -> {
                    if (state.ordinal() == b) {
                        return true;
                    }
                }
                case Short i -> {
                    if (state.ordinal() == i) {
                        return true;
                    }
                }
                case Integer i -> {
                    if (state.ordinal() == i) {
                        return true;
                    }
                }
                case Long l -> {
                    if (state.ordinal() == l.intValue()) {
                        return true;
                    }
                }
                case Float v -> {
                    if (state.ordinal() == v.intValue()) {
                        return true;
                    }
                }
                case Double v -> {
                    if (state.ordinal() == v.intValue()) {
                        return true;
                    }
                }
                default -> {
                    return false;
                }
            }
        }
        return false;
    }

    public static EventType parseFrom(Object value) {
        if (isValidValue(value)) {
            throw new IllegalArgumentException("value can not be null");
        }
        for (EventType state : EventType.class.getEnumConstants()) {
            switch (value) {
                case String s -> {
                    if (state.name().equalsIgnoreCase(s)) {
                        return state;
                    }
                }
                case Byte b -> {
                    if (state.ordinal() == b) {
                        return state;
                    }
                }
                case Short i -> {
                    if (state.ordinal() == i) {
                        return state;
                    }
                }
                case Integer i -> {
                    if (state.ordinal() == i) {
                        return state;
                    }
                }
                case Long l -> {
                    if (state.ordinal() == l.intValue()) {
                        return state;
                    }
                }
                case Float v -> {
                    if (state.ordinal() == v.intValue()) {
                        return state;
                    }
                }
                case Double v -> {
                    if (state.ordinal() == v.intValue()) {
                        return state;
                    }
                }
                case null, default -> throw new IllegalArgumentException("value type error");
            }
        }
        return UNKNOWN;
    }

    public static List<String> fields() {
        return Arrays.stream(EventType.values()).map(Enum::name).collect(Collectors.toList());
    }
}
