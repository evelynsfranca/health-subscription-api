package com.healthsubscriptionapi.facade;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthsubscriptionapi.facade.dto.partner.PartnerToCreateDTO;
import com.healthsubscriptionapi.facade.dto.partner.PartnerToGetAllDTO;
import com.healthsubscriptionapi.facade.dto.partner.PartnerToGetDTO;
import com.healthsubscriptionapi.facade.dto.partner.PartnerToSimpleDTO;
import com.healthsubscriptionapi.facade.mapper.PartnerMapper;
import com.healthsubscriptionapi.model.Partner;
import com.healthsubscriptionapi.service.PartnerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PartnerFacade {

    @Autowired
    private final PartnerMapper partnerMapper;
    @Autowired
    private final PartnerService partnerService;

    @Transactional
    public PartnerToSimpleDTO save(PartnerToCreateDTO dto) {
        Partner entity = partnerMapper.toCreateEntity(dto);
        Partner saved = partnerService.save(entity);
        return partnerMapper.toSimṕleDto(saved);
    }

    @Transactional(readOnly = true)
    public PartnerToGetDTO get(String id) {
        Partner entity = partnerService.get(id);
        return partnerMapper.toGetDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PartnerToGetAllDTO> getAll() {
        return partnerService.getAll().stream()
                .map(partnerMapper::toGetAllDto)
                .collect(Collectors.toList());
    }

}
