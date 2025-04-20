package com.jinelei.numbfish.device.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jinelei.numbfish.common.entity.BaseEntity;
import com.jinelei.numbfish.device.enumeration.StructureType;

import java.util.Objects;

@SuppressWarnings("unused")
@TableName("structure")
public class StructureEntity extends BaseEntity<Long> {
    protected String name;
    protected String code;
    protected Long parentId;
    protected StructureType typeId;

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

    public StructureType getTypeId() {
        return typeId;
    }

    public void setTypeId(StructureType typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StructureEntity that = (StructureEntity) o;
        return Objects.equals(name, that.name) && Objects.equals(code, that.code) && Objects.equals(parentId, that.parentId) && typeId == that.typeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, code, parentId, typeId);
    }

    @Override
    public String toString() {
        return "StructureEntity{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", parentId=" + parentId +
                ", typeId=" + typeId +
                ", id=" + id +
                ", remark='" + remark + '\'' +
                ", createdUserId=" + createdUserId +
                ", createdTime=" + createdTime +
                ", updatedUserId=" + updatedUserId +
                ", updatedTime=" + updatedTime +
                '}';
    }
}