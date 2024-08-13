package com.fastcampuspay.banking.adapter.in.web;

import com.fastcampuspay.banking.application.port.in.FindRegisterBankAccountUseCase;
import com.fastcampuspay.banking.application.port.in.FindRegisterBankAccountCommand;
import com.fastcampuspay.banking.domain.RegisteredBankAccount;
import com.fastcampuspay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindRegisterBankAccountController {

    private final FindRegisterBankAccountUseCase findRegisterBankAccountUseCase;
    @GetMapping(path = "/banking/account/{bankAccountNumber}")
    public ResponseEntity<RegisteredBankAccount> findRegisterBankAccountByBankAccountNumber(@PathVariable String bankAccountNumber) {
        FindRegisterBankAccountCommand command = FindRegisterBankAccountCommand.builder()
                .bankAccountNumber(bankAccountNumber)
                .build();

        return ResponseEntity.ok(findRegisterBankAccountUseCase.findRegisteredBankAccount(command));
    }
}
