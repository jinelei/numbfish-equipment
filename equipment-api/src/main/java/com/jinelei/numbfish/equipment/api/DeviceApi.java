package com.jinelei.numbfish.equipment.api;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.jinelei.numbfish.common.request.PageRequest;
import com.jinelei.numbfish.common.view.BaseView;
import com.jinelei.numbfish.common.view.ListView;
import com.jinelei.numbfish.common.view.PageView;

import com.jinelei.numbfish.equipment.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@ApiSupport(order = 1)
@Tag(name = "设备管理")
@RequestMapping("/equipment")
@FeignClient(name = "equipment-service", url = "${equipment.service.url}")
public interface DeviceApi {

    /**
     * 创建设备
     *
     * @param request 设备请求对象
     * @return 设备响应对象
     */
    @ApiOperationSupport(order = 1)
    @Operation(summary = "创建设备")
    @PostMapping("/create")
    BaseView<Void> create(@Valid DeviceCreateRequest request);

    /**
     * 删除设备
     *
     * @param request 设备请求对象
     */
    @ApiOperationSupport(order = 2)
    @Operation(summary = "删除设备")
    @PostMapping("/delete")
    BaseView<Void> delete(@Valid DeviceDeleteRequest request);

    /**
     * 更新设备
     *
     * @param request 设备请求对象
     * @return 设备响应对象
     */
    @ApiOperationSupport(order = 3)
    @Operation(summary = "更新设备")
    @PostMapping("/update")
    BaseView<Void> update(@Valid DeviceUpdateRequest request);

    /**
     * 更新设备运行状态
     *
     * @param request 客户端请求对象
     * @return 客户端响应对象
     */
    @ApiOperationSupport(order = 4)
    @Operation(summary = "更新设备运行状态")
    @PostMapping("/update/runningState")
    BaseView<Void> updateRunningState(@RequestBody @Valid DeviceRunningStateUpdateRequest request);

    /**
     * 更新设备激活状态
     *
     * @param request 客户端请求对象
     * @return 客户端响应对象
     */
    @ApiOperationSupport(order = 5)
    @Operation(summary = "更新设备激活状态")
    @PostMapping("/update/activateState")
    BaseView<Void> updateActivateState(@RequestBody @Valid DeviceActivateStateUpdateRequest request);

    /**
     * 查询设备详情
     *
     * @param request 设备请求对象
     * @return 设备响应对象
     */
    @ApiOperationSupport(order = 6)
    @Operation(summary = "获取设备")
    @PostMapping("/get")
    BaseView<DeviceResponse> get(@Valid DeviceQueryRequest request);

    /**
     * 查询设备列表
     *
     * @param request 设备请求对象
     * @return 设备响应对象列表
     */
    @ApiOperationSupport(order = 7)
    @Operation(summary = "获取设备列表")
    @PostMapping("/list")
    ListView<DeviceResponse> list(@Valid DeviceQueryRequest request);

    /**
     * 查询设备分页
     *
     * @param request 设备请求对象
     * @return 设备响应对象列表
     */
    @ApiOperationSupport(order = 8)
    @Operation(summary = "获取设备分页列表")
    @PostMapping("/page")
    PageView<DeviceResponse> page(@Valid PageRequest<DeviceQueryRequest> request);

}
