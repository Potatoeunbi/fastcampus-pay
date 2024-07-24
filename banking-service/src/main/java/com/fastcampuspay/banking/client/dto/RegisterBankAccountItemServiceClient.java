package com.fastcampuspay.banking.client.dto;

import com.fastcampuspay.banking.domain.RegisteredBankAccount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "registerBankAccountItem", url = "http://localhost:8081")
public interface RegisterBankAccountItemServiceClient {

    @GetMapping("/banking/account/{bankAccountNumber}")
    RegisteredBankAccount findRegisterBankAccountByBankAccountNumber(@PathVariable("bankAccountNumber") String bankAccountNumber);



}
