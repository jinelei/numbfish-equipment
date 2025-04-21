package com.jinelei.numbfish.device.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jinelei.numbfish.device.dto.*;
import com.jinelei.numbfish.device.entity.OeeRuleEntity;

import java.util.List;

@SuppressWarnings("unused")
public interface OeeRuleService extends IService<OeeRuleEntity> {

    void create(OeeRuleCreateRequest request);

    void delete(OeeRuleDeleteRequest request);

    void update(OeeRuleUpdateRequest request);

    OeeRuleEntity get(OeeRuleQueryRequest request);

    List<OeeRuleEntity> list(OeeRuleQueryRequest request);

    IPage<OeeRuleEntity> page(IPage<OeeRuleEntity> page, OeeRuleQueryRequest request);

    OeeRuleResponse convert(OeeRuleEntity entity);

}
