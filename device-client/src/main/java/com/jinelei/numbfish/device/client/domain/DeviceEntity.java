package com.jinelei.numbfish.device.client.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jinelei.numbfish.device.enumeration.DeviceType;
import com.jinelei.numbfish.device.enumeration.RunningState;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
@TableName("device")
public class DeviceEntity extends BaseEntity<Long> {
    protected String code;
    protected String name;
    protected DeviceType deviceType;
    protected RunningState runningState;
    protected LocalDateTime lastUpdateRunningStateTime;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((deviceType == null) ? 0 : deviceType.hashCode());
        result = prime * result + ((runningState == null) ? 0 : runningState.hashCode());
        result = prime * result + ((lastUpdateRunningStateTime == null) ? 0 : lastUpdateRunningStateTime.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        DeviceEntity other = (DeviceEntity) obj;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (deviceType != other.deviceType)
            return false;
        if (runningState != other.runningState)
            return false;
        if (lastUpdateRunningStateTime == null) {
            if (other.lastUpdateRunningStateTime != null)
                return false;
        } else if (!lastUpdateRunningStateTime.equals(other.lastUpdateRunningStateTime))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DeviceEntity [code=" + code + ", name=" + name + ", deviceType=" + deviceType + ", runningState="
                + runningState + ", lastUpdateRunningStateTime=" + lastUpdateRunningStateTime + "]";
    }

}