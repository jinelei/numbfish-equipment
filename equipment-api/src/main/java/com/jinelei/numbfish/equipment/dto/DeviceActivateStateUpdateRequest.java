package com.jinelei.numbfish.device.dto;

import java.time.LocalDateTime;
import java.util.Objects;

@SuppressWarnings("unused")
public class DeviceActivateStateUpdateRequest {
    private String deviceCode;
    private LocalDateTime timestamp;

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceId) {
        this.deviceCode = deviceId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        DeviceActivateStateUpdateRequest that = (DeviceActivateStateUpdateRequest) object;
        return Objects.equals(deviceCode, that.deviceCode) && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceCode, timestamp);
    }

    @Override
    public String toString() {
        return "DeviceActiveStateUpdateRequest{" +
                "deviceCode='" + deviceCode + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}