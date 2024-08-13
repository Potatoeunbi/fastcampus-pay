package com.fastcampuspay.banking.application.service;

import com.fastcampuspay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.fastcampuspay.banking.adapter.out.persistence.RegisteredBankAccountMapper;
import com.fastcampuspay.banking.application.port.in.FindRegisterBankAccountCommand;
import com.fastcampuspay.banking.application.port.in.FindRegisterBankAccountUseCase;
import com.fastcampuspay.banking.application.port.out.FindRegisterBankAccountPort;
import com.fastcampuspay.banking.domain.RegisteredBankAccount;
import com.fastcampuspay.common.UseCase;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
/* findMembershipUseCase도 findMembership 구현할 것이고, 이 findMembership 즉 비즈니스 로직에서도 out bound로 port를 조회하기 위해서 findMembership을 사용*/
public class FindRegisterBankAccountService implements FindRegisterBankAccountUseCase {
    private final FindRegisterBankAccountPort findRegisterBankAccountPort;
    private final RegisteredBankAccountMapper mapper;
    @Override
    public RegisteredBankAccount findRegisteredBankAccount(FindRegisterBankAccountCommand command) {
        RegisteredBankAccountJpaEntity entity = findRegisterBankAccountPort.findRegisteredBankAccount( new RegisteredBankAccount.BankAccountNumber(command.getBankAccountNumber()));
        if (entity == null) {
            return null;
        }
        return mapper.mapToDomainEntity(entity);
    }
}
