package com.jinelei.numbfish.device.convertor;

import com.jinelei.numbfish.device.dto.OeeHistoryResponse;
import com.jinelei.numbfish.device.entity.OeeHistoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@SuppressWarnings("unused")
@Mapper(componentModel = "spring")
public interface OeeHistoryConvertor {

    @Mappings({
    })
    OeeHistoryResponse entityToResponse(OeeHistoryEntity source);
}