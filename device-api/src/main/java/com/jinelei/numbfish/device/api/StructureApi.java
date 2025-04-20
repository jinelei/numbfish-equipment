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
@FeignClient(name = "structure-service", url = "${structure.service.url}")
public interface StructureApi {

    /**
     * 创建设备
     *
     * @param request 设备请求对象
     * @return 设备响应对象
     */
    @PostMapping("/structure/create")
    BaseView<Void> create(@Valid StructureCreateRequest request);

    /**
     * 删除设备
     *
     * @param request 设备请求对象
     */
    @PostMapping("/structure/delete")
    BaseView<Void> delete(@Valid StructureDeleteRequest request);

    /**
     * 更新设备
     *
     * @param request 设备请求对象
     * @return 设备响应对象
     */
    @PostMapping("/structure/update")
    BaseView<Void> update(@Valid StructureUpdateRequest request);

    /**
     * 查询设备详情
     *
     * @param request 设备请求对象
     * @return 设备响应对象
     */
    @PostMapping("/structure/get")
    BaseView<StructureResponse> get(@Valid StructureQueryRequest request);

    /**
     * 查询设备列表
     *
     * @param request 设备请求对象
     * @return 设备响应对象列表
     */
    @PostMapping("/structure/list")
    ListView<StructureResponse> list(@Valid StructureQueryRequest request);

    /**
     * 查询设备分页
     *
     * @param request 设备请求对象
     * @return 设备响应对象列表
     */
    @PostMapping("/structure/page")
    PageView<StructureResponse> page(@Valid PageRequest<StructureQueryRequest> request);

}
