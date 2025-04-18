package com.jinelei.numbfish.device.dto;

import java.io.Serializable;

import com.jinelei.numbfish.acquisition.enumeration.RunningState;
import com.jinelei.numbfish.device.enumeration.DeviceType;

import io.swagger.v3.oas.annotations.media.Schema;

@SuppressWarnings("unused")
@Schema(description = "设备创建请求对象")
public class DeviceCreateRequest implements Serializable {
    @Schema(description = "id")
    private Long id;
    @Schema(description = "设备编码")
    private String code;
    @Schema(description = "设备名称")
    private String name;
    @Schema(description = "设备类型")
    private DeviceType deviceType;
    @Schema(description = "设备状态")
    private RunningState runningState;
    @Schema(description = "设备描述")
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

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public RunningState getRunningState() {
        return runningState;
    }

    public void setRunningState(RunningState deviceState) {
        this.runningState = deviceState;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((deviceType == null) ? 0 : deviceType.hashCode());
        result = prime * result + ((runningState == null) ? 0 : runningState.hashCode());
        result = prime * result + ((remark == null) ? 0 : remark.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DeviceCreateRequest other = (DeviceCreateRequest) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (deviceType != other.deviceType)
            return false;
        if (runningState == null) {
            if (other.runningState != null)
                return false;
        } else if (!runningState.equals(other.runningState))
            return false;
        if (remark == null) {
            if (other.remark != null)
                return false;
        } else if (!remark.equals(other.remark))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DeviceCreateRequest [id=" + id + ", code=" + code + ", name=" + name
                + ", deviceType=" + deviceType + ", runningState=" + runningState + ", remark=" + remark + "]";
    }

}
