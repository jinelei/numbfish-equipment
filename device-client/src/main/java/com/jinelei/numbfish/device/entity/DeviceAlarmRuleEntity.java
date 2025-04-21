package com.jinelei.numbfish.device.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jinelei.numbfish.common.entity.BaseEntity;

import java.util.Objects;
import java.util.Optional;

@SuppressWarnings("unused")
@TableName("device_alarm_rule")
public class DeviceAlarmRuleEntity extends BaseEntity<Long> {
    protected Long deviceId;
    protected Long alarmRuleId;

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getAlarmRuleId() {
        return alarmRuleId;
    }

    public void setAlarmRuleId(Long alarmRuleId) {
        this.alarmRuleId = alarmRuleId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DeviceAlarmRuleEntity that = (DeviceAlarmRuleEntity) o;
        return Objects.equals(deviceId, that.deviceId) && Objects.equals(alarmRuleId, that.alarmRuleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), deviceId, alarmRuleId);
    }

    @Override
    public String toString() {
        return "DeviceAlarmRuleEntity{" +
                "deviceId=" + deviceId +
                ", alarmRuleId=" + alarmRuleId +
                ", id=" + id +
                ", remark='" + remark + '\'' +
                ", createdUserId=" + createdUserId +
                ", createdTime=" + createdTime +
                ", updatedUserId=" + updatedUserId +
                ", updatedTime=" + updatedTime +
                '}';
    }
}