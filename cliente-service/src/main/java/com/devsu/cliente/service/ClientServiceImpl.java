package com.devsu.cliente.service;

import com.devsu.cliente.dto.AccountRequestDto;
import com.devsu.cliente.dto.ClientDto;
import com.devsu.cliente.entity.ClientEntity;
import com.devsu.cliente.exception.ClientAlreadyExistsException;
import com.devsu.cliente.exception.ClientByDocumentNotFound;
import com.devsu.cliente.exception.ClientNotFoundException;
import com.devsu.cliente.mapper.ClientMapper;
import com.devsu.cliente.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        var clientExist = clientRepository.findByPersonEntityDocumentNumber(clientDto.getDocumentNumber());
        if (clientExist.isPresent()) throw new ClientAlreadyExistsException(clientDto.getDocumentNumber());
        var client = clientRepository.save(ClientMapper.MAPPER.toClientEntity(clientDto));
        return ClientMapper.MAPPER.toClientDto(client);
    }

    @Override
    public ClientDto updateClient(ClientDto clientDto) {
        var client = clientRepository.findById(clientDto.getId());
        if (client.isEmpty()) throw new ClientNotFoundException(clientDto.getId());
        var clientUpdated = clientRepository.save(updateClientDto(client.get(), clientDto));
        return ClientMapper.MAPPER.toClientDto(clientUpdated);
    }

    @Override
    @Transactional
    public void deleteClient(ClientDto clientDto) {
        var client = clientRepository.findById(clientDto.getId());
        if (client.isEmpty()) throw new ClientNotFoundException(clientDto.getId());
        clientRepository.delete(client.get());
    }

    @Override
    public ClientDto getClient(String documentNumber) {
        var client = clientRepository.findByPersonEntityDocumentNumber(documentNumber);
        if (client.isEmpty()) throw new ClientByDocumentNotFound(documentNumber);
        return ClientMapper.MAPPER.toClientDto(client.get());
    }

    private ClientEntity updateClientDto(ClientEntity clientEntity, ClientDto client){
        clientEntity.getPersonEntity().setName(client.getName());
        clientEntity.getPersonEntity().setAddress(client.getAddress());
        clientEntity.getPersonEntity().setAge(client.getAge());
        clientEntity.getPersonEntity().setGender(client.getGender());
        clientEntity.getPersonEntity().setPhone(client.getPhone());
        clientEntity.setPassword(client.getPassword());
        clientEntity.setStatus(client.getStatus());
        return clientEntity;
    }
}
