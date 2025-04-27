package com.jinelei.numbfish.device.convertor;

import com.jinelei.numbfish.device.dto.AlarmHistoryResponse;
import com.jinelei.numbfish.device.entity.AlarmHistoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@SuppressWarnings("unused")
@Mapper(componentModel = "spring")
public interface AlarmHistoryConvertor {
    @Mappings({
    })
    AlarmHistoryResponse entityToResponse(AlarmHistoryEntity source);
}