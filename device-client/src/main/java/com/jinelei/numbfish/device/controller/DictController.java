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
import com.jinelei.numbfish.device.api.DictApi;
import com.jinelei.numbfish.device.dto.*;
import com.jinelei.numbfish.device.entity.DictEntity;
import com.jinelei.numbfish.device.service.DictService;
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
@Tag(name = "字典管理")
@Validated
@RestController
@RequestMapping("/dict")
public class DictController implements DictApi {
    private final Logger log = LoggerFactory.getLogger(DictController.class);

    @Autowired
    private DictService dictService;

    @Override
    @ApiOperationSupport(order = 1)
    @Operation(summary = "创建字典")
    @PostMapping("/create")
    public BaseView<Void> create(@Valid @RequestBody DictCreateRequest request) {
        dictService.create(request);
        return new BaseView<>("创建成功");
    }

    @Override
    @ApiOperationSupport(order = 2)
    @Operation(summary = "删除字典")
    @PostMapping("/delete")
    public BaseView<Void> delete(@Valid @RequestBody DictDeleteRequest request) {
        dictService.delete(request);
        return new BaseView<>("删除成功");
    }

    @Override
    @ApiOperationSupport(order = 3)
    @Operation(summary = "更新字典")
    @PostMapping("/update")
    public BaseView<Void> update(@Valid @RequestBody DictUpdateRequest request) {
        dictService.update(request);
        return new BaseView<>("更新成功");
    }

    @Override
    @ApiOperationSupport(order = 6)
    @Operation(summary = "获取字典")
    @PostMapping("/get")
    public BaseView<DictResponse> get(@Valid @RequestBody DictQueryRequest request) {
        DictEntity entity = dictService.get(request);
        DictResponse convert = dictService.convert(entity);
        return new BaseView<>(convert);
    }

    @Override
    @ApiOperationSupport(order = 7)
    @Operation(summary = "获取字典列表")
    @PostMapping("/list")
    public ListView<DictResponse> list(@Valid @RequestBody DictQueryRequest request) {
        List<DictEntity> entities = dictService.list(request);
        List<DictResponse> convert = entities.parallelStream().map(entity -> dictService.convert(entity))
                .collect(Collectors.toList());
        return new ListView<>(convert);
    }

    @Override
    @ApiOperationSupport(order = 8)
    @Operation(summary = "获取字典分页列表")
    @PostMapping("/page")
    public PageView<DictResponse> page(@Valid @RequestBody PageRequest<DictQueryRequest> request) {
        IPage<DictEntity> page = dictService.page(PageHelper.toPage(new PageDTO<>(), request),
                Optional.ofNullable(request.getParams()).orElse(new DictQueryRequest()));
        List<DictResponse> collect = page.getRecords().parallelStream()
                .map(entity -> dictService.convert(entity))
                .collect(Collectors.toList());
        return new PageView<>(collect, page.getTotal(), page.getPages(), page.getSize());
    }

}
