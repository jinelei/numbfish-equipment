package com.jinelei.numbfish.device.dto;

import com.jinelei.numbfish.device.enumeration.AlarmLevel;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
@Schema(description = "报警历史查询请求对象")
public class AlarmHistoryResponse implements Serializable {
    @Schema(description = "id")
    private Long id;
    @Schema(description = "设备id")
    private Long deviceId;
    @Schema(description = "报警规则id")
    private Long alarmRuleId;
    @Schema(description = "报警历史时间")
    private LocalDateTime recordDateTime;
    @Schema(description = "报警结果")
    protected Boolean result;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        AlarmHistoryResponse that = (AlarmHistoryResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(deviceId, that.deviceId) && Objects.equals(alarmRuleId, that.alarmRuleId) && Objects.equals(recordDateTime, that.recordDateTime) && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deviceId, alarmRuleId, recordDateTime, result);
    }

    @Override
    public String toString() {
        return "AlarmHistoryResponse{" +
                "id=" + id +
                ", deviceId=" + deviceId +
                ", alarmRuleId=" + alarmRuleId +
                ", recordDateTime=" + recordDateTime +
                ", result=" + result +
                '}';
    }
}