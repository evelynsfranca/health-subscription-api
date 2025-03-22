package com.healthsubscriptionapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthsubscriptionapi.facade.ClientFacade;
import com.healthsubscriptionapi.facade.dto.client.ClientToCreateDTO;
import com.healthsubscriptionapi.facade.dto.client.ClientToGetAllDTO;
import com.healthsubscriptionapi.facade.dto.client.ClientToGetDTO;
import com.healthsubscriptionapi.facade.dto.client.ClientToSimpleDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    @Autowired
    private final ClientFacade clientFacade;

    @PostMapping
    private ResponseEntity<ClientToSimpleDTO> create(@Valid @RequestBody ClientToCreateDTO dto) {
        ClientToSimpleDTO result = clientFacade.save(dto);
        return new ResponseEntity<ClientToSimpleDTO>(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<ClientToGetDTO> get(@PathVariable String id) {
        ClientToGetDTO result = clientFacade.get(id);
        return new ResponseEntity<ClientToGetDTO>(result, HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<ClientToGetAllDTO>> getAll() {
        List<ClientToGetAllDTO> result = clientFacade.getAll();
        return new ResponseEntity<List<ClientToGetAllDTO>>(result, HttpStatus.OK);
    }
}
