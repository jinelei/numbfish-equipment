package com.jinelei.numbfish.device.enumeration;

import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: jinelei
 * @Description: 设备运行状态
 * @Date: 2023/04/10
 * @Version: 1.0.0
 */
@SuppressWarnings("unused")
public enum RunningState {
    ALL(0, "所有状态"),
    STOP(1, "停止态"),
    RUN(2, "运行态"),
    IDLE(3, "空闲态"),
    OFFLINE(4, "离线态"),
    DEBUG(5, "调试态");
    private final int value;
    private final String name;

    RunningState(int value, String name) {
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
        for (RunningState state : RunningState.class.getEnumConstants()) {
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

    public static RunningState parseFrom(Object value) {
        if (isValidValue(value)) {
            throw new IllegalArgumentException("value can not be null");
        }
        for (RunningState state : RunningState.class.getEnumConstants()) {
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
        return ALL;
    }

    public static List<String> fields() {
        return Arrays.stream(RunningState.values()).map(Enum::name).collect(Collectors.toList());
    }
}