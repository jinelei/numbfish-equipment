package com.jinelei.numbfish.device.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jinelei.numbfish.common.entity.BaseEntity;

import java.util.Objects;

/**
 * @Author: jinelei
 * @Description:
 * @Date: 2023/05/08
 * @Version: 1.0.0
 */
@SuppressWarnings("unused")
@TableName("dict")
public class DictEntity extends BaseEntity<Long> {
    protected String name;
    protected String code;
    protected String value;
    protected String remark = "";
    protected Integer sort = 0;
    protected Long parentId;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DictEntity that = (DictEntity) o;
        return Objects.equals(name, that.name) && Objects.equals(code, that.code) && Objects.equals(value, that.value) && Objects.equals(remark, that.remark) && Objects.equals(sort, that.sort) && Objects.equals(parentId, that.parentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, code, value, remark, sort, parentId);
    }

    @Override
    public String toString() {
        return "DictEntity{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", value='" + value + '\'' +
                ", remark='" + remark + '\'' +
                ", sort=" + sort +
                ", parentId=" + parentId +
                ", id=" + id +
                ", remark='" + remark + '\'' +
                ", createdUserId=" + createdUserId +
                ", createdTime=" + createdTime +
                ", updatedUserId=" + updatedUserId +
                ", updatedTime=" + updatedTime +
                '}';
    }
}