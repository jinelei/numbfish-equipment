package com.jinelei.numbfish.device.api;

import com.jinelei.numbfish.common.request.PageRequest;
import com.jinelei.numbfish.common.view.BaseView;
import com.jinelei.numbfish.common.view.ListView;
import com.jinelei.numbfish.common.view.PageView;
import com.jinelei.numbfish.device.dto.*;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@SuppressWarnings("unused")
@FeignClient(name = "device-service", url = "${device.service.url}")
public interface AlarmRuleApi {

    /**
     * 创建设备
     *
     * @param request 设备请求对象
     * @return 设备响应对象
     */
    @PostMapping("/alarmRule/create")
    BaseView<Void> create(@Valid AlarmRuleCreateRequest request);

    /**
     * 删除设备
     *
     * @param request 设备请求对象
     */
    @PostMapping("/alarmRule/delete")
    BaseView<Void> delete(@Valid AlarmRuleDeleteRequest request);

    /**
     * 更新设备
     *
     * @param request 设备请求对象
     * @return 设备响应对象
     */
    @PostMapping("/alarmRule/update")
    BaseView<Void> update(@Valid AlarmRuleUpdateRequest request);

    /**
     * 查询设备详情
     *
     * @param request 设备请求对象
     * @return 设备响应对象
     */
    @PostMapping("/alarmRule/get")
    BaseView<AlarmRuleResponse> get(@Valid AlarmRuleQueryRequest request);

    /**
     * 查询设备列表
     *
     * @param request 设备请求对象
     * @return 设备响应对象列表
     */
    @PostMapping("/alarmRule/list")
    ListView<AlarmRuleResponse> list(@Valid AlarmRuleQueryRequest request);

    /**
     * 查询设备分页
     *
     * @param request 设备请求对象
     * @return 设备响应对象列表
     */
    @PostMapping("/alarmRule/page")
    PageView<AlarmRuleResponse> page(@Valid PageRequest<AlarmRuleQueryRequest> request);

}
