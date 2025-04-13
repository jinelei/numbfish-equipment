package com.jinelei.numbfish.device.dto;

import com.jinelei.numbfish.device.enumeration.RunningState;

import java.time.LocalDateTime;
import java.util.Objects;

@SuppressWarnings("unused")
public class DeviceRunningStateUpdateRequest {
    private String deviceId;
    private RunningState state;
    private LocalDateTime timestamp;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public RunningState getState() {
        return state;
    }

    public void setState(RunningState state) {
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
        DeviceRunningStateUpdateRequest that = (DeviceRunningStateUpdateRequest) o;
        return Objects.equals(deviceId, that.deviceId) && Objects.equals(state, that.state) && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, state, timestamp);
    }

    @Override
    public String toString() {
        return "DeviceRunningStateUpdateRequest{" +
                "deviceId='" + deviceId + '\'' +
                ", state=" + state +
                ", timestamp=" + timestamp +
                '}';
    }
}