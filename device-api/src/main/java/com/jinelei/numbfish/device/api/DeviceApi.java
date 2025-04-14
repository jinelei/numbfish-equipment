package com.jinelei.numbfish.device.api;

import com.jinelei.numbfish.common.view.BaseView;
import com.jinelei.numbfish.device.dto.DeviceRunningStateUpdateRequest;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SuppressWarnings("unused")
@FeignClient(name = "device-service", url = "${device.service.url}")
public interface DeviceApi {

    /**
     * 更新设备状态
     *
     * @param request 客户端请求对象
     * @return 客户端响应对象
     */
    @PostMapping("/device/updateRunningState")
    BaseView<Void> updateRunningState(@RequestBody @Valid DeviceRunningStateUpdateRequest request);

}
