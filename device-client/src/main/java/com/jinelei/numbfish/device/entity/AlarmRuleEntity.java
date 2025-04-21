package com.jinelei.numbfish.device.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jinelei.numbfish.common.entity.BaseEntity;
import com.jinelei.numbfish.device.enumeration.AlarmLevel;

import java.util.Objects;

@SuppressWarnings("unused")
@TableName("alarm_rule")
public class AlarmRuleEntity extends BaseEntity<Long> {
    protected String name;
    protected String code;
    protected String remark;
    protected Boolean enabled;
    protected String alarmRule;
    protected String alarmRuleRender;
    protected String alarmRuleEdit;
    protected AlarmLevel level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    public AlarmLevel getLevel() {
        return level;
    }

    public void setLevel(AlarmLevel level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AlarmRuleEntity that = (AlarmRuleEntity) o;
        return Objects.equals(name, that.name) && Objects.equals(code, that.code) && Objects.equals(remark, that.remark) && Objects.equals(enabled, that.enabled) && Objects.equals(alarmRule, that.alarmRule) && Objects.equals(alarmRuleRender, that.alarmRuleRender) && Objects.equals(alarmRuleEdit, that.alarmRuleEdit) && level == that.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, code, remark, enabled, alarmRule, alarmRuleRender, alarmRuleEdit, level);
    }

    @Override
    public String toString() {
        return "AlarmRuleEntity{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", remark='" + remark + '\'' +
                ", enabled=" + enabled +
                ", alarmRule='" + alarmRule + '\'' +
                ", alarmRuleRender='" + alarmRuleRender + '\'' +
                ", alarmRuleEdit='" + alarmRuleEdit + '\'' +
                ", level=" + level +
                ", id=" + id +
                ", remark='" + remark + '\'' +
                ", createdUserId=" + createdUserId +
                ", createdTime=" + createdTime +
                ", updatedUserId=" + updatedUserId +
                ", updatedTime=" + updatedTime +
                '}';
    }
}