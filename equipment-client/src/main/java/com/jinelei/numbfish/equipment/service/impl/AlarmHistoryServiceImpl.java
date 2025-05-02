package com.jinelei.numbfish.equipment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jinelei.numbfish.common.helper.Snowflake;
import com.jinelei.numbfish.equipment.convertor.AlarmHistoryConvertor;
import com.jinelei.numbfish.equipment.dto.*;
import com.jinelei.numbfish.equipment.entity.AlarmHistoryEntity;
import com.jinelei.numbfish.equipment.mapper.AlarmHistoryMapper;
import com.jinelei.numbfish.equipment.service.AlarmHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
@Service
public class AlarmHistoryServiceImpl extends ServiceImpl<AlarmHistoryMapper, AlarmHistoryEntity>
        implements AlarmHistoryService {
    private static final Logger log = LoggerFactory.getLogger(AlarmHistoryServiceImpl.class);
    protected Snowflake snowflake = Snowflake.DEFAULT;

    @Autowired
    protected AlarmHistoryConvertor alarmHistoryConvertor;

//    @Override
//    public void create(AlarmHistoryCreateRequest request) {
//        final AlarmHistoryEntity entity = alarmHistoryConvertor.entityFromCreateRequest(request);
//        Optional.ofNullable(entity).orElseThrow(() -> new InvalidArgsException("报警历史信息不合法"));
//        int inserted = baseMapper.insert(entity);
//        Assert.state(inserted == 1, "报警历史创建失败");
//    }

    @Override
    public void delete(AlarmHistoryDeleteRequest request) {
        if (Objects.nonNull(request.getId())) {
            int deleted = baseMapper.deleteById(request.getId());
            Assert.state(deleted == 1, "报警历史删除失败");
        } else if (!CollectionUtils.isEmpty(request.getIds())) {
            int deleted = baseMapper.deleteByIds(request.getIds());
            Assert.state(deleted == request.getIds().size(), "报警历史删除失败");
        }
    }

//    @Override
//    public void update(@Validated AlarmHistoryUpdateRequest request) {
//        LambdaUpdateWrapper<AlarmHistoryEntity> wrapper = Wrappers.lambdaUpdate(AlarmHistoryEntity.class);
//        wrapper.eq(AlarmHistoryEntity::getId, request.getId());
//        wrapper.set(AlarmHistoryEntity::getName, request.getName());
//        wrapper.set(AlarmHistoryEntity::getCode, request.getCode());
//        wrapper.set(AlarmHistoryEntity::getRemark, request.getRemark());
//        int updated = baseMapper.update(wrapper);
//        Assert.state(updated == 1, "报警历史更新失败");
//    }

    @Override
    public AlarmHistoryEntity get(AlarmHistoryQueryRequest request) {
        LambdaQueryWrapper<AlarmHistoryEntity> wrapper = Wrappers.lambdaQuery(AlarmHistoryEntity.class);
        wrapper.eq(Objects.nonNull(request.getId()), AlarmHistoryEntity::getId, request.getId());
        wrapper.in(CollectionUtils.isNotEmpty(request.getIds()), AlarmHistoryEntity::getId, request.getIds());
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public List<AlarmHistoryEntity> list(AlarmHistoryQueryRequest request) {
        LambdaQueryWrapper<AlarmHistoryEntity> wrapper = Wrappers.lambdaQuery(AlarmHistoryEntity.class);
        wrapper.eq(Objects.nonNull(request.getId()), AlarmHistoryEntity::getId, request.getId());
        wrapper.in(CollectionUtils.isNotEmpty(request.getIds()), AlarmHistoryEntity::getId, request.getIds());
        return baseMapper.selectList(wrapper);
    }

    @Override
    public IPage<AlarmHistoryEntity> page(IPage<AlarmHistoryEntity> page, AlarmHistoryQueryRequest request) {
        LambdaQueryWrapper<AlarmHistoryEntity> wrapper = Wrappers.lambdaQuery(AlarmHistoryEntity.class);
        wrapper.eq(Objects.nonNull(request.getId()), AlarmHistoryEntity::getId, request.getId());
        wrapper.in(CollectionUtils.isNotEmpty(request.getIds()), AlarmHistoryEntity::getId, request.getIds());
        return baseMapper.selectPage(page, wrapper);
    }

    @Override
    public AlarmHistoryResponse convert(AlarmHistoryEntity entity) {
        return alarmHistoryConvertor.entityToResponse(entity);
    }

}
