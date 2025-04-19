package com.jinelei.numbfish.device.client.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.jinelei.numbfish.device.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jinelei.numbfish.common.exception.InvalidArgsException;
import com.jinelei.numbfish.common.helper.Snowflake;
import com.jinelei.numbfish.device.client.convertor.DeviceConvertor;
import com.jinelei.numbfish.device.client.domain.DeviceEntity;
import com.jinelei.numbfish.device.client.mapper.DeviceMapper;
import com.jinelei.numbfish.device.client.service.DeviceService;

@SuppressWarnings("unused")
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, DeviceEntity>
        implements DeviceService {
    private static final Logger log = LoggerFactory.getLogger(DeviceServiceImpl.class);
    protected Snowflake snowflake = Snowflake.DEFAULT;

    @Autowired
    protected DeviceConvertor deviceConvertor;

    @Override
    public void create(DeviceCreateRequest request) {
        final DeviceEntity entity = deviceConvertor.entityFromCreateRequest(request);
        Optional.ofNullable(entity).orElseThrow(() -> new InvalidArgsException("设备信息不合法"));
        int inserted = baseMapper.insert(entity);
        Assert.state(inserted == 1, "设备创建失败");
    }

    @Override
    public void delete(DeviceDeleteRequest request) {
        if (Objects.nonNull(request.getId())) {
            int deleted = baseMapper.deleteById(request.getId());
            Assert.state(deleted == 1, "设备删除失败");
        } else if (!CollectionUtils.isEmpty(request.getIds())) {
            int deleted = baseMapper.deleteByIds(request.getIds());
            Assert.state(deleted == request.getIds().size(), "设备删除失败");
        }
    }

    @Override
    public void update(@Validated DeviceUpdateRequest request) {
        LambdaUpdateWrapper<DeviceEntity> wrapper = Wrappers.lambdaUpdate(DeviceEntity.class);
        wrapper.eq(DeviceEntity::getId, request.getId());
        wrapper.set(DeviceEntity::getName, request.getName());
        wrapper.set(DeviceEntity::getCode, request.getCode());
        wrapper.set(DeviceEntity::getRemark, request.getRemark());
        int updated = baseMapper.update(wrapper);
        Assert.state(updated == 1, "设备更新失败");
    }

    @Override
    public void updateRunningState(@Validated DeviceRunningStateUpdateRequest request) {
        LambdaUpdateWrapper<DeviceEntity> wrapper = Wrappers.lambdaUpdate(DeviceEntity.class);
        wrapper.eq(DeviceEntity::getCode, request.getDeviceCode());
        wrapper.set(DeviceEntity::getRunningState, request.getRunningState());
        wrapper.set(DeviceEntity::getLastUpdateRunningStateTime, request.getTimestamp());
        int updated = baseMapper.update(wrapper);
        Assert.state(updated == 1, "设备更新运行状态失败");
    }

    @Override
    public void updateActivateState(@Validated DeviceActivateStateUpdateRequest request) {
        LambdaUpdateWrapper<DeviceEntity> wrapper = Wrappers.lambdaUpdate(DeviceEntity.class);
        wrapper.eq(DeviceEntity::getCode, request.getDeviceCode());
        wrapper.isNull(DeviceEntity::getActivateTime);
        wrapper.set(DeviceEntity::getActivateTime, request.getTimestamp());
        int updated = baseMapper.update(wrapper);
        if (updated != 1) {
            log.warn("设备激活状态更新失败，设备已激活");
        }
    }

    @Override
    public DeviceEntity get(DeviceQueryRequest request) {
        LambdaQueryWrapper<DeviceEntity> wrapper = Wrappers.lambdaQuery(DeviceEntity.class);
        wrapper.eq(Objects.nonNull(request.getId()), DeviceEntity::getId, request.getId());
        wrapper.eq(Objects.nonNull(request.getName()), DeviceEntity::getName, request.getName());
        wrapper.eq(Objects.nonNull(request.getCode()), DeviceEntity::getCode, request.getCode());
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public List<DeviceEntity> list(DeviceQueryRequest request) {
        LambdaQueryWrapper<DeviceEntity> wrapper = Wrappers.lambdaQuery(DeviceEntity.class);
        wrapper.eq(Objects.nonNull(request.getId()), DeviceEntity::getId, request.getId());
        wrapper.eq(Objects.nonNull(request.getName()), DeviceEntity::getName, request.getName());
        wrapper.eq(Objects.nonNull(request.getCode()), DeviceEntity::getCode, request.getCode());
        return baseMapper.selectList(wrapper);
    }

    @Override
    public IPage<DeviceEntity> page(IPage<DeviceEntity> page, DeviceQueryRequest request) {
        LambdaQueryWrapper<DeviceEntity> wrapper = Wrappers.lambdaQuery(DeviceEntity.class);
        wrapper.eq(Objects.nonNull(request.getId()), DeviceEntity::getId, request.getId());
        wrapper.eq(Objects.nonNull(request.getName()), DeviceEntity::getName, request.getName());
        wrapper.eq(Objects.nonNull(request.getCode()), DeviceEntity::getCode, request.getCode());
        return baseMapper.selectPage(page, wrapper);
    }

    @Override
    public DeviceResponse convert(DeviceEntity entity) {
        return deviceConvertor.entityToResponse(entity);
    }

}
