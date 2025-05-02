package com.jinelei.numbfish.equipment.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jinelei.numbfish.common.entity.BaseEntity;
import com.jinelei.numbfish.equipment.enumeration.StructureType;

import java.util.Objects;

@SuppressWarnings("unused")
@TableName("structure")
public class StructureEntity extends BaseEntity<Long> {
    protected String name;
    protected String code;
    protected Long parentId;
    protected StructureType type;

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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public StructureType getType() {
        return type;
    }

    public void setType(StructureType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StructureEntity that = (StructureEntity) o;
        return Objects.equals(name, that.name) && Objects.equals(code, that.code) && Objects.equals(parentId, that.parentId) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, code, parentId, type);
    }

    @Override
    public String toString() {
        return "StructureEntity{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", parentId=" + parentId +
                ", type=" + type +
                ", id=" + id +
                ", remark='" + remark + '\'' +
                ", createdUserId=" + createdUserId +
                ", createdTime=" + createdTime +
                ", updatedUserId=" + updatedUserId +
                ", updatedTime=" + updatedTime +
                '}';
    }
}