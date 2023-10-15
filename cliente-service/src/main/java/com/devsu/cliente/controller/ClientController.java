package com.devsu.cliente.controller;

import com.devsu.cliente.dto.AccountRequestDto;
import com.devsu.cliente.dto.ClientDto;
import com.devsu.cliente.dto.ClientWebResponseDto;
import com.devsu.cliente.facade.ClientFacade;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clientes")
public class ClientController {

    private final ClientFacade clientFacade;

    public ClientController(ClientFacade clientFacade){
        this.clientFacade = clientFacade;
    }

    @PostMapping("")
    private ClientDto createClient(@RequestBody ClientDto clientDto){
        return clientFacade.createClient(clientDto);
    }

    @PutMapping("")
    private ClientDto updateClient(@RequestBody ClientDto clientDto){
        return clientFacade.updateClient(clientDto);
    }

    @DeleteMapping("")
    private void deleteClient(@RequestBody ClientDto clientDto){
        clientFacade.deleteClient(clientDto);
    }

    @GetMapping
    private ClientWebResponseDto getClient(@RequestParam(value = "documentNumber") String documentNumber){
        return clientFacade.getClient(documentNumber);
    }
}
