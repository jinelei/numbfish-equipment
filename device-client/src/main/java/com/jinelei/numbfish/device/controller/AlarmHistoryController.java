package com.jinelei.numbfish.device.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.jinelei.numbfish.common.helper.PageHelper;
import com.jinelei.numbfish.common.request.PageRequest;
import com.jinelei.numbfish.common.view.BaseView;
import com.jinelei.numbfish.common.view.ListView;
import com.jinelei.numbfish.common.view.PageView;
import com.jinelei.numbfish.device.api.AlarmHistoryApi;
import com.jinelei.numbfish.device.dto.*;
import com.jinelei.numbfish.device.entity.AlarmHistoryEntity;
import com.jinelei.numbfish.device.service.AlarmHistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
@ApiSupport(order = 3)
@Tag(name = "报警历史管理")
@Validated
@RestController
@RequestMapping("/dict")
public class AlarmHistoryController implements AlarmHistoryApi {
    private final Logger log = LoggerFactory.getLogger(AlarmHistoryController.class);

    @Autowired
    private AlarmHistoryService alarmHistoryService;

    @Override
    @ApiOperationSupport(order = 1)
    @Operation(summary = "删除报警历史")
    @PostMapping("/delete")
    public BaseView<Void> delete(@Valid @RequestBody AlarmHistoryDeleteRequest request) {
        alarmHistoryService.delete(request);
        return new BaseView<>("删除成功");
    }

    @Override
    @ApiOperationSupport(order = 2)
    @Operation(summary = "获取报警历史")
    @PostMapping("/get")
    public BaseView<AlarmHistoryResponse> get(@Valid @RequestBody AlarmHistoryQueryRequest request) {
        AlarmHistoryEntity entity = alarmHistoryService.get(request);
        AlarmHistoryResponse convert = alarmHistoryService.convert(entity);
        return new BaseView<>(convert);
    }

    @Override
    @ApiOperationSupport(order = 3)
    @Operation(summary = "获取报警历史列表")
    @PostMapping("/list")
    public ListView<AlarmHistoryResponse> list(@Valid @RequestBody AlarmHistoryQueryRequest request) {
        List<AlarmHistoryEntity> entities = alarmHistoryService.list(request);
        List<AlarmHistoryResponse> convert = entities.parallelStream().map(entity -> alarmHistoryService.convert(entity))
                .collect(Collectors.toList());
        return new ListView<>(convert);
    }

    @Override
    @ApiOperationSupport(order = 4)
    @Operation(summary = "获取报警历史分页列表")
    @PostMapping("/page")
    public PageView<AlarmHistoryResponse> page(@Valid @RequestBody PageRequest<AlarmHistoryQueryRequest> request) {
        IPage<AlarmHistoryEntity> page = alarmHistoryService.page(PageHelper.toPage(new PageDTO<>(), request),
                Optional.ofNullable(request.getParams()).orElse(new AlarmHistoryQueryRequest()));
        List<AlarmHistoryResponse> collect = page.getRecords().parallelStream()
                .map(entity -> alarmHistoryService.convert(entity))
                .collect(Collectors.toList());
        return new PageView<>(collect, page.getTotal(), page.getPages(), page.getSize());
    }

}
