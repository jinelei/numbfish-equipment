package com.jinelei.numbfish.device.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jinelei.numbfish.device.dto.OeeHistoryDeleteRequest;
import com.jinelei.numbfish.device.dto.OeeHistoryQueryRequest;
import com.jinelei.numbfish.device.dto.OeeHistoryResponse;
import com.jinelei.numbfish.device.entity.OeeHistoryEntity;

import java.util.List;

@SuppressWarnings("unused")
public interface OeeHistoryService extends IService<OeeHistoryEntity> {

    void delete(OeeHistoryDeleteRequest request);

    OeeHistoryEntity get(OeeHistoryQueryRequest request);

    List<OeeHistoryEntity> list(OeeHistoryQueryRequest request);

    IPage<OeeHistoryEntity> page(IPage<OeeHistoryEntity> page, OeeHistoryQueryRequest request);

    OeeHistoryResponse convert(OeeHistoryEntity entity);

}
