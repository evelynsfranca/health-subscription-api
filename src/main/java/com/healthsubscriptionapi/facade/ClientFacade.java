package com.healthsubscriptionapi.facade;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthsubscriptionapi.facade.dto.client.ClientToCreateDTO;
import com.healthsubscriptionapi.facade.dto.client.ClientToGetAllDTO;
import com.healthsubscriptionapi.facade.dto.client.ClientToGetDTO;
import com.healthsubscriptionapi.facade.dto.client.ClientToSimpleDTO;
import com.healthsubscriptionapi.facade.mapper.ClientMapper;
import com.healthsubscriptionapi.model.Client;
import com.healthsubscriptionapi.service.ClientService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientFacade {

    @Autowired
    private final ClientMapper clientMapper;
    @Autowired
    private final ClientService clientService;

    @Transactional
    public ClientToSimpleDTO save(ClientToCreateDTO dto) {
        Client entity = clientMapper.toCreateEntity(dto);
        Client saved = clientService.save(entity);
        return clientMapper.toSimṕleDto(saved);
    }

    @Transactional(readOnly = true)
    public ClientToGetDTO get(String id) {
        Client entity = clientService.get(id);
        return clientMapper.toGetDto(entity);
    }

    @Transactional(readOnly = true)
    public List<ClientToGetAllDTO> getAll() {
        return clientService.getAll().stream()
                .map(clientMapper::toGetAllDto)
                .collect(Collectors.toList());
    }
}
