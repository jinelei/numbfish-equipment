package com.jinelei.numbfish.device.api;

import com.jinelei.numbfish.common.view.BaseView;
import com.jinelei.numbfish.device.dto.DeviceRunningStateUpdateRequest;
import jakarta.validation.Valid;

@SuppressWarnings("unused")
public interface DeviceApi {

    /**
     * 更新设备状态
     *
     * @param request 客户端请求对象
     * @return 客户端响应对象
     */
    BaseView<Void> updateRunningState(@Valid DeviceRunningStateUpdateRequest request);

}
