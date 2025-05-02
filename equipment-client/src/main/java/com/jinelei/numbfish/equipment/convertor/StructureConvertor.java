package com.jinelei.numbfish.equipment.convertor;

import com.jinelei.numbfish.equipment.dto.StructureCreateRequest;
import com.jinelei.numbfish.equipment.dto.StructureResponse;
import com.jinelei.numbfish.equipment.dto.StructureUpdateRequest;
import com.jinelei.numbfish.equipment.entity.StructureEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@SuppressWarnings("unused")
@Mapper(componentModel = "spring")
public interface StructureConvertor {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdTime", ignore = true),
            @Mapping(target = "createdUserId", ignore = true),
            @Mapping(target = "updatedTime", ignore = true),
            @Mapping(target = "updatedUserId", ignore = true),
    })
    StructureEntity entityFromCreateRequest(StructureCreateRequest source);

    @Mappings({
            @Mapping(target = "createdTime", ignore = true),
            @Mapping(target = "createdUserId", ignore = true),
            @Mapping(target = "updatedTime", ignore = true),
            @Mapping(target = "updatedUserId", ignore = true),
    })
    StructureEntity entityFromUpdateRequest(StructureUpdateRequest source);

    @Mappings({
    })
    StructureResponse entityToResponse(StructureEntity source);
}