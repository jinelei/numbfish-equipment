package com.jinelei.numbfish.equipment.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jinelei.numbfish.equipment.dto.*;
import com.jinelei.numbfish.equipment.entity.StructureEntity;

import java.util.List;

@SuppressWarnings("unused")
public interface StructureService extends IService<StructureEntity> {

    void create(StructureCreateRequest request);

    void delete(StructureDeleteRequest request);

    void update(StructureUpdateRequest request);

    StructureEntity get(StructureQueryRequest request);

    List<StructureEntity> list(StructureQueryRequest request);

    IPage<StructureEntity> page(IPage<StructureEntity> page, StructureQueryRequest request);

    StructureResponse convert(StructureEntity entity);

}
