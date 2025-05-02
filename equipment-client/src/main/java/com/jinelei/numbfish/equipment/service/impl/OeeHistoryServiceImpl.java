package com.jinelei.numbfish.equipment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jinelei.numbfish.common.helper.Snowflake;
import com.jinelei.numbfish.equipment.convertor.OeeHistoryConvertor;
import com.jinelei.numbfish.equipment.dto.*;
import com.jinelei.numbfish.equipment.entity.OeeHistoryEntity;
import com.jinelei.numbfish.equipment.mapper.OeeHistoryMapper;
import com.jinelei.numbfish.equipment.service.OeeHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
@Service
public class OeeHistoryServiceImpl extends ServiceImpl<OeeHistoryMapper, OeeHistoryEntity>
        implements OeeHistoryService {
    private static final Logger log = LoggerFactory.getLogger(OeeHistoryServiceImpl.class);
    protected Snowflake snowflake = Snowflake.DEFAULT;

    @Autowired
    protected OeeHistoryConvertor structureConvertor;

//    @Override
//    public void create(OeeHistoryCreateRequest request) {
//        final OeeHistoryEntity entity = structureConvertor.entityFromCreateRequest(request);
//        Optional.ofNullable(entity).orElseThrow(() -> new InvalidArgsException("Oee历史信息不合法"));
//        int inserted = baseMapper.insert(entity);
//        Assert.state(inserted == 1, "Oee历史创建失败");
//    }

    @Override
    public void delete(OeeHistoryDeleteRequest request) {
        if (Objects.nonNull(request.getId())) {
            int deleted = baseMapper.deleteById(request.getId());
            Assert.state(deleted == 1, "Oee历史删除失败");
        } else if (!CollectionUtils.isEmpty(request.getIds())) {
            int deleted = baseMapper.deleteByIds(request.getIds());
            Assert.state(deleted == request.getIds().size(), "Oee历史删除失败");
        }
    }

//    @Override
//    public void update(@Validated OeeHistoryUpdateRequest request) {
//        LambdaUpdateWrapper<OeeHistoryEntity> wrapper = Wrappers.lambdaUpdate(OeeHistoryEntity.class);
//        wrapper.eq(OeeHistoryEntity::getId, request.getId());
//        int updated = baseMapper.update(wrapper);
//        Assert.state(updated == 1, "Oee历史更新失败");
//    }

    @Override
    public OeeHistoryEntity get(OeeHistoryQueryRequest request) {
        LambdaQueryWrapper<OeeHistoryEntity> wrapper = Wrappers.lambdaQuery(OeeHistoryEntity.class);
        wrapper.eq(Objects.nonNull(request.getId()), OeeHistoryEntity::getId, request.getId());
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public List<OeeHistoryEntity> list(OeeHistoryQueryRequest request) {
        LambdaQueryWrapper<OeeHistoryEntity> wrapper = Wrappers.lambdaQuery(OeeHistoryEntity.class);
        wrapper.eq(Objects.nonNull(request.getId()), OeeHistoryEntity::getId, request.getId());
        return baseMapper.selectList(wrapper);
    }

    @Override
    public IPage<OeeHistoryEntity> page(IPage<OeeHistoryEntity> page, OeeHistoryQueryRequest request) {
        LambdaQueryWrapper<OeeHistoryEntity> wrapper = Wrappers.lambdaQuery(OeeHistoryEntity.class);
        wrapper.eq(Objects.nonNull(request.getId()), OeeHistoryEntity::getId, request.getId());
        return baseMapper.selectPage(page, wrapper);
    }

    @Override
    public OeeHistoryResponse convert(OeeHistoryEntity entity) {
        return structureConvertor.entityToResponse(entity);
    }

}
