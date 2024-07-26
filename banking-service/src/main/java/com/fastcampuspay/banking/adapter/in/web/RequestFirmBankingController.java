package com.fastcampuspay.banking.adapter.in.web;

import com.fastcampuspay.banking.application.port.in.RequestFirmBankingCommand;
import com.fastcampuspay.banking.application.port.in.RequestFirmBankingUseCase;
import com.fastcampuspay.banking.domain.FirmBankingRequest;
import com.fastcampuspay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestFirmBankingController {
    private final RequestFirmBankingUseCase requestFirmBankingUseCase;

    @PostMapping(path = "/banking/firmBanking/request")
    FirmBankingRequest registerMembership(@RequestBody final RequestFirmBankingRequest request) {

        RequestFirmBankingCommand command = RequestFirmBankingCommand.builder()
                .toBankName(request.getToBankName())
                .fromBankName(request.getFromBankName())
                .toBankAccountNumber(request.getToBankAccountNumber())
                .fromBankAccountNumber(request.getFromBankAccountNumber())
                .moneyAmount(request.getMoneyAmount())
                .build();

        FirmBankingRequest firmBankingRequest = requestFirmBankingUseCase.requestFirmBanking(command);
        if(firmBankingRequest == null) {
            // ToDo : Error Handling
            return null;
        }

        return firmBankingRequest;
    }

}
