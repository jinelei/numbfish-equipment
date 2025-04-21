package com.jinelei.numbfish.device.convertor;

import com.jinelei.numbfish.device.dto.AlarmRuleCreateRequest;
import com.jinelei.numbfish.device.dto.AlarmRuleResponse;
import com.jinelei.numbfish.device.dto.AlarmRuleUpdateRequest;
import com.jinelei.numbfish.device.entity.AlarmRuleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@SuppressWarnings("unused")
@Mapper(componentModel = "spring")
public interface AlarmRuleConvertor {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdTime", ignore = true),
            @Mapping(target = "createdUserId", ignore = true),
            @Mapping(target = "updatedTime", ignore = true),
            @Mapping(target = "updatedUserId", ignore = true),
    })
    AlarmRuleEntity entityFromCreateRequest(AlarmRuleCreateRequest source);

    @Mappings({
            @Mapping(target = "createdTime", ignore = true),
            @Mapping(target = "createdUserId", ignore = true),
            @Mapping(target = "updatedTime", ignore = true),
            @Mapping(target = "updatedUserId", ignore = true),
    })
    AlarmRuleEntity entityFromUpdateRequest(AlarmRuleUpdateRequest source);

    @Mappings({
    })
    AlarmRuleResponse entityToResponse(AlarmRuleEntity source);
}