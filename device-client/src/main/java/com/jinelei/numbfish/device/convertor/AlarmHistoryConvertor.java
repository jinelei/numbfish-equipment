package com.jinelei.numbfish.device.convertor;

import com.jinelei.numbfish.device.dto.AlarmHistoryCreateRequest;
import com.jinelei.numbfish.device.dto.AlarmHistoryResponse;
import com.jinelei.numbfish.device.dto.AlarmHistoryUpdateRequest;
import com.jinelei.numbfish.device.entity.AlarmHistoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@SuppressWarnings("unused")
@Mapper(componentModel = "spring")
public interface AlarmHistoryConvertor {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdTime", ignore = true),
            @Mapping(target = "createdUserId", ignore = true),
            @Mapping(target = "updatedTime", ignore = true),
            @Mapping(target = "updatedUserId", ignore = true),
    })
    AlarmHistoryEntity entityFromCreateRequest(AlarmHistoryCreateRequest source);

    @Mappings({
            @Mapping(target = "createdTime", ignore = true),
            @Mapping(target = "createdUserId", ignore = true),
            @Mapping(target = "updatedTime", ignore = true),
            @Mapping(target = "updatedUserId", ignore = true),
    })
    AlarmHistoryEntity entityFromUpdateRequest(AlarmHistoryUpdateRequest source);

    @Mappings({
    })
    AlarmHistoryResponse entityToResponse(AlarmHistoryEntity source);
}