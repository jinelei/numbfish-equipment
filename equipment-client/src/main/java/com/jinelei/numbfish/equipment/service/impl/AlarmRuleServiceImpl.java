package com.jinelei.numbfish.equipment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jinelei.numbfish.common.exception.InvalidArgsException;
import com.jinelei.numbfish.common.helper.Snowflake;
import com.jinelei.numbfish.equipment.convertor.AlarmRuleConvertor;
import com.jinelei.numbfish.equipment.dto.*;
import com.jinelei.numbfish.equipment.entity.AlarmRuleEntity;
import com.jinelei.numbfish.equipment.mapper.AlarmRuleMapper;
import com.jinelei.numbfish.equipment.service.AlarmRuleService;
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
public class AlarmRuleServiceImpl extends ServiceImpl<AlarmRuleMapper, AlarmRuleEntity>
        implements AlarmRuleService {
    private static final Logger log = LoggerFactory.getLogger(AlarmRuleServiceImpl.class);
    protected Snowflake snowflake = Snowflake.DEFAULT;

    @Autowired
    protected AlarmRuleConvertor structureConvertor;

    @Override
    public void create(AlarmRuleCreateRequest request) {
        final AlarmRuleEntity entity = structureConvertor.entityFromCreateRequest(request);
        Optional.ofNullable(entity).orElseThrow(() -> new InvalidArgsException("报警规则信息不合法"));
        int inserted = baseMapper.insert(entity);
        Assert.state(inserted == 1, "报警规则创建失败");
    }

    @Override
    public void delete(AlarmRuleDeleteRequest request) {
        if (Objects.nonNull(request.getId())) {
            int deleted = baseMapper.deleteById(request.getId());
            Assert.state(deleted == 1, "报警规则删除失败");
        } else if (!CollectionUtils.isEmpty(request.getIds())) {
            int deleted = baseMapper.deleteByIds(request.getIds());
            Assert.state(deleted == request.getIds().size(), "报警规则删除失败");
        }
    }

    @Override
    public void update(@Validated AlarmRuleUpdateRequest request) {
        LambdaUpdateWrapper<AlarmRuleEntity> wrapper = Wrappers.lambdaUpdate(AlarmRuleEntity.class);
        wrapper.eq(AlarmRuleEntity::getId, request.getId());
        wrapper.set(AlarmRuleEntity::getName, request.getName());
        wrapper.set(AlarmRuleEntity::getCode, request.getCode());
        wrapper.set(AlarmRuleEntity::getRemark, request.getRemark());
        int updated = baseMapper.update(wrapper);
        Assert.state(updated == 1, "报警规则更新失败");
    }

    @Override
    public AlarmRuleEntity get(AlarmRuleQueryRequest request) {
        LambdaQueryWrapper<AlarmRuleEntity> wrapper = Wrappers.lambdaQuery(AlarmRuleEntity.class);
        wrapper.eq(Objects.nonNull(request.getId()), AlarmRuleEntity::getId, request.getId());
        wrapper.eq(Objects.nonNull(request.getName()), AlarmRuleEntity::getName, request.getName());
        wrapper.eq(Objects.nonNull(request.getCode()), AlarmRuleEntity::getCode, request.getCode());
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public List<AlarmRuleEntity> list(AlarmRuleQueryRequest request) {
        LambdaQueryWrapper<AlarmRuleEntity> wrapper = Wrappers.lambdaQuery(AlarmRuleEntity.class);
        wrapper.eq(Objects.nonNull(request.getId()), AlarmRuleEntity::getId, request.getId());
        wrapper.eq(Objects.nonNull(request.getName()), AlarmRuleEntity::getName, request.getName());
        wrapper.eq(Objects.nonNull(request.getCode()), AlarmRuleEntity::getCode, request.getCode());
        return baseMapper.selectList(wrapper);
    }

    @Override
    public IPage<AlarmRuleEntity> page(IPage<AlarmRuleEntity> page, AlarmRuleQueryRequest request) {
        LambdaQueryWrapper<AlarmRuleEntity> wrapper = Wrappers.lambdaQuery(AlarmRuleEntity.class);
        wrapper.eq(Objects.nonNull(request.getId()), AlarmRuleEntity::getId, request.getId());
        wrapper.eq(Objects.nonNull(request.getName()), AlarmRuleEntity::getName, request.getName());
        wrapper.eq(Objects.nonNull(request.getCode()), AlarmRuleEntity::getCode, request.getCode());
        return baseMapper.selectPage(page, wrapper);
    }

    @Override
    public AlarmRuleResponse convert(AlarmRuleEntity entity) {
        return structureConvertor.entityToResponse(entity);
    }

}
