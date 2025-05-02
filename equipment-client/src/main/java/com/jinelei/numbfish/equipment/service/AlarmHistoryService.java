package com.jinelei.numbfish.equipment.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jinelei.numbfish.equipment.dto.*;
import com.jinelei.numbfish.equipment.entity.AlarmHistoryEntity;

import java.util.List;

@SuppressWarnings("unused")
public interface AlarmHistoryService extends IService<AlarmHistoryEntity> {

    void delete(AlarmHistoryDeleteRequest request);

    AlarmHistoryEntity get(AlarmHistoryQueryRequest request);

    List<AlarmHistoryEntity> list(AlarmHistoryQueryRequest request);

    IPage<AlarmHistoryEntity> page(IPage<AlarmHistoryEntity> page, AlarmHistoryQueryRequest request);

    AlarmHistoryResponse convert(AlarmHistoryEntity entity);

}
