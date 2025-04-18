package com.jinelei.numbfish.device.client.convertor;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.jinelei.numbfish.device.client.domain.DeviceEntity;
import com.jinelei.numbfish.device.dto.DeviceCreateRequest;
import com.jinelei.numbfish.device.dto.DeviceResponse;
import com.jinelei.numbfish.device.dto.DeviceUpdateRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
@Mapper(componentModel = "spring")
public interface DeviceConvertor {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdTime", ignore = true),
            @Mapping(target = "createdUserId", ignore = true),
            @Mapping(target = "updatedTime", ignore = true),
            @Mapping(target = "updatedUserId", ignore = true),
    })
    DeviceEntity entityFromCreateRequest(DeviceCreateRequest source);

    @Mappings({
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