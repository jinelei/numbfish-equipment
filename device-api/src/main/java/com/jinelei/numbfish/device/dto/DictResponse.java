package com.jinelei.numbfish.device.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("unused")
@Schema(description = "字典响应对象")
public class DictResponse implements Serializable {
    @Schema(description = "id")
    private Long id;
    @Schema(description = "字典编码")
    private String code;
    @Schema(description = "字典名称")
    private String name;
    @Schema(description = "字典值")
    private String value;
    @Schema(description = "上级字典id")
    private Long parentId;
    @Schema(description = "字典描述")
    private String remark;
    @Schema(description = "排序值")
    private Integer sort;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DictResponse that = (DictResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(code, that.code) && Objects.equals(name, that.name) && Objects.equals(value, that.value) && Objects.equals(parentId, that.parentId) && Objects.equals(remark, that.remark) && Objects.equals(sort, that.sort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, value, parentId, remark, sort);
    }

    @Override
    public String toString() {
        return "DictResponse{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", parentId=" + parentId +
                ", remark='" + remark + '\'' +
                ", sort=" + sort +
                '}';
    }
}
