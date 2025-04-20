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
import com.jinelei.numbfish.device.api.StructureApi;
import com.jinelei.numbfish.device.dto.*;
import com.jinelei.numbfish.device.entity.StructureEntity;
import com.jinelei.numbfish.device.service.StructureService;
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
@ApiSupport(order = 2)
@Tag(name = "结构管理")
@Validated
@RestController
@RequestMapping("/structure")
public class StructureController implements StructureApi {
    private final Logger log = LoggerFactory.getLogger(StructureController.class);

    @Autowired
    private StructureService structureService;

    @Override
    @ApiOperationSupport(order = 1)
    @Operation(summary = "创建结构")
    @PostMapping("/create")
    public BaseView<Void> create(@Valid @RequestBody StructureCreateRequest request) {
        structureService.create(request);
        return new BaseView<>("创建成功");
    }

    @Override
    @ApiOperationSupport(order = 2)
    @Operation(summary = "删除结构")
    @PostMapping("/delete")
    public BaseView<Void> delete(@Valid @RequestBody StructureDeleteRequest request) {
        structureService.delete(request);
        return new BaseView<>("删除成功");
    }

    @Override
    @ApiOperationSupport(order = 3)
    @Operation(summary = "更新结构")
    @PostMapping("/update")
    public BaseView<Void> update(@Valid @RequestBody StructureUpdateRequest request) {
        structureService.update(request);
        return new BaseView<>("更新成功");
    }

    @Override
    @ApiOperationSupport(order = 6)
    @Operation(summary = "获取结构")
    @PostMapping("/get")
    public BaseView<StructureResponse> get(@Valid @RequestBody StructureQueryRequest request) {
        StructureEntity entity = structureService.get(request);
        StructureResponse convert = structureService.convert(entity);
        return new BaseView<>(convert);
    }

    @Override
    @ApiOperationSupport(order = 7)
    @Operation(summary = "获取结构列表")
    @PostMapping("/list")
    public ListView<StructureResponse> list(@Valid @RequestBody StructureQueryRequest request) {
        List<StructureEntity> entities = structureService.list(request);
        List<StructureResponse> convert = entities.parallelStream().map(entity -> structureService.convert(entity))
                .collect(Collectors.toList());
        return new ListView<>(convert);
    }

    @Override
    @ApiOperationSupport(order = 8)
    @Operation(summary = "获取结构分页列表")
    @PostMapping("/page")
    public PageView<StructureResponse> page(@Valid @RequestBody PageRequest<StructureQueryRequest> request) {
        IPage<StructureEntity> page = structureService.page(PageHelper.toPage(new PageDTO<>(), request),
                Optional.ofNullable(request.getParams()).orElse(new StructureQueryRequest()));
        List<StructureResponse> collect = page.getRecords().parallelStream()
                .map(entity -> structureService.convert(entity))
                .collect(Collectors.toList());
        return new PageView<>(collect, page.getTotal(), page.getPages(), page.getSize());
    }

}
