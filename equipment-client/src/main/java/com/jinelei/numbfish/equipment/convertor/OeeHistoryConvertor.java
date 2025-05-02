package com.jinelei.numbfish.equipment.convertor;

import com.jinelei.numbfish.equipment.dto.OeeHistoryResponse;
import com.jinelei.numbfish.equipment.entity.OeeHistoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@SuppressWarnings("unused")
@Mapper(componentModel = "spring")
public interface OeeHistoryConvertor {

    @Mappings({
    })
    OeeHistoryResponse entityToResponse(OeeHistoryEntity source);
}