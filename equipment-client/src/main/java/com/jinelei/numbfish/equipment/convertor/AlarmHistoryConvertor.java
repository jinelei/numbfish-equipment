package com.jinelei.numbfish.equipment.convertor;

import com.jinelei.numbfish.equipment.dto.AlarmHistoryResponse;
import com.jinelei.numbfish.equipment.entity.AlarmHistoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@SuppressWarnings("unused")
@Mapper(componentModel = "spring")
public interface AlarmHistoryConvertor {
    @Mappings({
    })
    AlarmHistoryResponse entityToResponse(AlarmHistoryEntity source);
}