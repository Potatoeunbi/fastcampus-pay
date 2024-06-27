package com.fastcampuspay.banking.adapter.in.web;

import com.fastcampuspay.banking.application.port.in.RegisterBankAccountCommand;
import com.fastcampuspay.banking.application.port.in.RegisterBankAccountUseCase;
import com.fastcampuspay.banking.domain.RegisteredBankAccount;
import com.fastcampuspay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {
    private final RegisterBankAccountUseCase registeredBankAccountUseCase;

    @PostMapping(path = "/membership/register")
    RegisteredBankAccount registerMembership(@RequestBody final RegisterBankAccountRequest request) {

        /* request ~~
        request -> Command
        Usecase ~~(request를 받는게 아니라, command를 받아야함.)
        이렇게 하는 이유 : request 값이 바뀌더라도, 추가적으로 값을 더 추가하더라도. command라는 중간 계층을 이용해서 쉽게 호환성을 맞출 수 있음. 그래서 command를 이용
         */
        RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
                .membershipId(request.getMembershipId())
                .bankName(request.getBankName())
                .bankAccountNumber(request.getBankAccountNumber())
                .isValid(true)
                .build();

        return registeredBankAccountUseCase.registerMembership(command);
    }

}
