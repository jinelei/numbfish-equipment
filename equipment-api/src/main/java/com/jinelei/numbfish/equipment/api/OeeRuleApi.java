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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SuppressWarnings("unused")
@ApiSupport(order = 3)
@Tag(name = "Oee规则管理")
@RequestMapping("/oeeRule")
@FeignClient(name = "equipment-service", url = "${equipment.service.url}")
public interface OeeRuleApi {

    /**
     * 创建Oee规则
     *
     * @param request Oee规则请求对象
     * @return Oee规则响应对象
     */
    @ApiOperationSupport(order = 1)
    @Operation(summary = "创建Oee规则")
    @PostMapping("/oeeRule/create")
    BaseView<Void> create(@Valid OeeRuleCreateRequest request);

    /**
     * 删除Oee规则
     *
     * @param request Oee规则请求对象
     */
    @ApiOperationSupport(order = 2)
    @Operation(summary = "删除Oee规则")
    @PostMapping("/oeeRule/delete")
    BaseView<Void> delete(@Valid OeeRuleDeleteRequest request);

    /**
     * 更新Oee规则
     *
     * @param request Oee规则请求对象
     * @return Oee规则响应对象
     */
    @ApiOperationSupport(order = 3)
    @Operation(summary = "更新Oee规则")
    @PostMapping("/oeeRule/update")
    BaseView<Void> update(@Valid OeeRuleUpdateRequest request);

    /**
     * 查询Oee规则详情
     *
     * @param request Oee规则请求对象
     * @return Oee规则响应对象
     */
    @ApiOperationSupport(order = 4)
    @Operation(summary = "获取Oee规则")
    @PostMapping("/oeeRule/get")
    BaseView<OeeRuleResponse> get(@Valid OeeRuleQueryRequest request);

    /**
     * 查询Oee规则列表
     *
     * @param request Oee规则请求对象
     * @return Oee规则响应对象列表
     */
    @ApiOperationSupport(order = 5)
    @Operation(summary = "获取Oee规则列表")
    @PostMapping("/oeeRule/list")
    ListView<OeeRuleResponse> list(@Valid OeeRuleQueryRequest request);

    /**
     * 查询Oee规则分页
     *
     * @param request Oee规则请求对象
     * @return Oee规则响应对象列表
     */
    @ApiOperationSupport(order = 6)
    @Operation(summary = "获取Oee规则分页列表")
    @PostMapping("/oeeRule/page")
    PageView<OeeRuleResponse> page(@Valid PageRequest<OeeRuleQueryRequest> request);

}
