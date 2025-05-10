package com.jinelei.numbfish.equipment.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.jinelei.numbfish.common.helper.PageHelper;
import com.jinelei.numbfish.common.request.PageRequest;
import com.jinelei.numbfish.common.view.BaseView;
import com.jinelei.numbfish.common.view.ListView;
import com.jinelei.numbfish.common.view.PageView;
import com.jinelei.numbfish.equipment.dto.AlarmRuleCreateRequest;
import com.jinelei.numbfish.equipment.dto.AlarmRuleDeleteRequest;
import com.jinelei.numbfish.equipment.dto.AlarmRuleQueryRequest;
import com.jinelei.numbfish.equipment.dto.AlarmRuleResponse;
import com.jinelei.numbfish.equipment.api.AlarmRuleApi;
import com.jinelei.numbfish.equipment.dto.*;
import com.jinelei.numbfish.equipment.entity.AlarmRuleEntity;
import com.jinelei.numbfish.equipment.service.AlarmRuleService;
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
@Validated
@RestController
@RequestMapping("/alarmRule")
public class AlarmRuleController implements AlarmRuleApi {
    private final Logger log = LoggerFactory.getLogger(AlarmRuleController.class);

    @Autowired
    private AlarmRuleService alarmRuleService;

    @Override
    @PostMapping("/create")
    public BaseView<Void> create(@Valid @RequestBody AlarmRuleCreateRequest request) {
        alarmRuleService.create(request);
        return new BaseView<>("创建成功");
    }

    @Override
    @PostMapping("/delete")
    public BaseView<Void> delete(@Valid @RequestBody AlarmRuleDeleteRequest request) {
        alarmRuleService.delete(request);
        return new BaseView<>("删除成功");
    }

    @Override
    @PostMapping("/update")
    public BaseView<Void> update(@Valid @RequestBody AlarmRuleUpdateRequest request) {
        alarmRuleService.update(request);
        return new BaseView<>("更新成功");
    }

    @Override
    @PostMapping("/get")
    public BaseView<AlarmRuleResponse> get(@Valid @RequestBody AlarmRuleQueryRequest request) {
        AlarmRuleEntity entity = alarmRuleService.get(request);
        AlarmRuleResponse convert = alarmRuleService.convert(entity);
        return new BaseView<>(convert);
    }

    @Override
    @PostMapping("/list")
    public ListView<AlarmRuleResponse> list(@Valid @RequestBody AlarmRuleQueryRequest request) {
        List<AlarmRuleEntity> entities = alarmRuleService.list(request);
        List<AlarmRuleResponse> convert = entities.parallelStream().map(entity -> alarmRuleService.convert(entity))
                .collect(Collectors.toList());
        return new ListView<>(convert);
    }

    @Override
    @PostMapping("/page")
    public PageView<AlarmRuleResponse> page(@Valid @RequestBody PageRequest<AlarmRuleQueryRequest> request) {
        IPage<AlarmRuleEntity> page = alarmRuleService.page(PageHelper.toPage(new PageDTO<>(), request),
                Optional.ofNullable(request.getParams()).orElse(new AlarmRuleQueryRequest()));
        List<AlarmRuleResponse> collect = page.getRecords().parallelStream()
                .map(entity -> alarmRuleService.convert(entity))
                .collect(Collectors.toList());
        return new PageView<>(collect, page.getTotal(),  page.getCurrent(), page.getSize());
    }

}
