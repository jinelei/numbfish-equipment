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
import com.jinelei.numbfish.device.api.OeeRuleApi;
import com.jinelei.numbfish.device.dto.*;
import com.jinelei.numbfish.device.entity.OeeRuleEntity;
import com.jinelei.numbfish.device.service.OeeRuleService;
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
@Tag(name = "Oee规则管理")
@Validated
@RestController
@RequestMapping("/oeeRule")
public class OeeRuleController implements OeeRuleApi {
    private final Logger log = LoggerFactory.getLogger(OeeRuleController.class);

    @Autowired
    private OeeRuleService alarmRuleService;

    @Override
    @ApiOperationSupport(order = 1)
    @Operation(summary = "创建Oee规则")
    @PostMapping("/create")
    public BaseView<Void> create(@Valid @RequestBody OeeRuleCreateRequest request) {
        alarmRuleService.create(request);
        return new BaseView<>("创建成功");
    }

    @Override
    @ApiOperationSupport(order = 2)
    @Operation(summary = "删除Oee规则")
    @PostMapping("/delete")
    public BaseView<Void> delete(@Valid @RequestBody OeeRuleDeleteRequest request) {
        alarmRuleService.delete(request);
        return new BaseView<>("删除成功");
    }

    @Override
    @ApiOperationSupport(order = 3)
    @Operation(summary = "更新Oee规则")
    @PostMapping("/update")
    public BaseView<Void> update(@Valid @RequestBody OeeRuleUpdateRequest request) {
        alarmRuleService.update(request);
        return new BaseView<>("更新成功");
    }

    @Override
    @ApiOperationSupport(order = 6)
    @Operation(summary = "获取Oee规则")
    @PostMapping("/get")
    public BaseView<OeeRuleResponse> get(@Valid @RequestBody OeeRuleQueryRequest request) {
        OeeRuleEntity entity = alarmRuleService.get(request);
        OeeRuleResponse convert = alarmRuleService.convert(entity);
        return new BaseView<>(convert);
    }

    @Override
    @ApiOperationSupport(order = 7)
    @Operation(summary = "获取Oee规则列表")
    @PostMapping("/list")
    public ListView<OeeRuleResponse> list(@Valid @RequestBody OeeRuleQueryRequest request) {
        List<OeeRuleEntity> entities = alarmRuleService.list(request);
        List<OeeRuleResponse> convert = entities.parallelStream().map(entity -> alarmRuleService.convert(entity))
                .collect(Collectors.toList());
        return new ListView<>(convert);
    }

    @Override
    @ApiOperationSupport(order = 8)
    @Operation(summary = "获取Oee规则分页列表")
    @PostMapping("/page")
    public PageView<OeeRuleResponse> page(@Valid @RequestBody PageRequest<OeeRuleQueryRequest> request) {
        IPage<OeeRuleEntity> page = alarmRuleService.page(PageHelper.toPage(new PageDTO<>(), request),
                Optional.ofNullable(request.getParams()).orElse(new OeeRuleQueryRequest()));
        List<OeeRuleResponse> collect = page.getRecords().parallelStream()
                .map(entity -> alarmRuleService.convert(entity))
                .collect(Collectors.toList());
        return new PageView<>(collect, page.getTotal(), page.getPages(), page.getSize());
    }

}
