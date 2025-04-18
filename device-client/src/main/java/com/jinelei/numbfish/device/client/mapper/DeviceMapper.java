package com.jinelei.numbfish.device.client.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jinelei.numbfish.device.client.domain.DeviceEntity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@SuppressWarnings("unused")
@Mapper
public interface DeviceMapper extends BaseMapper<DeviceEntity> {

}
