package com.jinelei.numbfish.equipment.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jinelei.numbfish.equipment.dto.*;
import com.jinelei.numbfish.equipment.entity.DictEntity;

import java.util.List;

@SuppressWarnings("unused")
public interface DictService extends IService<DictEntity> {

    void create(DictCreateRequest request);

    void delete(DictDeleteRequest request);

    void update(DictUpdateRequest request);

    DictEntity get(DictQueryRequest request);

    List<DictEntity> list(DictQueryRequest request);

    IPage<DictEntity> page(IPage<DictEntity> page, DictQueryRequest request);

    DictResponse convert(DictEntity entity);

}
