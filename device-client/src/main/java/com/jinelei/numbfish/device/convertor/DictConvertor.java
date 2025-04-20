package com.jinelei.numbfish.device.convertor;

import com.jinelei.numbfish.device.dto.DictCreateRequest;
import com.jinelei.numbfish.device.dto.DictResponse;
import com.jinelei.numbfish.device.dto.DictUpdateRequest;
import com.jinelei.numbfish.device.entity.DictEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@SuppressWarnings("unused")
@Mapper(componentModel = "spring")
public interface DictConvertor {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdTime", ignore = true),
            @Mapping(target = "createdUserId", ignore = true),
            @Mapping(target = "updatedTime", ignore = true),
            @Mapping(target = "updatedUserId", ignore = true),
    })
    DictEntity entityFromCreateRequest(DictCreateRequest source);

    @Mappings({
            @Mapping(target = "createdTime", ignore = true),
            @Mapping(target = "createdUserId", ignore = true),
            @Mapping(target = "updatedTime", ignore = true),
            @Mapping(target = "updatedUserId", ignore = true),
    })
    DictEntity entityFromUpdateRequest(DictUpdateRequest source);

    @Mappings({
    })
    DictResponse entityToResponse(DictEntity source);
}