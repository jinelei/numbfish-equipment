package com.jinelei.numbfish.device.api;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.jinelei.numbfish.common.request.PageRequest;
import com.jinelei.numbfish.common.view.BaseView;
import com.jinelei.numbfish.common.view.ListView;
import com.jinelei.numbfish.common.view.PageView;
import com.jinelei.numbfish.device.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SuppressWarnings("unused")
@ApiSupport(order = 3)
@Tag(name = "字典管理")
@RequestMapping("/dict")
@FeignClient(name = "device-service", url = "${device.service.url}")
public interface DictApi {

    /**
     * 创建设备
     *
     * @param request 设备请求对象
     * @return 设备响应对象
     */
    @ApiOperationSupport(order = 1)
    @Operation(summary = "创建字典")
    @PostMapping("/create")
    BaseView<Void> create(@Valid DictCreateRequest request);

    /**
     * 删除设备
     *
     * @param request 设备请求对象
     */
    @ApiOperationSupport(order = 2)
    @Operation(summary = "删除字典")
    @PostMapping("/delete")
    BaseView<Void> delete(@Valid DictDeleteRequest request);

    /**
     * 更新设备
     *
     * @param request 设备请求对象
     * @return 设备响应对象
     */
    @ApiOperationSupport(order = 3)
    @Operation(summary = "更新字典")
    @PostMapping("/update")
    BaseView<Void> update(@Valid DictUpdateRequest request);

    /**
     * 查询设备详情
     *
     * @param request 设备请求对象
     * @return 设备响应对象
     */
    @ApiOperationSupport(order = 4)
    @Operation(summary = "获取字典")
    @PostMapping("/get")
    BaseView<DictResponse> get(@Valid DictQueryRequest request);

    /**
     * 查询设备列表
     *
     * @param request 设备请求对象
     * @return 设备响应对象列表
     */
    @ApiOperationSupport(order = 5)
    @Operation(summary = "获取字典列表")
    @PostMapping("/list")
    ListView<DictResponse> list(@Valid DictQueryRequest request);

    /**
     * 查询设备分页
     *
     * @param request 设备请求对象
     * @return 设备响应对象列表
     */
    @ApiOperationSupport(order = 6)
    @Operation(summary = "获取字典分页列表")
    @PostMapping("/page")
    PageView<DictResponse> page(@Valid PageRequest<DictQueryRequest> request);

}
