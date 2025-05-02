package com.jinelei.numbfish.device.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@SuppressWarnings("unused")
@Schema(description = "报警历史查询请求对象")
public class OeeHistoryResponse implements Serializable {
    @Schema(description = "id")
    private Long id;
    @Schema(description = "设备id")
    private Long deviceId;
    @Schema(description = "oee规则id")
    protected Long oeeRuleId;
    @Schema(description = "记录日期")
    protected LocalDate recordDate;
    @Schema(description = "oee")
    protected Double oee;
    @Schema(description = "可用性")
    protected Double availability;
    @Schema(description = "性能")
    protected Double performance;
    @Schema(description = "质量")
    protected Double quality;
    @Schema(description = "跟踪数据")
    protected String traceData;

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

    public Long getOeeRuleId() {
        return oeeRuleId;
    }

    public void setOeeRuleId(Long oeeRuleId) {
        this.oeeRuleId = oeeRuleId;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    public Double getOee() {
        return oee;
    }

    public void setOee(Double oee) {
        this.oee = oee;
    }

    public Double getAvailability() {
        return availability;
    }

    public void setAvailability(Double availability) {
        this.availability = availability;
    }

    public Double getPerformance() {
        return performance;
    }

    public void setPerformance(Double performance) {
        this.performance = performance;
    }

    public Double getQuality() {
        return quality;
    }

    public void setQuality(Double quality) {
        this.quality = quality;
    }

    public String getTraceData() {
        return traceData;
    }

    public void setTraceData(String traceData) {
        this.traceData = traceData;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OeeHistoryResponse that = (OeeHistoryResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(deviceId, that.deviceId) && Objects.equals(oeeRuleId, that.oeeRuleId) && Objects.equals(recordDate, that.recordDate) && Objects.equals(oee, that.oee) && Objects.equals(availability, that.availability) && Objects.equals(performance, that.performance) && Objects.equals(quality, that.quality) && Objects.equals(traceData, that.traceData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deviceId, oeeRuleId, recordDate, oee, availability, performance, quality, traceData);
    }

    @Override
    public String toString() {
        return "OeeHistoryResponse{" +
                "id=" + id +
                ", deviceId=" + deviceId +
                ", oeeRuleId=" + oeeRuleId +
                ", recordDate=" + recordDate +
                ", oee=" + oee +
                ", availability=" + availability +
                ", performance=" + performance +
                ", quality=" + quality +
                ", traceData='" + traceData + '\'' +
                '}';
    }
}