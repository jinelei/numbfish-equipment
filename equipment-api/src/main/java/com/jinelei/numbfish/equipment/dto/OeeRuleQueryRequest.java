package com.jinelei.numbfish.equipment.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
@Schema(description = "Oee规则查询请求对象")
public class OeeRuleQueryRequest implements Serializable {
    @Schema(description = "id")
    protected Long id;
    @Schema(description = "ids")
    protected List<Long> ids;
    @Schema(description = "Oee启用")
    protected Boolean enabled;
    @Schema(description = "Oee规则")
    protected String oeeRule;
    @Schema(description = "Oee规则-渲染")
    protected String oeeRuleRender;
    @Schema(description = "Oee规则-编辑")
    protected String oeeRuleEdit;
    @Schema(description = "可用性规则")
    protected String availabilityRule;
    @Schema(description = "可用性规则-渲染")
    protected String availabilityRuleRender;
    @Schema(description = "可用性规则-编辑")
    protected String availabilityRuleEdit;
    @Schema(description = "性能规则")
    protected String performanceRule;
    @Schema(description = "性能规则-渲染")
    protected String performanceRuleRender;
    @Schema(description = "性能规则-编辑")
    protected String performanceRuleEdit;
    @Schema(description = "质量规则")
    protected String qualityRule;
    @Schema(description = "质量规则-渲染")
    protected String qualityRuleRender;
    @Schema(description = "质量规则-编辑")
    protected String qualityRuleEdit;

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
        OeeRuleQueryRequest that = (OeeRuleQueryRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(ids, that.ids) && Objects.equals(enabled, that.enabled) && Objects.equals(oeeRule, that.oeeRule) && Objects.equals(oeeRuleRender, that.oeeRuleRender) && Objects.equals(oeeRuleEdit, that.oeeRuleEdit) && Objects.equals(availabilityRule, that.availabilityRule) && Objects.equals(availabilityRuleRender, that.availabilityRuleRender) && Objects.equals(availabilityRuleEdit, that.availabilityRuleEdit) && Objects.equals(performanceRule, that.performanceRule) && Objects.equals(performanceRuleRender, that.performanceRuleRender) && Objects.equals(performanceRuleEdit, that.performanceRuleEdit) && Objects.equals(qualityRule, that.qualityRule) && Objects.equals(qualityRuleRender, that.qualityRuleRender) && Objects.equals(qualityRuleEdit, that.qualityRuleEdit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ids, enabled, oeeRule, oeeRuleRender, oeeRuleEdit, availabilityRule, availabilityRuleRender, availabilityRuleEdit, performanceRule, performanceRuleRender, performanceRuleEdit, qualityRule, qualityRuleRender, qualityRuleEdit);
    }

    @Override
    public String toString() {
        return "OeeRuleUpdateRequest{" +
                "id=" + id +
                ", ids=" + ids +
                ", enabled=" + enabled +
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
                '}';
    }
}