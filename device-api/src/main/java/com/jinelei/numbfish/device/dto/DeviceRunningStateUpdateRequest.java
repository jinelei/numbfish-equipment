package com.jinelei.numbfish.device.dto;

import com.jinelei.numbfish.acquisition.enumeration.RunningState;

import java.time.LocalDateTime;
import java.util.Objects;

@SuppressWarnings("unused")
public class DeviceRunningStateUpdateRequest {
    private String deviceCode;
    private RunningState runningState;
    private LocalDateTime timestamp;

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceId) {
        this.deviceCode = deviceId;
    }

    public RunningState getRunningState() {
        return runningState;
    }

    public void setRunningState(RunningState runningState) {
        this.runningState = runningState;
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
        return Objects.equals(deviceCode, that.deviceCode) && Objects.equals(runningState, that.runningState) && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceCode, runningState, timestamp);
    }

    @Override
    public String toString() {
        return "DeviceRunningStateUpdateRequest [deviceCode=" + deviceCode + ", runningState=" + runningState
                + ", timestamp=" + timestamp + "]";
    }
}