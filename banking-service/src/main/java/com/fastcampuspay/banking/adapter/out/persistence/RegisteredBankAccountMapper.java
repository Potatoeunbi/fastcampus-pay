package com.fastcampuspay.banking.adapter.out.persistence;

import com.fastcampuspay.membership.domain.Membership;
import org.springframework.stereotype.Component;

@Component //Bean으로써 동작해야 함으로.
public class RegisteredBankAccountMapper {
    public RegisteredBankAccount mapToDomainEntity(RegisteredBankAccountJpaEntity registeredBankAccountJpaEntity){
        return RegisteredBankAccount.generateMember(
                new RegisteredBankAccount.MembershipId(registeredBankAccountJpaEntity.getMembershipId() + ""),
                new RegisteredBankAccount.MembershipName(registeredBankAccountJpaEntity.getName()),
                new RegisteredBankAccount.MembershipEmail(registeredBankAccountJpaEntity.getEmail()),
                new Membership.MembershipAddress(registeredBankAccountJpaEntity.getAddress()),
                new RegisteredBankAccount.MembershipIsValid(registeredBankAccountJpaEntity.isValid()),
                new RegisteredBankAccount.MembershipIsCorp(registeredBankAccountJpaEntity.isCorp())
        );
    }
}
