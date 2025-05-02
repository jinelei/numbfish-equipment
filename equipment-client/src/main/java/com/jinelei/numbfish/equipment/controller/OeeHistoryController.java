package com.jinelei.numbfish.equipment.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.jinelei.numbfish.common.helper.PageHelper;
import com.jinelei.numbfish.common.request.PageRequest;
import com.jinelei.numbfish.common.view.BaseView;
import com.jinelei.numbfish.common.view.ListView;
import com.jinelei.numbfish.common.view.PageView;
import com.jinelei.numbfish.device.api.OeeHistoryApi;
import com.jinelei.numbfish.device.dto.OeeHistoryDeleteRequest;
import com.jinelei.numbfish.device.dto.OeeHistoryQueryRequest;
import com.jinelei.numbfish.device.dto.OeeHistoryResponse;
import com.jinelei.numbfish.device.entity.OeeHistoryEntity;
import com.jinelei.numbfish.device.service.OeeHistoryService;
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
@RequestMapping("/oeeHistory")
public class OeeHistoryController implements OeeHistoryApi {
    private final Logger log = LoggerFactory.getLogger(OeeHistoryController.class);

    @Autowired
    private OeeHistoryService alarmHistoryService;

    @Override
    @PostMapping("/delete")
    public BaseView<Void> delete(@Valid @RequestBody OeeHistoryDeleteRequest request) {
        alarmHistoryService.delete(request);
        return new BaseView<>("删除成功");
    }

    @Override
    @PostMapping("/get")
    public BaseView<OeeHistoryResponse> get(@Valid @RequestBody OeeHistoryQueryRequest request) {
        OeeHistoryEntity entity = alarmHistoryService.get(request);
        OeeHistoryResponse convert = alarmHistoryService.convert(entity);
        return new BaseView<>(convert);
    }

    @Override
    @PostMapping("/list")
    public ListView<OeeHistoryResponse> list(@Valid @RequestBody OeeHistoryQueryRequest request) {
        List<OeeHistoryEntity> entities = alarmHistoryService.list(request);
        List<OeeHistoryResponse> convert = entities.parallelStream().map(entity -> alarmHistoryService.convert(entity))
                .collect(Collectors.toList());
        return new ListView<>(convert);
    }

    @Override
    @PostMapping("/page")
    public PageView<OeeHistoryResponse> page(@Valid @RequestBody PageRequest<OeeHistoryQueryRequest> request) {
        IPage<OeeHistoryEntity> page = alarmHistoryService.page(PageHelper.toPage(new PageDTO<>(), request),
                Optional.ofNullable(request.getParams()).orElse(new OeeHistoryQueryRequest()));
        List<OeeHistoryResponse> collect = page.getRecords().parallelStream()
                .map(entity -> alarmHistoryService.convert(entity))
                .collect(Collectors.toList());
        return new PageView<>(collect, page.getTotal(), page.getPages(), page.getSize());
    }

}
