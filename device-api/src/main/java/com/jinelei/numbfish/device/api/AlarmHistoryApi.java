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
public interface AlarmHistoryApi {

    /**
     * 删除报警历史
     *
     * @param request 报警历史请求对象
     */
    @PostMapping("/alarmRule/delete")
    BaseView<Void> delete(@Valid AlarmHistoryDeleteRequest request);

    /**
     * 查询报警历史详情
     *
     * @param request 报警历史请求对象
     * @return 报警历史响应对象
     */
    @PostMapping("/alarmRule/get")
    BaseView<AlarmHistoryResponse> get(@Valid AlarmHistoryQueryRequest request);

    /**
     * 查询报警历史列表
     *
     * @param request 报警历史请求对象
     * @return 报警历史响应对象列表
     */
    @PostMapping("/alarmRule/list")
    ListView<AlarmHistoryResponse> list(@Valid AlarmHistoryQueryRequest request);

    /**
     * 查询报警历史分页
     *
     * @param request 报警历史请求对象
     * @return 报警历史响应对象列表
     */
    @PostMapping("/alarmRule/page")
    PageView<AlarmHistoryResponse> page(@Valid PageRequest<AlarmHistoryQueryRequest> request);

}
