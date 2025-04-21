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
import com.jinelei.numbfish.device.api.AlarmRuleApi;
import com.jinelei.numbfish.device.dto.*;
import com.jinelei.numbfish.device.entity.AlarmRuleEntity;
import com.jinelei.numbfish.device.service.AlarmRuleService;
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
@Tag(name = "报警规则管理")
@Validated
@RestController
@RequestMapping("/alarmRule")
public class AlarmRuleController implements AlarmRuleApi {
    private final Logger log = LoggerFactory.getLogger(AlarmRuleController.class);

    @Autowired
    private AlarmRuleService alarmRuleService;

    @Override
    @ApiOperationSupport(order = 1)
    @Operation(summary = "创建报警规则")
    @PostMapping("/create")
    public BaseView<Void> create(@Valid @RequestBody AlarmRuleCreateRequest request) {
        alarmRuleService.create(request);
        return new BaseView<>("创建成功");
    }

    @Override
    @ApiOperationSupport(order = 2)
    @Operation(summary = "删除报警规则")
    @PostMapping("/delete")
    public BaseView<Void> delete(@Valid @RequestBody AlarmRuleDeleteRequest request) {
        alarmRuleService.delete(request);
        return new BaseView<>("删除成功");
    }

    @Override
    @ApiOperationSupport(order = 3)
    @Operation(summary = "更新报警规则")
    @PostMapping("/update")
    public BaseView<Void> update(@Valid @RequestBody AlarmRuleUpdateRequest request) {
        alarmRuleService.update(request);
        return new BaseView<>("更新成功");
    }

    @Override
    @ApiOperationSupport(order = 6)
    @Operation(summary = "获取报警规则")
    @PostMapping("/get")
    public BaseView<AlarmRuleResponse> get(@Valid @RequestBody AlarmRuleQueryRequest request) {
        AlarmRuleEntity entity = alarmRuleService.get(request);
        AlarmRuleResponse convert = alarmRuleService.convert(entity);
        return new BaseView<>(convert);
    }

    @Override
    @ApiOperationSupport(order = 7)
    @Operation(summary = "获取报警规则列表")
    @PostMapping("/list")
    public ListView<AlarmRuleResponse> list(@Valid @RequestBody AlarmRuleQueryRequest request) {
        List<AlarmRuleEntity> entities = alarmRuleService.list(request);
        List<AlarmRuleResponse> convert = entities.parallelStream().map(entity -> alarmRuleService.convert(entity))
                .collect(Collectors.toList());
        return new ListView<>(convert);
    }

    @Override
    @ApiOperationSupport(order = 8)
    @Operation(summary = "获取报警规则分页列表")
    @PostMapping("/page")
    public PageView<AlarmRuleResponse> page(@Valid @RequestBody PageRequest<AlarmRuleQueryRequest> request) {
        IPage<AlarmRuleEntity> page = alarmRuleService.page(PageHelper.toPage(new PageDTO<>(), request),
                Optional.ofNullable(request.getParams()).orElse(new AlarmRuleQueryRequest()));
        List<AlarmRuleResponse> collect = page.getRecords().parallelStream()
                .map(entity -> alarmRuleService.convert(entity))
                .collect(Collectors.toList());
        return new PageView<>(collect, page.getTotal(), page.getPages(), page.getSize());
    }

}
