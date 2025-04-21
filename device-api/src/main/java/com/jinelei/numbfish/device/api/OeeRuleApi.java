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
public interface OeeRuleApi {

    /**
     * 创建Oee规则
     *
     * @param request Oee规则请求对象
     * @return Oee规则响应对象
     */
    @PostMapping("/oeeRule/create")
    BaseView<Void> create(@Valid OeeRuleCreateRequest request);

    /**
     * 删除Oee规则
     *
     * @param request Oee规则请求对象
     */
    @PostMapping("/oeeRule/delete")
    BaseView<Void> delete(@Valid OeeRuleDeleteRequest request);

    /**
     * 更新Oee规则
     *
     * @param request Oee规则请求对象
     * @return Oee规则响应对象
     */
    @PostMapping("/oeeRule/update")
    BaseView<Void> update(@Valid OeeRuleUpdateRequest request);

    /**
     * 查询Oee规则详情
     *
     * @param request Oee规则请求对象
     * @return Oee规则响应对象
     */
    @PostMapping("/oeeRule/get")
    BaseView<OeeRuleResponse> get(@Valid OeeRuleQueryRequest request);

    /**
     * 查询Oee规则列表
     *
     * @param request Oee规则请求对象
     * @return Oee规则响应对象列表
     */
    @PostMapping("/oeeRule/list")
    ListView<OeeRuleResponse> list(@Valid OeeRuleQueryRequest request);

    /**
     * 查询Oee规则分页
     *
     * @param request Oee规则请求对象
     * @return Oee规则响应对象列表
     */
    @PostMapping("/oeeRule/page")
    PageView<OeeRuleResponse> page(@Valid PageRequest<OeeRuleQueryRequest> request);

}
