package com.jinelei.numbfish.equipment.convertor;

import com.jinelei.numbfish.equipment.dto.OeeRuleCreateRequest;
import com.jinelei.numbfish.equipment.dto.OeeRuleResponse;
import com.jinelei.numbfish.equipment.dto.OeeRuleUpdateRequest;
import com.jinelei.numbfish.equipment.entity.OeeRuleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@SuppressWarnings("unused")
@Mapper(componentModel = "spring")
public interface OeeRuleConvertor {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdTime", ignore = true),
            @Mapping(target = "createdUserId", ignore = true),
            @Mapping(target = "updatedTime", ignore = true),
            @Mapping(target = "updatedUserId", ignore = true),
    })
    OeeRuleEntity entityFromCreateRequest(OeeRuleCreateRequest source);

    @Mappings({
            @Mapping(target = "createdTime", ignore = true),
            @Mapping(target = "createdUserId", ignore = true),
            @Mapping(target = "updatedTime", ignore = true),
            @Mapping(target = "updatedUserId", ignore = true),
    })
    OeeRuleEntity entityFromUpdateRequest(OeeRuleUpdateRequest source);

    @Mappings({
    })
    OeeRuleResponse entityToResponse(OeeRuleEntity source);
}