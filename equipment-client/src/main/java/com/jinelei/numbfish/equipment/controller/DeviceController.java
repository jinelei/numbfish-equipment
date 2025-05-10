package com.jinelei.numbfish.equipment.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.jinelei.numbfish.common.helper.PageHelper;
import com.jinelei.numbfish.common.request.PageRequest;
import com.jinelei.numbfish.common.view.BaseView;
import com.jinelei.numbfish.common.view.ListView;
import com.jinelei.numbfish.common.view.PageView;
import com.jinelei.numbfish.equipment.api.DeviceApi;
import com.jinelei.numbfish.equipment.dto.*;
import com.jinelei.numbfish.equipment.entity.DeviceEntity;
import com.jinelei.numbfish.equipment.service.DeviceService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@Validated
@RestController
@RequestMapping("/device")
public class DeviceController implements DeviceApi {
    private final Logger log = LoggerFactory.getLogger(DeviceController.class);

    @Autowired
    private DeviceService deviceService;

    @Override
    @PostMapping("/create")
    public BaseView<Void> create(@Valid @RequestBody DeviceCreateRequest request) {
        deviceService.create(request);
        return new BaseView<>("创建成功");
    }

    @Override
    @PostMapping("/delete")
    public BaseView<Void> delete(@Valid @RequestBody DeviceDeleteRequest request) {
        deviceService.delete(request);
        return new BaseView<>("删除成功");
    }

    @Override
    @PostMapping("/update")
    public BaseView<Void> update(@Valid @RequestBody DeviceUpdateRequest request) {
        deviceService.update(request);
        return new BaseView<>("更新成功");
    }

    @Override
    @PostMapping("/update/runningState")
    public BaseView<Void> updateRunningState(@Valid @RequestBody DeviceRunningStateUpdateRequest request) {
        deviceService.updateRunningState(request);
        return new BaseView<>("更新设备运行状态成功");
    }

    @Override
    @PostMapping("/update/activateState")
    public BaseView<Void> updateActivateState(DeviceActivateStateUpdateRequest request) {
        deviceService.updateActivateState(request);
        return new BaseView<>("更新设备激活状态成功");
    }

    @Override
    @PostMapping("/get")
    public BaseView<DeviceResponse> get(@Valid @RequestBody DeviceQueryRequest request) {
        DeviceEntity entity = deviceService.get(request);
        DeviceResponse convert = deviceService.convert(entity);
        return new BaseView<>(convert);
    }

    @Override
    @PostMapping("/list")
    public ListView<DeviceResponse> list(@Valid @RequestBody DeviceQueryRequest request) {
        List<DeviceEntity> entities = deviceService.list(request);
        List<DeviceResponse> convert = entities.parallelStream().map(entity -> deviceService.convert(entity))
                .collect(Collectors.toList());
        return new ListView<>(convert);
    }

    @Override
    @PostMapping("/page")
    public PageView<DeviceResponse> page(@Valid @RequestBody PageRequest<DeviceQueryRequest> request) {
        IPage<DeviceEntity> page = deviceService.page(PageHelper.toPage(new PageDTO<>(), request),
                Optional.ofNullable(request.getParams()).orElse(new DeviceQueryRequest()));
        List<DeviceResponse> collect = page.getRecords().parallelStream()
                .map(entity -> deviceService.convert(entity))
                .collect(Collectors.toList());
        return new PageView<>(collect, page.getTotal(),  page.getCurrent(), page.getSize());
    }

}
