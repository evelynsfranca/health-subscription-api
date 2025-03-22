package com.healthsubscriptionapi.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthsubscriptionapi.facade.PartnerFacade;
import com.healthsubscriptionapi.facade.dto.partner.PartnerToCreateDTO;
import com.healthsubscriptionapi.facade.dto.partner.PartnerToGetAllDTO;
import com.healthsubscriptionapi.facade.dto.partner.PartnerToGetDTO;
import com.healthsubscriptionapi.facade.dto.partner.PartnerToSimpleDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/partners")
@RequiredArgsConstructor
public class PartnerController {

    @Autowired
    private final PartnerFacade partnerFacade;

    @PostMapping
    private ResponseEntity<PartnerToSimpleDTO> create(@Valid @RequestBody PartnerToCreateDTO dto) {
        PartnerToSimpleDTO result = partnerFacade.save(dto);
        return new ResponseEntity<PartnerToSimpleDTO>(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<PartnerToGetDTO> get(@PathVariable String id) {
        PartnerToGetDTO result = partnerFacade.get(id);
        return new ResponseEntity<PartnerToGetDTO>(result, HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<PartnerToGetAllDTO>> getAll() {
        List<PartnerToGetAllDTO> result = partnerFacade.getAll();
        return new ResponseEntity<List<PartnerToGetAllDTO>>(result, HttpStatus.OK);
    }
}
