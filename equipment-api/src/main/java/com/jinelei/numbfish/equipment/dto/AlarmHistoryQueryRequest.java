package com.jinelei.numbfish.equipment.dto;

import com.jinelei.numbfish.equipment.enumeration.AlarmLevel;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
@Schema(description = "报警历史查询请求对象")
public class AlarmHistoryQueryRequest implements Serializable {
    @Schema(description = "id")
    private Long id;
    @Schema(description = "ids")
    private List<Long> ids;
    @Schema(description = "报警规则id")
    private Long alarmRuleId;
    @Schema(description = "设备id")
    private Long deviceId;
    @Schema(description = "报警历史开始时间")
    private LocalDateTime startTime;
    @Schema(description = "报警历史结束时间")
    private LocalDateTime endTime;
    @Schema(description = "报警级别")
    protected AlarmLevel level;
    @Schema(description = "报警结果")
    protected Boolean result;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public Long getAlarmRuleId() {
        return alarmRuleId;
    }

    public void setAlarmRuleId(Long alarmRuleId) {
        this.alarmRuleId = alarmRuleId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public AlarmLevel getLevel() {
        return level;
    }

    public void setLevel(AlarmLevel level) {
        this.level = level;
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
        AlarmHistoryQueryRequest that = (AlarmHistoryQueryRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(ids, that.ids) && Objects.equals(alarmRuleId, that.alarmRuleId) && Objects.equals(deviceId, that.deviceId) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && level == that.level && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ids, alarmRuleId, deviceId, startTime, endTime, level, result);
    }

    @Override
    public String toString() {
        return "AlarmHistoryQueryRequest{" +
                "id=" + id +
                ", ids=" + ids +
                ", alarmRuleId=" + alarmRuleId +
                ", deviceId=" + deviceId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", level=" + level +
                ", result=" + result +
                '}';
    }
}