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
@Tag(name = "报警历史管理")
@RequestMapping("/alarmHistory")
@FeignClient(name = "device-service", url = "${device.service.url}")
public interface AlarmHistoryApi {

    /**
     * 删除报警历史
     *
     * @param request 报警历史请求对象
     */
    @ApiOperationSupport(order = 1)
    @Operation(summary = "删除报警历史")
    @PostMapping("/delete")
    BaseView<Void> delete(@Valid AlarmHistoryDeleteRequest request);

    /**
     * 查询报警历史详情
     *
     * @param request 报警历史请求对象
     * @return 报警历史响应对象
     */
    @ApiOperationSupport(order = 2)
    @Operation(summary = "获取报警历史")
    @PostMapping("/get")
    BaseView<AlarmHistoryResponse> get(@Valid AlarmHistoryQueryRequest request);

    /**
     * 查询报警历史列表
     *
     * @param request 报警历史请求对象
     * @return 报警历史响应对象列表
     */
    @ApiOperationSupport(order = 3)
    @Operation(summary = "获取报警历史列表")
    @PostMapping("/list")
    ListView<AlarmHistoryResponse> list(@Valid AlarmHistoryQueryRequest request);

    /**
     * 查询报警历史分页
     *
     * @param request 报警历史请求对象
     * @return 报警历史响应对象列表
     */
    @ApiOperationSupport(order = 4)
    @Operation(summary = "获取报警历史分页列表")
    @PostMapping("/page")
    PageView<AlarmHistoryResponse> page(@Valid PageRequest<AlarmHistoryQueryRequest> request);

}
