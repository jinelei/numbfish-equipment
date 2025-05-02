package com.jinelei.numbfish.equipment.api;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.jinelei.numbfish.common.request.PageRequest;
import com.jinelei.numbfish.common.view.BaseView;
import com.jinelei.numbfish.common.view.ListView;
import com.jinelei.numbfish.common.view.PageView;
import com.jinelei.numbfish.equipment.dto.OeeHistoryDeleteRequest;
import com.jinelei.numbfish.equipment.dto.OeeHistoryQueryRequest;
import com.jinelei.numbfish.equipment.dto.OeeHistoryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SuppressWarnings("unused")
@ApiSupport(order = 3)
@Tag(name = "Oee历史管理")
@RequestMapping("/oeeHistory")
@FeignClient(name = "equipment-service", url = "${equipment.service.url}")
public interface OeeHistoryApi {

    /**
     * 删除报警历史
     *
     * @param request 报警历史请求对象
     */
    @ApiOperationSupport(order = 1)
    @Operation(summary = "删除Oee历史")
    @PostMapping("/delete")
    BaseView<Void> delete(@Valid OeeHistoryDeleteRequest request);

    /**
     * 查询报警历史详情
     *
     * @param request 报警历史请求对象
     * @return 报警历史响应对象
     */
    @ApiOperationSupport(order = 2)
    @Operation(summary = "获取Oee历史")
    @PostMapping("/get")
    BaseView<OeeHistoryResponse> get(@Valid OeeHistoryQueryRequest request);

    /**
     * 查询报警历史列表
     *
     * @param request 报警历史请求对象
     * @return 报警历史响应对象列表
     */
    @ApiOperationSupport(order = 3)
    @Operation(summary = "获取Oee历史列表")
    @PostMapping("/list")
    ListView<OeeHistoryResponse> list(@Valid OeeHistoryQueryRequest request);

    /**
     * 查询报警历史分页
     *
     * @param request 报警历史请求对象
     * @return 报警历史响应对象列表
     */
    @ApiOperationSupport(order = 4)
    @Operation(summary = "获取Oee历史分页列表")
    @PostMapping("/page")
    PageView<OeeHistoryResponse> page(@Valid PageRequest<OeeHistoryQueryRequest> request);

}
