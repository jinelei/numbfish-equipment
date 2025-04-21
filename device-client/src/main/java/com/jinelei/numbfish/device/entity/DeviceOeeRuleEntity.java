package com.jinelei.numbfish.device.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jinelei.numbfish.common.entity.BaseEntity;

import java.util.Objects;

@SuppressWarnings("unused")
@TableName("device_oee_rule")
public class DeviceOeeRuleEntity extends BaseEntity<Long> {
    protected Long deviceId;
    protected Long oeeRuleId;

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getOeeRuleId() {
        return oeeRuleId;
    }

    public void setOeeRuleId(Long oeeRuleId) {
        this.oeeRuleId = oeeRuleId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DeviceOeeRuleEntity that = (DeviceOeeRuleEntity) o;
        return Objects.equals(deviceId, that.deviceId) && Objects.equals(oeeRuleId, that.oeeRuleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), deviceId, oeeRuleId);
    }

    @Override
    public String toString() {
        return "DeviceOeeRuleEntity{" +
                "deviceId=" + deviceId +
                ", alarmRuleId=" + oeeRuleId +
                ", id=" + id +
                ", remark='" + remark + '\'' +
                ", createdUserId=" + createdUserId +
                ", createdTime=" + createdTime +
                ", updatedUserId=" + updatedUserId +
                ", updatedTime=" + updatedTime +
                '}';
    }
}