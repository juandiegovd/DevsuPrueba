package com.devsu.cliente.service;

import com.devsu.cliente.AbstractBaseJUnit5Test;
import com.devsu.cliente.dto.ClientDto;
import com.devsu.cliente.entity.ClientEntity;
import com.devsu.cliente.exception.ClientAlreadyExistsException;
import com.devsu.cliente.repository.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ClientServiceImplTest extends AbstractBaseJUnit5Test {
    private final ClientRepository clientRepository = Mockito.mock(ClientRepository.class);
    private final ClientServiceImpl clientService = new ClientServiceImpl(clientRepository);

    @Test
    void createClient() throws Exception {
        var clientDto = convertTo("/ClientRequest.json", ClientDto.class);
        when(clientRepository.findByPersonEntityDocumentNumber(clientDto.getDocumentNumber())).thenReturn(Optional.empty());
        when(clientRepository.save(any(ClientEntity.class))).thenReturn(convertTo("/ClientEntity.json", ClientEntity.class));
        var clientResp = clientService.createClient(clientDto);
        Assertions.assertEquals(1, clientResp.getId());
    }

    @Test
    void createClientExisted() throws Exception {
        var clientDto = convertTo("/ClientRequest.json", ClientDto.class);
        when(clientRepository.findByPersonEntityDocumentNumber(clientDto.getDocumentNumber())).thenReturn(Optional.of(convertTo("/ClientEntity.json", ClientEntity.class)));
        var exception = Assertions.assertThrows(ClientAlreadyExistsException.class, () -> clientService.createClient(clientDto));
        Assertions.assertEquals("CLI_03", exception.getCode());
    }

}
