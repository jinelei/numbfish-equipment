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
@Tag(name = "报警规则管理")
@RequestMapping("/alarmRule")
@FeignClient(name = "device-service", url = "${device.service.url}")
public interface AlarmRuleApi {

    /**
     * 创建报警规则
     *
     * @param request 报警规则请求对象
     * @return 报警规则响应对象
     */
    @ApiOperationSupport(order = 1)
    @Operation(summary = "创建报警规则")
    @PostMapping("/create")
    BaseView<Void> create(@Valid AlarmRuleCreateRequest request);

    /**
     * 删除报警规则
     *
     * @param request 报警规则请求对象
     */
    @ApiOperationSupport(order = 2)
    @Operation(summary = "删除报警规则")
    @PostMapping("/delete")
    BaseView<Void> delete(@Valid AlarmRuleDeleteRequest request);

    /**
     * 更新报警规则
     *
     * @param request 报警规则请求对象
     * @return 报警规则响应对象
     */
    @ApiOperationSupport(order = 3)
    @Operation(summary = "更新报警规则")
    @PostMapping("/update")
    BaseView<Void> update(@Valid AlarmRuleUpdateRequest request);

    /**
     * 查询报警规则详情
     *
     * @param request 报警规则请求对象
     * @return 报警规则响应对象
     */
    @ApiOperationSupport(order = 4)
    @Operation(summary = "获取报警规则")
    @PostMapping("/get")
    BaseView<AlarmRuleResponse> get(@Valid AlarmRuleQueryRequest request);

    /**
     * 查询报警规则列表
     *
     * @param request 报警规则请求对象
     * @return 报警规则响应对象列表
     */
    @ApiOperationSupport(order = 5)
    @Operation(summary = "获取报警规则列表")
    @PostMapping("/list")
    ListView<AlarmRuleResponse> list(@Valid AlarmRuleQueryRequest request);

    /**
     * 查询报警规则分页
     *
     * @param request 报警规则请求对象
     * @return 报警规则响应对象列表
     */
    @ApiOperationSupport(order = 6)
    @Operation(summary = "获取报警规则分页列表")
    @PostMapping("/page")
    PageView<AlarmRuleResponse> page(@Valid PageRequest<AlarmRuleQueryRequest> request);

}
