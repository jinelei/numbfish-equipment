package com.jinelei.numbfish.equipment.convertor;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.jinelei.numbfish.equipment.entity.DeviceEntity;
import com.jinelei.numbfish.equipment.dto.DeviceCreateRequest;
import com.jinelei.numbfish.equipment.dto.DeviceResponse;
import com.jinelei.numbfish.equipment.dto.DeviceUpdateRequest;

@SuppressWarnings("unused")
@Mapper(componentModel = "spring")
public interface DeviceConvertor {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "lastUpdateRunningStateTime", ignore = true),
            @Mapping(target = "createdTime", ignore = true),
            @Mapping(target = "createdUserId", ignore = true),
            @Mapping(target = "updatedTime", ignore = true),
            @Mapping(target = "updatedUserId", ignore = true),
    })
    DeviceEntity entityFromCreateRequest(DeviceCreateRequest source);

    @Mappings({
            @Mapping(target = "lastUpdateRunningStateTime", ignore = true),
            @Mapping(target = "runningState", ignore = true),
            @Mapping(target = "createdTime", ignore = true),
            @Mapping(target = "createdUserId", ignore = true),
            @Mapping(target = "updatedTime", ignore = true),
            @Mapping(target = "updatedUserId", ignore = true),
    })
    DeviceEntity entityFromUpdateRequest(DeviceUpdateRequest source);

    @Mappings({
            @Mapping(target = "runningState", ignore = true),
    })
    DeviceResponse entityToResponse(DeviceEntity source);
}