package com.jinelei.numbfish.device.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.jinelei.numbfish.common.helper.PageHelper;
import com.jinelei.numbfish.common.request.PageRequest;
import com.jinelei.numbfish.common.view.BaseView;
import com.jinelei.numbfish.common.view.ListView;
import com.jinelei.numbfish.common.view.PageView;
import com.jinelei.numbfish.device.api.DeviceApi;
import com.jinelei.numbfish.device.dto.*;
import com.jinelei.numbfish.device.entity.DeviceEntity;
import com.jinelei.numbfish.device.service.DeviceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@ApiSupport(order = 1)
@Tag(name = "设备管理")
@Validated
@RestController
@RequestMapping("/device")
public class DeviceController implements DeviceApi {
    private final Logger log = LoggerFactory.getLogger(DeviceController.class);

    @Autowired
    private DeviceService deviceService;

    @Override
    @ApiOperationSupport(order = 1)
    @Operation(summary = "创建设备")
    @PostMapping("/create")
    public BaseView<Void> create(@Valid @RequestBody DeviceCreateRequest request) {
        deviceService.create(request);
        return new BaseView<>("创建成功");
    }

    @Override
    @ApiOperationSupport(order = 2)
    @Operation(summary = "删除设备")
    @PostMapping("/delete")
    public BaseView<Void> delete(@Valid @RequestBody DeviceDeleteRequest request) {
        deviceService.delete(request);
        return new BaseView<>("删除成功");
    }

    @Override
    @ApiOperationSupport(order = 3)
    @Operation(summary = "更新设备")
    @PostMapping("/update")
    public BaseView<Void> update(@Valid @RequestBody DeviceUpdateRequest request) {
        deviceService.update(request);
        return new BaseView<>("更新成功");
    }

    @Override
    @ApiOperationSupport(order = 4)
    @Operation(summary = "更新设备运行状态")
    @PostMapping("/update/runningState")
    public BaseView<Void> updateRunningState(@Valid @RequestBody DeviceRunningStateUpdateRequest request) {
        deviceService.updateRunningState(request);
        return new BaseView<>("更新设备运行状态成功");
    }

    @Override
    @ApiOperationSupport(order = 5)
    @Operation(summary = "更新设备激活状态")
    @PostMapping("/update/activateState")
    public BaseView<Void> updateActivateState(DeviceActivateStateUpdateRequest request) {
        deviceService.updateActivateState(request);
        return new BaseView<>("更新设备激活状态成功");
    }

    @Override
    @ApiOperationSupport(order = 6)
    @Operation(summary = "获取设备")
    @PostMapping("/get")
    public BaseView<DeviceResponse> get(@Valid @RequestBody DeviceQueryRequest request) {
        DeviceEntity entity = deviceService.get(request);
        DeviceResponse convert = deviceService.convert(entity);
        return new BaseView<>(convert);
    }

    @Override
    @ApiOperationSupport(order = 7)
    @Operation(summary = "获取设备列表")
    @PostMapping("/list")
    public ListView<DeviceResponse> list(@Valid @RequestBody DeviceQueryRequest request) {
        List<DeviceEntity> entities = deviceService.list(request);
        List<DeviceResponse> convert = entities.parallelStream().map(entity -> deviceService.convert(entity))
                .collect(Collectors.toList());
        return new ListView<>(convert);
    }

    @Override
    @ApiOperationSupport(order = 8)
    @Operation(summary = "获取设备分页列表")
    @PostMapping("/page")
    public PageView<DeviceResponse> page(@Valid @RequestBody PageRequest<DeviceQueryRequest> request) {
        IPage<DeviceEntity> page = deviceService.page(PageHelper.toPage(new PageDTO<>(), request),
                Optional.ofNullable(request.getParams()).orElse(new DeviceQueryRequest()));
        List<DeviceResponse> collect = page.getRecords().parallelStream()
                .map(entity -> deviceService.convert(entity))
                .collect(Collectors.toList());
        return new PageView<>(collect, page.getTotal(), page.getPages(), page.getSize());
    }

}
