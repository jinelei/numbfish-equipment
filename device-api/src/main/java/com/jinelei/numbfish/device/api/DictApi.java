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
@FeignClient(name = "dict-service", url = "${dict.service.url}")
public interface DictApi {

    /**
     * 创建设备
     *
     * @param request 设备请求对象
     * @return 设备响应对象
     */
    @PostMapping("/dict/create")
    BaseView<Void> create(@Valid DictCreateRequest request);

    /**
     * 删除设备
     *
     * @param request 设备请求对象
     */
    @PostMapping("/dict/delete")
    BaseView<Void> delete(@Valid DictDeleteRequest request);

    /**
     * 更新设备
     *
     * @param request 设备请求对象
     * @return 设备响应对象
     */
    @PostMapping("/dict/update")
    BaseView<Void> update(@Valid DictUpdateRequest request);

    /**
     * 查询设备详情
     *
     * @param request 设备请求对象
     * @return 设备响应对象
     */
    @PostMapping("/dict/get")
    BaseView<DictResponse> get(@Valid DictQueryRequest request);

    /**
     * 查询设备列表
     *
     * @param request 设备请求对象
     * @return 设备响应对象列表
     */
    @PostMapping("/dict/list")
    ListView<DictResponse> list(@Valid DictQueryRequest request);

    /**
     * 查询设备分页
     *
     * @param request 设备请求对象
     * @return 设备响应对象列表
     */
    @PostMapping("/dict/page")
    PageView<DictResponse> page(@Valid PageRequest<DictQueryRequest> request);

}
