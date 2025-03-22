package com.healthsubscriptionapi.facade.mapper;

import org.mapstruct.Mapper;

import com.healthsubscriptionapi.facade.dto.partner.PartnerToCreateDTO;
import com.healthsubscriptionapi.facade.dto.partner.PartnerToGetAllDTO;
import com.healthsubscriptionapi.facade.dto.partner.PartnerToGetDTO;
import com.healthsubscriptionapi.facade.dto.partner.PartnerToSimpleDTO;
import com.healthsubscriptionapi.model.Partner;

@Mapper(componentModel = "spring", uses = { ProductMapper.class })
public interface PartnerMapper {

    Partner toCreateEntity(PartnerToCreateDTO dto);

    PartnerToSimpleDTO toSimṕleDto(Partner entity);

    PartnerToGetDTO toGetDto(Partner entity);

    PartnerToGetAllDTO toGetAllDto(Partner entity);
}
