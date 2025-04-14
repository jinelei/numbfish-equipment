package com.jinelei.numbfish.device.client.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.jinelei.numbfish.common.view.BaseView;
import com.jinelei.numbfish.device.api.DeviceApi;
import com.jinelei.numbfish.device.dto.DeviceRunningStateUpdateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@ApiSupport(order = 3)
@Tag(name = "设备管理")
@Validated
@RestController
@RequestMapping("/device")
public class DeviceController implements DeviceApi {
    private final Logger log = LoggerFactory.getLogger(DeviceController.class);

    @Override
    @ApiOperationSupport(order = 1)
    @Operation(summary = "更新设备运行状态")
    @PostMapping("/updateRunningState")
    public BaseView<Void> updateRunningState(@RequestBody DeviceRunningStateUpdateRequest request) {
        log.info("更新设备状态: {}", request);
        return new BaseView<>("更新成功");
    }

}
