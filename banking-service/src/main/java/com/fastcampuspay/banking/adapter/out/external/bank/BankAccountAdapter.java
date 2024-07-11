package com.fastcampuspay.banking.adapter.out.external.bank;

import com.fastcampuspay.banking.application.port.out.RequestBankAccountInfoPort;
import com.fastcampuspay.common.ExternalSystemAdapter;
import lombok.RequiredArgsConstructor;

@ExternalSystemAdapter
@RequiredArgsConstructor
//@RequiredArgsConstructor 생성자 주입 함수가 굳이 필요없게 됨.
public class BankAccountAdapter implements RequestBankAccountInfoPort {
    //private final SpringDataRegisteredBankRepository bankAccountRepository;

    //실제로 외부 은행에 http를 통해서 실제 은행 계좌 정보를 가져오고
    // 실제 은행 계좌->BankAccount해야 하는게 정석.
    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest request){
        return new BankAccount(request.getBankName(), request.getBankAccountNumber(), true);
    }

}
