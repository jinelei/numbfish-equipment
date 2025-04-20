package com.jinelei.numbfish.device.dto;

import com.jinelei.numbfish.device.enumeration.StructureType;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("unused")
@Schema(description = "结构创建请求对象")
public class StructureCreateRequest implements Serializable {
    @Schema(description = "id")
    private Long id;
    @Schema(description = "结构编码")
    private String code;
    @Schema(description = "结构名称")
    private String name;
    @Schema(description = "结构类型")
    private StructureType typeId;
    @Schema(description = "上级结构id")
    private Long parentId;
    @Schema(description = "结构描述")
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public StructureType getTypeId() {
        return typeId;
    }

    public void setTypeId(StructureType typeId) {
        this.typeId = typeId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StructureCreateRequest that = (StructureCreateRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(code, that.code) && Objects.equals(name, that.name) && typeId == that.typeId && Objects.equals(parentId, that.parentId) && Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, typeId, parentId, remark);
    }

    @Override
    public String toString() {
        return "StructureCreateRequest{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", typeId=" + typeId +
                ", parentId=" + parentId +
                ", remark='" + remark + '\'' +
                '}';
    }
}
