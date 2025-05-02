package com.jinelei.numbfish.equipment.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jinelei.numbfish.equipment.dto.*;
import com.jinelei.numbfish.equipment.entity.AlarmRuleEntity;

import java.util.List;

@SuppressWarnings("unused")
public interface AlarmRuleService extends IService<AlarmRuleEntity> {

    void create(AlarmRuleCreateRequest request);

    void delete(AlarmRuleDeleteRequest request);

    void update(AlarmRuleUpdateRequest request);

    AlarmRuleEntity get(AlarmRuleQueryRequest request);

    List<AlarmRuleEntity> list(AlarmRuleQueryRequest request);

    IPage<AlarmRuleEntity> page(IPage<AlarmRuleEntity> page, AlarmRuleQueryRequest request);

    AlarmRuleResponse convert(AlarmRuleEntity entity);

}
