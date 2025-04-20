package com.jinelei.numbfish.device.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jinelei.numbfish.common.exception.InvalidArgsException;
import com.jinelei.numbfish.common.helper.Snowflake;
import com.jinelei.numbfish.device.convertor.StructureConvertor;
import com.jinelei.numbfish.device.dto.*;
import com.jinelei.numbfish.device.entity.StructureEntity;
import com.jinelei.numbfish.device.mapper.StructureMapper;
import com.jinelei.numbfish.device.service.StructureService;
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
public class StructureServiceImpl extends ServiceImpl<StructureMapper, StructureEntity>
        implements StructureService {
    private static final Logger log = LoggerFactory.getLogger(StructureServiceImpl.class);
    protected Snowflake snowflake = Snowflake.DEFAULT;

    @Autowired
    protected StructureConvertor structureConvertor;

    @Override
    public void create(StructureCreateRequest request) {
        final StructureEntity entity = structureConvertor.entityFromCreateRequest(request);
        Optional.ofNullable(entity).orElseThrow(() -> new InvalidArgsException("结构信息不合法"));
        int inserted = baseMapper.insert(entity);
        Assert.state(inserted == 1, "结构创建失败");
    }

    @Override
    public void delete(StructureDeleteRequest request) {
        if (Objects.nonNull(request.getId())) {
            int deleted = baseMapper.deleteById(request.getId());
            Assert.state(deleted == 1, "结构删除失败");
        } else if (!CollectionUtils.isEmpty(request.getIds())) {
            int deleted = baseMapper.deleteByIds(request.getIds());
            Assert.state(deleted == request.getIds().size(), "结构删除失败");
        }
    }

    @Override
    public void update(@Validated StructureUpdateRequest request) {
        LambdaUpdateWrapper<StructureEntity> wrapper = Wrappers.lambdaUpdate(StructureEntity.class);
        wrapper.eq(StructureEntity::getId, request.getId());
        wrapper.set(StructureEntity::getName, request.getName());
        wrapper.set(StructureEntity::getCode, request.getCode());
        wrapper.set(StructureEntity::getRemark, request.getRemark());
        int updated = baseMapper.update(wrapper);
        Assert.state(updated == 1, "结构更新失败");
    }

    @Override
    public StructureEntity get(StructureQueryRequest request) {
        LambdaQueryWrapper<StructureEntity> wrapper = Wrappers.lambdaQuery(StructureEntity.class);
        wrapper.eq(Objects.nonNull(request.getId()), StructureEntity::getId, request.getId());
        wrapper.eq(Objects.nonNull(request.getName()), StructureEntity::getName, request.getName());
        wrapper.eq(Objects.nonNull(request.getCode()), StructureEntity::getCode, request.getCode());
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public List<StructureEntity> list(StructureQueryRequest request) {
        LambdaQueryWrapper<StructureEntity> wrapper = Wrappers.lambdaQuery(StructureEntity.class);
        wrapper.eq(Objects.nonNull(request.getId()), StructureEntity::getId, request.getId());
        wrapper.eq(Objects.nonNull(request.getName()), StructureEntity::getName, request.getName());
        wrapper.eq(Objects.nonNull(request.getCode()), StructureEntity::getCode, request.getCode());
        return baseMapper.selectList(wrapper);
    }

    @Override
    public IPage<StructureEntity> page(IPage<StructureEntity> page, StructureQueryRequest request) {
        LambdaQueryWrapper<StructureEntity> wrapper = Wrappers.lambdaQuery(StructureEntity.class);
        wrapper.eq(Objects.nonNull(request.getId()), StructureEntity::getId, request.getId());
        wrapper.eq(Objects.nonNull(request.getName()), StructureEntity::getName, request.getName());
        wrapper.eq(Objects.nonNull(request.getCode()), StructureEntity::getCode, request.getCode());
        return baseMapper.selectPage(page, wrapper);
    }

    @Override
    public StructureResponse convert(StructureEntity entity) {
        return structureConvertor.entityToResponse(entity);
    }

}
