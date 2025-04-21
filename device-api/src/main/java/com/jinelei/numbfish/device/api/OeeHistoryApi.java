package com.jinelei.numbfish.device.api;

import com.jinelei.numbfish.common.request.PageRequest;
import com.jinelei.numbfish.common.view.BaseView;
import com.jinelei.numbfish.common.view.ListView;
import com.jinelei.numbfish.common.view.PageView;
import com.jinelei.numbfish.device.dto.OeeHistoryDeleteRequest;
import com.jinelei.numbfish.device.dto.OeeHistoryQueryRequest;
import com.jinelei.numbfish.device.dto.OeeHistoryResponse;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@SuppressWarnings("unused")
@FeignClient(name = "device-service", url = "${device.service.url}")
public interface OeeHistoryApi {

    /**
     * 删除报警历史
     *
     * @param request 报警历史请求对象
     */
    @PostMapping("/oeeHistory/delete")
    BaseView<Void> delete(@Valid OeeHistoryDeleteRequest request);

    /**
     * 查询报警历史详情
     *
     * @param request 报警历史请求对象
     * @return 报警历史响应对象
     */
    @PostMapping("/oeeHistory/get")
    BaseView<OeeHistoryResponse> get(@Valid OeeHistoryQueryRequest request);

    /**
     * 查询报警历史列表
     *
     * @param request 报警历史请求对象
     * @return 报警历史响应对象列表
     */
    @PostMapping("/oeeHistory/list")
    ListView<OeeHistoryResponse> list(@Valid OeeHistoryQueryRequest request);

    /**
     * 查询报警历史分页
     *
     * @param request 报警历史请求对象
     * @return 报警历史响应对象列表
     */
    @PostMapping("/oeeHistory/page")
    PageView<OeeHistoryResponse> page(@Valid PageRequest<OeeHistoryQueryRequest> request);

}
