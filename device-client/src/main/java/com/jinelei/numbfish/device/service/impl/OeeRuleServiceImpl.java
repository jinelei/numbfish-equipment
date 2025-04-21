package com.jinelei.numbfish.device.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jinelei.numbfish.common.exception.InvalidArgsException;
import com.jinelei.numbfish.common.helper.Snowflake;
import com.jinelei.numbfish.device.convertor.OeeRuleConvertor;
import com.jinelei.numbfish.device.dto.*;
import com.jinelei.numbfish.device.entity.OeeRuleEntity;
import com.jinelei.numbfish.device.mapper.OeeRuleMapper;
import com.jinelei.numbfish.device.service.OeeRuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@SuppressWarnings("unused")
@Service
public class OeeRuleServiceImpl extends ServiceImpl<OeeRuleMapper, OeeRuleEntity>
        implements OeeRuleService {
    private static final Logger log = LoggerFactory.getLogger(OeeRuleServiceImpl.class);
    protected Snowflake snowflake = Snowflake.DEFAULT;

    @Autowired
    protected OeeRuleConvertor structureConvertor;

    @Override
    public void create(OeeRuleCreateRequest request) {
        final OeeRuleEntity entity = structureConvertor.entityFromCreateRequest(request);
        Optional.ofNullable(entity).orElseThrow(() -> new InvalidArgsException("Oee规则信息不合法"));
        int inserted = baseMapper.insert(entity);
        Assert.state(inserted == 1, "Oee规则创建失败");
    }

    @Override
    public void delete(OeeRuleDeleteRequest request) {
        if (Objects.nonNull(request.getId())) {
            int deleted = baseMapper.deleteById(request.getId());
            Assert.state(deleted == 1, "Oee规则删除失败");
        } else if (!CollectionUtils.isEmpty(request.getIds())) {
            int deleted = baseMapper.deleteByIds(request.getIds());
            Assert.state(deleted == request.getIds().size(), "Oee规则删除失败");
        }
    }

    @Override
    public void update(@Validated OeeRuleUpdateRequest request) {
        LambdaUpdateWrapper<OeeRuleEntity> wrapper = Wrappers.lambdaUpdate(OeeRuleEntity.class);
        wrapper.eq(OeeRuleEntity::getId, request.getId());
        wrapper.set(OeeRuleEntity::getName, request.getName());
        wrapper.set(OeeRuleEntity::getCode, request.getCode());
        wrapper.set(OeeRuleEntity::getRemark, request.getRemark());
        int updated = baseMapper.update(wrapper);
        Assert.state(updated == 1, "Oee规则更新失败");
    }

    @Override
    public OeeRuleEntity get(OeeRuleQueryRequest request) {
        LambdaQueryWrapper<OeeRuleEntity> wrapper = Wrappers.lambdaQuery(OeeRuleEntity.class);
        wrapper.eq(Objects.nonNull(request.getId()), OeeRuleEntity::getId, request.getId());
        wrapper.eq(Objects.nonNull(request.getName()), OeeRuleEntity::getName, request.getName());
        wrapper.eq(Objects.nonNull(request.getCode()), OeeRuleEntity::getCode, request.getCode());
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public List<OeeRuleEntity> list(OeeRuleQueryRequest request) {
        LambdaQueryWrapper<OeeRuleEntity> wrapper = Wrappers.lambdaQuery(OeeRuleEntity.class);
        wrapper.eq(Objects.nonNull(request.getId()), OeeRuleEntity::getId, request.getId());
        wrapper.eq(Objects.nonNull(request.getName()), OeeRuleEntity::getName, request.getName());
        wrapper.eq(Objects.nonNull(request.getCode()), OeeRuleEntity::getCode, request.getCode());
        return baseMapper.selectList(wrapper);
    }

    @Override
    public IPage<OeeRuleEntity> page(IPage<OeeRuleEntity> page, OeeRuleQueryRequest request) {
        LambdaQueryWrapper<OeeRuleEntity> wrapper = Wrappers.lambdaQuery(OeeRuleEntity.class);
        wrapper.eq(Objects.nonNull(request.getId()), OeeRuleEntity::getId, request.getId());
        wrapper.eq(Objects.nonNull(request.getName()), OeeRuleEntity::getName, request.getName());
        wrapper.eq(Objects.nonNull(request.getCode()), OeeRuleEntity::getCode, request.getCode());
        return baseMapper.selectPage(page, wrapper);
    }

    @Override
    public OeeRuleResponse convert(OeeRuleEntity entity) {
        return structureConvertor.entityToResponse(entity);
    }

}
