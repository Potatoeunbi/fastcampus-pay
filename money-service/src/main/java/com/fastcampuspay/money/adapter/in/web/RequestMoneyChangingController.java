package com.fastcampuspay.money.adapter.in.web;

import com.fastcampuspay.common.WebAdapter;
import com.fastcampuspay.money.application.port.in.IncreaseMoneyRequestCommand;
import com.fastcampuspay.money.application.port.in.IncreaseMoneyRequestUseCase;
import com.fastcampuspay.money.domain.MoneyChangingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestMoneyChangingController {
    private final IncreaseMoneyRequestUseCase increaseMoneyRequestUseCase;
//    private final DecreaseMoneyRequestUseCase decreaseMoneyRequestUseCase;

    @PostMapping(path = "/money/increase")
    MoneyChangingResultDetail increaseMoneyChangingRequest(@RequestBody IncreaseMoneyChangingRequest request) {
        /*
        MoneyChangingResultDetail은 인바운드에 웹 패키지에 두었는데,
        바로 위에 MoneyChangingResultDetail로 반환되는 이 객체는 usecase로부터 받은 데이터를 가지고 인바운드 웹어댑터에서
        파싱을 해주는게 좋다.
        -> Usecase 계층에서는 순수하게 비즈니스 로직만 처리하고, 인바운드 웹 어댑터에서 이 데이터를 클라이언트에게 전달하기 위한 형식으로 변환(파싱)하는 것이 좋다는 의미
         */

        IncreaseMoneyRequestCommand command = IncreaseMoneyRequestCommand.builder()
                .targetMembershipId(request.getTargetMembershipId())
                .amount(request.getAmount())
                .build();

        MoneyChangingRequest moneyChangingRequest = ;
        // MoneyChangingRequest -> MoneyChangingResultDetail

        return increaseMoneyRequestUseCase.increaseMoneyRequest(command);
    }

    @PostMapping(path = "/money/decrease")
    MoneyChangingResultDetail decreaseMoneyChangingRequest(@RequestBody DecreaseMoneyChangingRequest request) {
//        RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
//                .membershipId(request.getMembershipId())
//                .bankName(request.getBankName())
//                .bankAccountNumber(request.getBankAccountNumber())
//                .isValid(true)
//                .build();
//
//        RegisteredBankAccount registeredBankAccount = registeredBankAccountUseCase.registerBankAccount(command);

        //return decreaseMoneyRequestUseCase.decreaseMoneyChangingRequest(command);
        return null;
    }
}
