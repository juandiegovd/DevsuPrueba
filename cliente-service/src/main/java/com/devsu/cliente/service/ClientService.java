package com.devsu.cliente.service;

import com.devsu.cliente.dto.ClientDto;

public interface ClientService {
    ClientDto createClient(ClientDto clientDto);
    ClientDto updateClient(ClientDto clientDto);
    void deleteClient(ClientDto clientDto);
    ClientDto getClient(String documentNumber);
}
