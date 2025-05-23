package com.jinelei.numbfish.equipment.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.jinelei.numbfish.common.helper.PageHelper;
import com.jinelei.numbfish.common.request.PageRequest;
import com.jinelei.numbfish.common.view.BaseView;
import com.jinelei.numbfish.common.view.ListView;
import com.jinelei.numbfish.common.view.PageView;
import com.jinelei.numbfish.equipment.api.StructureApi;
import com.jinelei.numbfish.equipment.dto.*;
import com.jinelei.numbfish.equipment.entity.StructureEntity;
import com.jinelei.numbfish.equipment.service.StructureService;
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
@RequestMapping("/structure")
public class StructureController implements StructureApi {
    private final Logger log = LoggerFactory.getLogger(StructureController.class);

    @Autowired
    private StructureService structureService;

    @Override
    @PostMapping("/create")
    public BaseView<Void> create(@Valid @RequestBody StructureCreateRequest request) {
        structureService.create(request);
        return new BaseView<>("创建成功");
    }

    @Override
    @PostMapping("/delete")
    public BaseView<Void> delete(@Valid @RequestBody StructureDeleteRequest request) {
        structureService.delete(request);
        return new BaseView<>("删除成功");
    }

    @Override
    @PostMapping("/update")
    public BaseView<Void> update(@Valid @RequestBody StructureUpdateRequest request) {
        structureService.update(request);
        return new BaseView<>("更新成功");
    }

    @Override
    @PostMapping("/get")
    public BaseView<StructureResponse> get(@Valid @RequestBody StructureQueryRequest request) {
        StructureEntity entity = structureService.get(request);
        StructureResponse convert = structureService.convert(entity);
        return new BaseView<>(convert);
    }

    @Override
    @PostMapping("/list")
    public ListView<StructureResponse> list(@Valid @RequestBody StructureQueryRequest request) {
        List<StructureEntity> entities = structureService.list(request);
        List<StructureResponse> convert = entities.parallelStream().map(entity -> structureService.convert(entity))
                .collect(Collectors.toList());
        return new ListView<>(convert);
    }

    @Override
    @PostMapping("/page")
    public PageView<StructureResponse> page(@Valid @RequestBody PageRequest<StructureQueryRequest> request) {
        IPage<StructureEntity> page = structureService.page(PageHelper.toPage(new PageDTO<>(), request),
                Optional.ofNullable(request.getParams()).orElse(new StructureQueryRequest()));
        List<StructureResponse> collect = page.getRecords().parallelStream()
                .map(entity -> structureService.convert(entity))
                .collect(Collectors.toList());
        return new PageView<>(collect, page.getTotal(),  page.getCurrent(), page.getSize());
    }

}
