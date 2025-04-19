package com.jinelei.numbfish.device.client.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jinelei.numbfish.acquisition.enumeration.RunningState;
import com.jinelei.numbfish.device.enumeration.DeviceType;

import java.time.LocalDateTime;
import java.util.Objects;

@SuppressWarnings("unused")
@TableName("device")
public class DeviceEntity extends BaseEntity<Long> {
    protected String code;
    protected String name;
    protected DeviceType deviceType;
    protected RunningState runningState;
    protected LocalDateTime lastUpdateRunningStateTime;
    protected LocalDateTime activateTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public RunningState getRunningState() {
        return runningState;
    }

    public void setRunningState(RunningState runningState) {
        this.runningState = runningState;
    }

    public LocalDateTime getLastUpdateRunningStateTime() {
        return lastUpdateRunningStateTime;
    }

    public void setLastUpdateRunningStateTime(LocalDateTime lastUpdateRunningStateTime) {
        this.lastUpdateRunningStateTime = lastUpdateRunningStateTime;
    }

    public LocalDateTime getActivateTime() {
        return activateTime;
    }

    public void setActivateTime(LocalDateTime activateTime) {
        this.activateTime = activateTime;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        DeviceEntity that = (DeviceEntity) object;
        return Objects.equals(code, that.code) && Objects.equals(name, that.name) && deviceType == that.deviceType && runningState == that.runningState && Objects.equals(lastUpdateRunningStateTime, that.lastUpdateRunningStateTime) && Objects.equals(activateTime, that.activateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), code, name, deviceType, runningState, lastUpdateRunningStateTime, activateTime);
    }

    @Override
    public String toString() {
        return "DeviceEntity{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", deviceType=" + deviceType +
                ", runningState=" + runningState +
                ", lastUpdateRunningStateTime=" + lastUpdateRunningStateTime +
                ", activateTime=" + activateTime +
                '}';
    }
}