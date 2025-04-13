package com.jinelei.numbfish.device.dto;

import java.time.LocalDateTime;
import java.util.Objects;

@SuppressWarnings("unused")
public class DeviceUpdateStateRequest {
    private String deviceId;
    private String state;
    private LocalDateTime timestamp;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DeviceUpdateStateRequest that = (DeviceUpdateStateRequest) o;
        return Objects.equals(deviceId, that.deviceId) && Objects.equals(state, that.state) && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, state, timestamp);
    }

    @Override
    public String toString() {
        return "DeviceUpdateStateRequest{" +
                "deviceId='" + deviceId + '\'' +
                ", state='" + state + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}