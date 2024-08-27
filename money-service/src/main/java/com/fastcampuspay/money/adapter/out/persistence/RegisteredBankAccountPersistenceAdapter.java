package com.fastcampuspay.money.adapter.out.persistence;

import com.fastcampuspay.banking.application.port.out.FindRegisterBankAccountPort;
import com.fastcampuspay.banking.application.port.out.RegisterBankAccountPort;
import com.fastcampuspay.banking.domain.RegisteredBankAccount;
import com.fastcampuspay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
/* 영속성 어댑터
 1. 입력을 받는다.
 2. 입력을 데이터베이스 포맷으로 매핑한다.
 3. 입력을 데이터베이스로 보낸다.
 4. 데이터베이스 출력을 애플리케이션 포맷으로 매핑한다.
 5. 출력을 반환한다.
 - 영속성 어댑터는 포트 인터페이스를 통해 입력을 받는다.
 - 영속성 어댑터는 데이터베이스를 쿼리 하거나 변경하는 데 사용할 수 있는 포맷으로 입력 모델을 매핑한다.
 - 영속성 어댑터는 데이터베이스에 쿼리를 날리고 쿼리 결과를 받아온다.
 - 데이터베이스 응답을 포트에 정의된 출력 모델을 매핑해서 반환한다.
 - 출력 모델이 영속성 어댑터가 아니라 애플리케이션 코어에 위치하는 것이 중요하다. */
@RequiredArgsConstructor
//@RequiredArgsConstructor 생성자 주입 함수가 굳이 필요없게 됨.
public class RegisteredBankAccountPersistenceAdapter implements RegisterBankAccountPort, FindRegisterBankAccountPort {
    private final SpringDataRegisteredBankRepository bankAccountRepository;

    @Override
    public RegisteredBankAccountJpaEntity createRegisteredBankAccount(RegisteredBankAccount.MembershipId membershipId, RegisteredBankAccount.BankName bankName, RegisteredBankAccount.BankAccountNumber bankAccountNumber, RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid) {
        return bankAccountRepository.save(
                new RegisteredBankAccountJpaEntity(
                        membershipId.getMembershipId(),
                        bankName.getBankName(),
                        bankAccountNumber.getBankAccountNumber(),
                        linkedStatusIsValid.isLinkedStatusIsValid()
                )

        );
    }

    @Override
    public RegisteredBankAccountJpaEntity findRegisteredBankAccount(RegisteredBankAccount.BankAccountNumber bankAccountNumber) {
        RegisteredBankAccountJpaEntity entity = bankAccountRepository.findByBankAccountNumber(bankAccountNumber.getBankAccountNumber());
        return entity;
    }
}
