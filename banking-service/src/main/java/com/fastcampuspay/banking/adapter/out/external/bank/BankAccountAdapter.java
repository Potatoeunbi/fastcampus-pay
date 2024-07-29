package com.fastcampuspay.banking.adapter.out.external.bank;

import com.fastcampuspay.banking.application.port.out.RequestBankAccountInfoPort;
import com.fastcampuspay.banking.application.port.out.RequestExternalFirmBankingPort;
import com.fastcampuspay.banking.domain.FirmBankingRequest;
import com.fastcampuspay.common.ExternalSystemAdapter;
import lombok.RequiredArgsConstructor;

@ExternalSystemAdapter
@RequiredArgsConstructor
//@RequiredArgsConstructor 생성자 주입 함수가 굳이 필요없게 됨.
public class BankAccountAdapter implements RequestBankAccountInfoPort, RequestExternalFirmBankingPort {
    //private final SpringDataRegisteredBankRepository bankAccountRepository;

    //실제로 외부 은행에 http를 통해서 실제 은행 계좌 정보를 가져오고
    // 실제 은행 계좌->BankAccount해야 하는게 정석.
    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest request){
        return new BankAccount(request.getBankName(), request.getBankAccountNumber(), true);
    }

    @Override
    public void requestExternalFirmBanking() {
        // 실제로 외부 은행에 http 통신을 통해서
        // 펌뱅킹 요청하고

        //그 결과를
        // 외부 은행의 실제 결과를->패캠 페이의 FirmBankingResult 파싱
        FirmBankingRequest result = new FirmBankingResult(0);
        return FirmBankingResult;
    }
}
