package com.fastcampuspay.banking.application.port.in;


import com.fastcampuspay.banking.domain.RegisteredBankAccount;

//인터페이스로서 어떻게 실제 비즈니스 로직과 동작이 될 지 정의하는 부분. 밖에서 안으로 들어오는 데이터를 정의하는 부분이기 때문에 해당 파일은 이 곳에 둠
public interface FindRegisterBankAccountUseCase {
    RegisteredBankAccount findRegisteredBankAccount(FindRegisterBankAccountCommand bankAccount);
    //command는 어떤 명령이 안으로 들어올 때
}
