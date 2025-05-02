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
@ApiSupport(order = 2)
@Tag(name = "结构管理")
@RequestMapping("/structure")
@FeignClient(name = "device-service", url = "${device.service.url}")
public interface StructureApi {

    /**
     * 创建设备
     *
     * @param request 设备请求对象
     * @return 设备响应对象
     */
    @ApiOperationSupport(order = 1)
    @Operation(summary = "创建结构")
    @PostMapping("/structure/create")
    BaseView<Void> create(@Valid StructureCreateRequest request);

    /**
     * 删除设备
     *
     * @param request 设备请求对象
     */
    @ApiOperationSupport(order = 2)
    @Operation(summary = "删除结构")
    @PostMapping("/structure/delete")
    BaseView<Void> delete(@Valid StructureDeleteRequest request);

    /**
     * 更新设备
     *
     * @param request 设备请求对象
     * @return 设备响应对象
     */
    @ApiOperationSupport(order = 3)
    @Operation(summary = "更新结构")
    @PostMapping("/structure/update")
    BaseView<Void> update(@Valid StructureUpdateRequest request);

    /**
     * 查询设备详情
     *
     * @param request 设备请求对象
     * @return 设备响应对象
     */
    @ApiOperationSupport(order = 4)
    @Operation(summary = "获取结构")
    @PostMapping("/structure/get")
    BaseView<StructureResponse> get(@Valid StructureQueryRequest request);

    /**
     * 查询设备列表
     *
     * @param request 设备请求对象
     * @return 设备响应对象列表
     */
    @ApiOperationSupport(order = 5)
    @Operation(summary = "获取结构列表")
    @PostMapping("/structure/list")
    ListView<StructureResponse> list(@Valid StructureQueryRequest request);

    /**
     * 查询设备分页
     *
     * @param request 设备请求对象
     * @return 设备响应对象列表
     */
    @ApiOperationSupport(order = 6)
    @Operation(summary = "获取结构分页列表")
    @PostMapping("/structure/page")
    PageView<StructureResponse> page(@Valid PageRequest<StructureQueryRequest> request);

}
