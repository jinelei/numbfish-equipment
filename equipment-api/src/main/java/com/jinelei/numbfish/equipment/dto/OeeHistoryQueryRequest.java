package com.jinelei.numbfish.equipment.dto;

import com.jinelei.numbfish.equipment.enumeration.AlarmLevel;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
@Schema(description = "Oee历史查询请求对象")
public class OeeHistoryQueryRequest implements Serializable {
    @Schema(description = "id")
    private Long id;
    @Schema(description = "ids")
    private List<Long> ids;
    @Schema(description = "Oee规则id")
    private Long oeeRuleId;
    @Schema(description = "设备id")
    private Long deviceId;
    @Schema(description = "Oee历史开始时间")
    private LocalDateTime startTime;
    @Schema(description = "Oee历史结束时间")
    private LocalDateTime endTime;

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

    public Long getOeeRuleId() {
        return oeeRuleId;
    }

    public void setOeeRuleId(Long oeeRuleId) {
        this.oeeRuleId = oeeRuleId;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OeeHistoryQueryRequest that = (OeeHistoryQueryRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(ids, that.ids) && Objects.equals(oeeRuleId, that.oeeRuleId) && Objects.equals(deviceId, that.deviceId) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ids, oeeRuleId, deviceId, startTime, endTime);
    }

    @Override
    public String toString() {
        return "OeeHistoryQueryRequest{" +
                "id=" + id +
                ", ids=" + ids +
                ", oeeRuleId=" + oeeRuleId +
                ", deviceId=" + deviceId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}