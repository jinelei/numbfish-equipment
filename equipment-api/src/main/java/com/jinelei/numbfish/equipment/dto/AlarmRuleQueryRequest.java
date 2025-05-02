package com.jinelei.numbfish.device.dto;

import com.jinelei.numbfish.device.enumeration.AlarmLevel;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
@Schema(description = "报警规则查询请求对象")
public class AlarmRuleQueryRequest implements Serializable {
    @Schema(description = "id")
    private Long id;
    @Schema(description = "ids")
    private List<Long> ids;
    @Schema(description = "报警规则编码")
    private String code;
    @Schema(description = "报警规则名称")
    private String name;
    @Schema(description = "报警规则")
    private String alarmRule;
    @Schema(description = "报警规则-渲染")
    private String alarmRuleRender;
    @Schema(description = "报警规则-编辑")
    private String alarmRuleEdit;
    @Schema(description = "报警规则描述")
    private String remark;
    @Schema(description = "报警启用")
    protected Boolean enabled;
    @Schema(description = "报警级别")
    protected AlarmLevel level;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlarmRule() {
        return alarmRule;
    }

    public void setAlarmRule(String alarmRule) {
        this.alarmRule = alarmRule;
    }

    public String getAlarmRuleRender() {
        return alarmRuleRender;
    }

    public void setAlarmRuleRender(String alarmRuleRender) {
        this.alarmRuleRender = alarmRuleRender;
    }

    public String getAlarmRuleEdit() {
        return alarmRuleEdit;
    }

    public void setAlarmRuleEdit(String alarmRuleEdit) {
        this.alarmRuleEdit = alarmRuleEdit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public AlarmLevel getLevel() {
        return level;
    }

    public void setLevel(AlarmLevel level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AlarmRuleQueryRequest that = (AlarmRuleQueryRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(ids, that.ids) && Objects.equals(code, that.code) && Objects.equals(name, that.name) && Objects.equals(alarmRule, that.alarmRule) && Objects.equals(alarmRuleRender, that.alarmRuleRender) && Objects.equals(alarmRuleEdit, that.alarmRuleEdit) && Objects.equals(remark, that.remark) && Objects.equals(enabled, that.enabled) && level == that.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ids, code, name, alarmRule, alarmRuleRender, alarmRuleEdit, remark, enabled, level);
    }

    @Override
    public String toString() {
        return "AlarmRuleUpdateRequest{" +
                "id=" + id +
                ", ids=" + ids +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", alarmRule='" + alarmRule + '\'' +
                ", alarmRuleRender='" + alarmRuleRender + '\'' +
                ", alarmRuleEdit='" + alarmRuleEdit + '\'' +
                ", remark='" + remark + '\'' +
                ", enabled=" + enabled +
                ", level=" + level +
                '}';
    }
}