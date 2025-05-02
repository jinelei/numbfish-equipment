package com.jinelei.numbfish.device.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jinelei.numbfish.common.exception.InvalidArgsException;
import com.jinelei.numbfish.common.helper.Snowflake;
import com.jinelei.numbfish.device.convertor.DictConvertor;
import com.jinelei.numbfish.device.dto.*;
import com.jinelei.numbfish.device.entity.DictEntity;
import com.jinelei.numbfish.device.mapper.DictMapper;
import com.jinelei.numbfish.device.service.DictService;
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
public class DictServiceImpl extends ServiceImpl<DictMapper, DictEntity>
        implements DictService {
    private static final Logger log = LoggerFactory.getLogger(DictServiceImpl.class);
    protected Snowflake snowflake = Snowflake.DEFAULT;

    @Autowired
    protected DictConvertor structureConvertor;

    @Override
    public void create(DictCreateRequest request) {
        final DictEntity entity = structureConvertor.entityFromCreateRequest(request);
        Optional.ofNullable(entity).orElseThrow(() -> new InvalidArgsException("字典信息不合法"));
        int inserted = baseMapper.insert(entity);
        Assert.state(inserted == 1, "字典创建失败");
    }

    @Override
    public void delete(DictDeleteRequest request) {
        if (Objects.nonNull(request.getId())) {
            int deleted = baseMapper.deleteById(request.getId());
            Assert.state(deleted == 1, "字典删除失败");
        } else if (!CollectionUtils.isEmpty(request.getIds())) {
            int deleted = baseMapper.deleteByIds(request.getIds());
            Assert.state(deleted == request.getIds().size(), "字典删除失败");
        }
    }

    @Override
    public void update(@Validated DictUpdateRequest request) {
        LambdaUpdateWrapper<DictEntity> wrapper = Wrappers.lambdaUpdate(DictEntity.class);
        wrapper.eq(DictEntity::getId, request.getId());
        wrapper.set(DictEntity::getName, request.getName());
        wrapper.set(DictEntity::getCode, request.getCode());
        wrapper.set(DictEntity::getRemark, request.getRemark());
        int updated = baseMapper.update(wrapper);
        Assert.state(updated == 1, "字典更新失败");
    }

    @Override
    public DictEntity get(DictQueryRequest request) {
        LambdaQueryWrapper<DictEntity> wrapper = Wrappers.lambdaQuery(DictEntity.class);
        wrapper.eq(Objects.nonNull(request.getId()), DictEntity::getId, request.getId());
        wrapper.eq(Objects.nonNull(request.getName()), DictEntity::getName, request.getName());
        wrapper.eq(Objects.nonNull(request.getCode()), DictEntity::getCode, request.getCode());
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public List<DictEntity> list(DictQueryRequest request) {
        LambdaQueryWrapper<DictEntity> wrapper = Wrappers.lambdaQuery(DictEntity.class);
        wrapper.eq(Objects.nonNull(request.getId()), DictEntity::getId, request.getId());
        wrapper.eq(Objects.nonNull(request.getName()), DictEntity::getName, request.getName());
        wrapper.eq(Objects.nonNull(request.getCode()), DictEntity::getCode, request.getCode());
        return baseMapper.selectList(wrapper);
    }

    @Override
    public IPage<DictEntity> page(IPage<DictEntity> page, DictQueryRequest request) {
        LambdaQueryWrapper<DictEntity> wrapper = Wrappers.lambdaQuery(DictEntity.class);
        wrapper.eq(Objects.nonNull(request.getId()), DictEntity::getId, request.getId());
        wrapper.eq(Objects.nonNull(request.getName()), DictEntity::getName, request.getName());
        wrapper.eq(Objects.nonNull(request.getCode()), DictEntity::getCode, request.getCode());
        return baseMapper.selectPage(page, wrapper);
    }

    @Override
    public DictResponse convert(DictEntity entity) {
        return structureConvertor.entityToResponse(entity);
    }

}
