package com.jinelei.numbfish.device.api;

import com.jinelei.numbfish.common.request.PageRequest;
import com.jinelei.numbfish.common.view.BaseView;
import com.jinelei.numbfish.common.view.ListView;
import com.jinelei.numbfish.common.view.PageView;

import com.jinelei.numbfish.device.dto.*;
import jakarta.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SuppressWarnings("unused")
@FeignClient(name = "device-service", url = "${device.service.url}")
public interface DeviceApi {

    /**
     * 创建设备
     *
     * @param request 设备请求对象
     * @return 设备响应对象
     */
    @PostMapping("/device/create")
    BaseView<Void> create(@Valid DeviceCreateRequest request);

    /**
     * 删除设备
     *
     * @param request 设备请求对象
     */
    @PostMapping("/device/delete")
    BaseView<Void> delete(@Valid DeviceDeleteRequest request);

    /**
     * 更新设备
     *
     * @param request 设备请求对象
     * @return 设备响应对象
     */
    @PostMapping("/device/update")
    BaseView<Void> update(@Valid DeviceUpdateRequest request);

    /**
     * 更新设备运行状态
     *
     * @param request 客户端请求对象
     * @return 客户端响应对象
     */
    @PostMapping("/device/update/runningState")
    BaseView<Void> updateRunningState(@RequestBody @Valid DeviceRunningStateUpdateRequest request);

    /**
     * 更新设备激活状态
     *
     * @param request 客户端请求对象
     * @return 客户端响应对象
     */
    @PostMapping("/device/update/activateState")
    BaseView<Void> updateActivateState(@RequestBody @Valid DeviceActivateStateUpdateRequest request);

    /**
     * 查询设备详情
     *
     * @param request 设备请求对象
     * @return 设备响应对象
     */
    @PostMapping("/device/get")
    BaseView<DeviceResponse> get(@Valid DeviceQueryRequest request);

    /**
     * 查询设备列表
     *
     * @param request 设备请求对象
     * @return 设备响应对象列表
     */
    @PostMapping("/device/list")
    ListView<DeviceResponse> list(@Valid DeviceQueryRequest request);

    /**
     * 查询设备分页
     *
     * @param request 设备请求对象
     * @return 设备响应对象列表
     */
    @PostMapping("/device/page")
    PageView<DeviceResponse> page(@Valid PageRequest<DeviceQueryRequest> request);

}
