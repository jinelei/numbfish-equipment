package com.jinelei.numbfish.device.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jinelei.numbfish.common.entity.BaseEntity;

import java.util.Objects;

/**
 * @Author: jinelei
 * @Description:
 * @Date: 2023/04/18
 * @Version: 1.0.0
 */
@SuppressWarnings("unused")
@TableName("oee_rule")
public class OeeRuleEntity extends BaseEntity<Long> {
    protected Boolean enabled;
    protected String oeeRule;
    protected String oeeRuleRender;
    protected String oeeRuleEdit;
    protected String availabilityRule;
    protected String availabilityRuleRender;
    protected String availabilityRuleEdit;
    protected String performanceRule;
    protected String performanceRuleRender;
    protected String performanceRuleEdit;
    protected String qualityRule;
    protected String qualityRuleRender;
    protected String qualityRuleEdit;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getOeeRule() {
        return oeeRule;
    }

    public void setOeeRule(String oeeRule) {
        this.oeeRule = oeeRule;
    }

    public String getOeeRuleRender() {
        return oeeRuleRender;
    }

    public void setOeeRuleRender(String oeeRuleRender) {
        this.oeeRuleRender = oeeRuleRender;
    }

    public String getOeeRuleEdit() {
        return oeeRuleEdit;
    }

    public void setOeeRuleEdit(String oeeRuleEdit) {
        this.oeeRuleEdit = oeeRuleEdit;
    }

    public String getAvailabilityRule() {
        return availabilityRule;
    }

    public void setAvailabilityRule(String availabilityRule) {
        this.availabilityRule = availabilityRule;
    }

    public String getAvailabilityRuleRender() {
        return availabilityRuleRender;
    }

    public void setAvailabilityRuleRender(String availabilityRuleRender) {
        this.availabilityRuleRender = availabilityRuleRender;
    }

    public String getAvailabilityRuleEdit() {
        return availabilityRuleEdit;
    }

    public void setAvailabilityRuleEdit(String availabilityRuleEdit) {
        this.availabilityRuleEdit = availabilityRuleEdit;
    }

    public String getPerformanceRule() {
        return performanceRule;
    }

    public void setPerformanceRule(String performanceRule) {
        this.performanceRule = performanceRule;
    }

    public String getPerformanceRuleRender() {
        return performanceRuleRender;
    }

    public void setPerformanceRuleRender(String performanceRuleRender) {
        this.performanceRuleRender = performanceRuleRender;
    }

    public String getPerformanceRuleEdit() {
        return performanceRuleEdit;
    }

    public void setPerformanceRuleEdit(String performanceRuleEdit) {
        this.performanceRuleEdit = performanceRuleEdit;
    }

    public String getQualityRule() {
        return qualityRule;
    }

    public void setQualityRule(String qualityRule) {
        this.qualityRule = qualityRule;
    }

    public String getQualityRuleRender() {
        return qualityRuleRender;
    }

    public void setQualityRuleRender(String qualityRuleRender) {
        this.qualityRuleRender = qualityRuleRender;
    }

    public String getQualityRuleEdit() {
        return qualityRuleEdit;
    }

    public void setQualityRuleEdit(String qualityRuleEdit) {
        this.qualityRuleEdit = qualityRuleEdit;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OeeRuleEntity that = (OeeRuleEntity) o;
        return Objects.equals(enabled, that.enabled) && Objects.equals(oeeRule, that.oeeRule) && Objects.equals(oeeRuleRender, that.oeeRuleRender) && Objects.equals(oeeRuleEdit, that.oeeRuleEdit) && Objects.equals(availabilityRule, that.availabilityRule) && Objects.equals(availabilityRuleRender, that.availabilityRuleRender) && Objects.equals(availabilityRuleEdit, that.availabilityRuleEdit) && Objects.equals(performanceRule, that.performanceRule) && Objects.equals(performanceRuleRender, that.performanceRuleRender) && Objects.equals(performanceRuleEdit, that.performanceRuleEdit) && Objects.equals(qualityRule, that.qualityRule) && Objects.equals(qualityRuleRender, that.qualityRuleRender) && Objects.equals(qualityRuleEdit, that.qualityRuleEdit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), enabled, oeeRule, oeeRuleRender, oeeRuleEdit, availabilityRule, availabilityRuleRender, availabilityRuleEdit, performanceRule, performanceRuleRender, performanceRuleEdit, qualityRule, qualityRuleRender, qualityRuleEdit);
    }

    @Override
    public String toString() {
        return "OeeRuleEntity{" +
                "enabled=" + enabled +
                ", oeeRule='" + oeeRule + '\'' +
                ", oeeRuleRender='" + oeeRuleRender + '\'' +
                ", oeeRuleEdit='" + oeeRuleEdit + '\'' +
                ", availabilityRule='" + availabilityRule + '\'' +
                ", availabilityRuleRender='" + availabilityRuleRender + '\'' +
                ", availabilityRuleEdit='" + availabilityRuleEdit + '\'' +
                ", performanceRule='" + performanceRule + '\'' +
                ", performanceRuleRender='" + performanceRuleRender + '\'' +
                ", performanceRuleEdit='" + performanceRuleEdit + '\'' +
                ", qualityRule='" + qualityRule + '\'' +
                ", qualityRuleRender='" + qualityRuleRender + '\'' +
                ", qualityRuleEdit='" + qualityRuleEdit + '\'' +
                ", id=" + id +
                ", remark='" + remark + '\'' +
                ", createdUserId=" + createdUserId +
                ", createdTime=" + createdTime +
                ", updatedUserId=" + updatedUserId +
                ", updatedTime=" + updatedTime +
                '}';
    }
}