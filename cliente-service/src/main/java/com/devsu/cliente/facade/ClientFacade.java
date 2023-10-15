package com.devsu.cliente.facade;

import com.devsu.cliente.dto.AccountRequestDto;
import com.devsu.cliente.dto.ClientDto;
import com.devsu.cliente.dto.ClientWebResponseDto;
import com.devsu.cliente.mapper.ClientMapper;
import com.devsu.cliente.service.ClientService;
import org.springframework.stereotype.Component;

@Component
public class ClientFacade {
    private final ClientService clientService;

    public ClientFacade(ClientService clientService){
        this.clientService = clientService;
    }

    public ClientDto createClient(ClientDto clientDto){
        return clientService.createClient(clientDto);
    }

    public ClientDto updateClient(ClientDto clientDto){
        return clientService.updateClient(clientDto);
    }

    public void deleteClient(ClientDto clientDto){
        clientService.deleteClient(clientDto);
    }

    public ClientWebResponseDto getClient(String documentNumber){
        return ClientMapper.MAPPER.toClientWebResponseDto(clientService.getClient(documentNumber));
    }
}
