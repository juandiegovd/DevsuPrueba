package com.devsu.cuenta.controller;

import com.devsu.cuenta.AbstractBaseJUnit5Test;
import com.devsu.cuenta.client.ClientEsbClient;
import com.devsu.cuenta.facade.AccountFacade;
import com.devsu.cuenta.repository.AccountRepository;
import com.devsu.cuenta.service.AccountServiceImpl;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ClientEsbClientTestConfig.class })
class AccountControllerTest extends AbstractBaseJUnit5Test {
    private static MockMvc mockMvc;

    private static WireMockServer mockService;

    @Autowired
    private ClientEsbClient clientEsbClient;

    private final AccountRepository accountRepository = Mockito.mock(AccountRepository.class);

    @BeforeEach
    void setUp() throws Exception {
        AccountServiceImpl accountService = new AccountServiceImpl(accountRepository, clientEsbClient);
        AccountFacade accountFacade = new AccountFacade(accountService);
        AccountController accountController = new AccountController(accountFacade);
        setupMockClientResponse();
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
    }

    public static void setupMockClientResponse() throws Exception {
        mockService = new WireMockServer(9561);
        mockService.stubFor(WireMock.get(WireMock.urlPathMatching("/clientes"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(readJSON("/ClientWebResponseDto.json"))));
        mockService.start();
    }

    @Test
    void createAccount() throws Exception{
        var accountDto = getJsonFromPath("/AccountDto.json");
        MvcResult mvcResult = mockMvc.perform(post("/cuentas")
                .content(accountDto)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    @AfterEach
    void tearDown(){
        mockService.stop();
    }
}
