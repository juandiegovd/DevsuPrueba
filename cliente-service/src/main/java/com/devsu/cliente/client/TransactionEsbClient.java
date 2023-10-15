package com.devsu.cliente.client;

import com.devsu.cliente.dto.TransactionResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name = "accountEsbClient", url = "${transaction.base-endpoint}")
public interface TransactionEsbClient {
    @GetMapping
    List<TransactionResponseDto> getAccountWithTransactions(@RequestParam(value = "startDate")
                                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                                            @RequestParam(value = "finalDate")
                                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate finalDate, @RequestParam("id") Long clientId);
}
