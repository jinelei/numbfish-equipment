package com.jinelei.numbfish.equipment.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jinelei.numbfish.equipment.dto.OeeHistoryDeleteRequest;
import com.jinelei.numbfish.equipment.dto.OeeHistoryQueryRequest;
import com.jinelei.numbfish.equipment.dto.OeeHistoryResponse;
import com.jinelei.numbfish.equipment.entity.OeeHistoryEntity;

import java.util.List;

@SuppressWarnings("unused")
public interface OeeHistoryService extends IService<OeeHistoryEntity> {

    void delete(OeeHistoryDeleteRequest request);

    OeeHistoryEntity get(OeeHistoryQueryRequest request);

    List<OeeHistoryEntity> list(OeeHistoryQueryRequest request);

    IPage<OeeHistoryEntity> page(IPage<OeeHistoryEntity> page, OeeHistoryQueryRequest request);

    OeeHistoryResponse convert(OeeHistoryEntity entity);

}
