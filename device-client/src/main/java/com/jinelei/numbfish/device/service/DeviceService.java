package com.jinelei.numbfish.device.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jinelei.numbfish.device.dto.*;
import com.jinelei.numbfish.device.entity.DeviceEntity;

@SuppressWarnings("unused")
public interface DeviceService extends IService<DeviceEntity> {

    void create(DeviceCreateRequest request);

    void delete(DeviceDeleteRequest request);

    void update(DeviceUpdateRequest request);

    void updateRunningState(DeviceRunningStateUpdateRequest request);

    void updateActivateState(DeviceActivateStateUpdateRequest request);

    DeviceEntity get(DeviceQueryRequest request);

    List<DeviceEntity> list(DeviceQueryRequest request);

    IPage<DeviceEntity> page(IPage<DeviceEntity> page, DeviceQueryRequest request);

    DeviceResponse convert(DeviceEntity entity);

}
