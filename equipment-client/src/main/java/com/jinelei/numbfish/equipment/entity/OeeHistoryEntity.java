package com.jinelei.numbfish.equipment.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jinelei.numbfish.common.entity.BaseEntity;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @Author: jinelei
 * @Description:
 * @Date: 2023/04/18
 * @Version: 1.0.0
 */
@SuppressWarnings("unused")
@TableName("oee_history")
public class OeeHistoryEntity extends BaseEntity<Long> {
    protected Long oeeRuleId;
    protected LocalDate recordDate;
    protected Double oee;
    protected Double availability;
    protected Double performance;
    protected Double quality;
    protected String traceData;

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
        if (!super.equals(o)) return false;
        OeeHistoryEntity that = (OeeHistoryEntity) o;
        return Objects.equals(oeeRuleId, that.oeeRuleId) && Objects.equals(recordDate, that.recordDate) && Objects.equals(oee, that.oee) && Objects.equals(availability, that.availability) && Objects.equals(performance, that.performance) && Objects.equals(quality, that.quality) && Objects.equals(traceData, that.traceData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), oeeRuleId, recordDate, oee, availability, performance, quality, traceData);
    }

    @Override
    public String toString() {
        return "OeeHistoryEntity{" +
                "oeeConfigId=" + oeeRuleId +
                ", recordDate=" + recordDate +
                ", oee=" + oee +
                ", availability=" + availability +
                ", performance=" + performance +
                ", quality=" + quality +
                ", traceData='" + traceData + '\'' +
                ", id=" + id +
                ", remark='" + remark + '\'' +
                ", createdUserId=" + createdUserId +
                ", createdTime=" + createdTime +
                ", updatedUserId=" + updatedUserId +
                ", updatedTime=" + updatedTime +
                '}';
    }
}