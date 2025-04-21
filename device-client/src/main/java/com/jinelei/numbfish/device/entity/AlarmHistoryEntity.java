package com.jinelei.numbfish.device.entity;

import com.jinelei.numbfish.common.entity.BaseEntity;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @Author: jinelei
 * @Description:
 * @Date: 2023/05/19
 * @Version: 1.0.0
 */
@SuppressWarnings("unused")
public class AlarmHistoryEntity extends BaseEntity<Long> {
    protected Long alarmRuleId;
    protected LocalDateTime recordDateTime;
    protected Boolean result;

    public Long getAlarmRuleId() {
        return alarmRuleId;
    }

    public void setAlarmRuleId(Long alarmRuleId) {
        this.alarmRuleId = alarmRuleId;
    }

    public LocalDateTime getRecordDateTime() {
        return recordDateTime;
    }

    public void setRecordDateTime(LocalDateTime recordDateTime) {
        this.recordDateTime = recordDateTime;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AlarmHistoryEntity that = (AlarmHistoryEntity) o;
        return Objects.equals(alarmRuleId, that.alarmRuleId) && Objects.equals(recordDateTime, that.recordDateTime) && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), alarmRuleId, recordDateTime, result);
    }

    @Override
    public String toString() {
        return "AlarmHistoryEntity{" +
                "alarmRuleId=" + alarmRuleId +
                ", recordDateTime=" + recordDateTime +
                ", result=" + result +
                ", id=" + id +
                ", remark='" + remark + '\'' +
                ", createdUserId=" + createdUserId +
                ", createdTime=" + createdTime +
                ", updatedUserId=" + updatedUserId +
                ", updatedTime=" + updatedTime +
                '}';
    }
}