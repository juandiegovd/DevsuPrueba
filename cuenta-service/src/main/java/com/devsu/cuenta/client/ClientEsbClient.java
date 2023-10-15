package com.devsu.cuenta.client;

import com.devsu.cuenta.dto.AccountRequestDto;
import com.devsu.cuenta.dto.ClientWebResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "clientEsbClient", url  = "${client.base-endpoint}")
public interface ClientEsbClient {
    @PutMapping("/account")
    void updateClientWithAccount(@RequestBody AccountRequestDto accountRequestDto);
    @GetMapping
    ClientWebResponseDto getClient(@RequestParam("documentNumber") String documentNumber);
}
