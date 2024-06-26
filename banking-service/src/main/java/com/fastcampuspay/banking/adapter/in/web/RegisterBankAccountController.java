package com.fastcampuspay.banking.adapter.in.web;

import com.fastcampuspay.common.WebAdapter;
import com.fastcampuspay.membership.application.port.in.RegisterMembershipCommand;
import com.fastcampuspay.membership.application.port.in.RegisterMembershipUseCase;
import com.fastcampuspay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {
    private final RegisterMembershipUseCase registerMembershipUsecase;

    @PostMapping(path = "/membership/register")
    Membership registerMembership(@RequestBody final RegisterBankAccountRequest request) {

        /* request ~~
        request -> Command
        Usecase ~~(request를 받는게 아니라, command를 받아야함.)
        이렇게 하는 이유 : request 값이 바뀌더라도, 추가적으로 값을 더 추가하더라도. command라는 중간 계층을 이용해서 쉽게 호환성을 맞출 수 있음. 그래서 command를 이용
         */
        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isValid(true)
                .isCorp(request.isCorp())
                .build();

        return registerMembershipUsecase.registerMembership(command);
    }

}
