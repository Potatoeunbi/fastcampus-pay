package com.fastcampuspay.banking.application.service;

import com.fastcampuspay.banking.adapter.out.external.bank.BankAccount;
import com.fastcampuspay.banking.adapter.out.external.bank.GetBankAccountRequest;
import com.fastcampuspay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.fastcampuspay.banking.adapter.out.persistence.RegisteredBankAccountMapper;
import com.fastcampuspay.banking.application.port.in.RegisterBankAccountCommand;
import com.fastcampuspay.banking.application.port.in.RegisterBankAccountUseCase;
import com.fastcampuspay.banking.application.port.out.RegisterBankAccountPort;
import com.fastcampuspay.banking.application.port.out.RequestBankAccountInfoPort;
import com.fastcampuspay.banking.client.dto.RegisterBankAccountItemServiceClient;
import com.fastcampuspay.banking.domain.RegisteredBankAccount;
import com.fastcampuspay.common.UseCase;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
/*@Transactional
 1. 설명 : 클래스 단위 혹은 메서드 단위에 선언해주면 된다.
 2. 우선순위 : 클래스 메소드 -> 클래스 -> 인터페이스 메소드 -> 인터페이스
 */
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

    private final RegisterBankAccountPort registerBankAccontPort;
    private final RegisteredBankAccountMapper mapper;
    private final RequestBankAccountInfoPort requestBankAccountInfoPort;
    private final RegisterBankAccountItemServiceClient registerBankAccountItemServiceClient;

    @Override
    public RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command) {

        // 은행 계좌를 등록해야하는 서비스 (비즈니스 로직)

        // (멤버 서비스도 확인?) 여기서는 skip
        //command.getMembershipId()

        // 1. 등록된 계좌인지 확인한다.
        // 외부의 은행에 이 계좌 정산인지? 확인을 해야해요.
        // Biz Logic -> External System
        // Port -> Adapter -> External System 포트와 어댑터로 나가야지 그게 hexagonal architecture

        // Port를 먼저 정의. -> 이 비즈니스 로직에서 어떤 인터페이스를 구현하는 구현체인 어댑터가 필요한데 그걸 포트를 통해서 구현.

        BankAccount accountInfo = requestBankAccountInfoPort.getBankAccountInfo(new GetBankAccountRequest(command.getBankName(), command.getBankAccountNumber()));
        boolean accountIsValid = accountInfo.isValid();
        // 2. 등록가능한 계좌라면, 등록한다. 성공하면, 등록에 성공한 등록 정보를 리턴
        // 2-1. 등록가능하지 않은 계좌라면, 에러를 리턴

        
        if(accountIsValid){
            RegisteredBankAccount registeredBankAccount = registerBankAccountItemServiceClient.findRegisterBankAccountByBankAccountNumber(command.getBankAccountNumber());
            if (registeredBankAccount != null) {
                throw new IllegalArgumentException("Account already exists");
            }

            //등록 정보 저장
            RegisteredBankAccountJpaEntity savedAccountInfo = registerBankAccontPort.createRegisteredBankAccount(
                    new RegisteredBankAccount.MembershipId(command.getMembershipId()+""),
                    new RegisteredBankAccount.BankName(command.getBankName()),
                    new RegisteredBankAccount.BankAccountNumber(command.getBankAccountNumber()),
                    new RegisteredBankAccount.LinkedStatusIsValid(command.isValid())
            );
            return mapper.mapToDomainEntity(savedAccountInfo);
        }else{
            return null;
        }

    }
}
