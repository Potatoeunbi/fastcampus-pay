package com.fastcampuspay.banking.application.port.in;
import com.fastcampuspay.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class RequestFirmBankingCommand extends SelfValidating<RequestFirmBankingCommand> {

    @NotNull
    private final String fromBankName;

    @NotNull
    private final String fromBankAccountNumber;

    @NotNull
    private final String toBankName;

    @NotNull
    private final String toBankAccountNumber;

    @NotNull
    private final int moneyAmount; //won

    public RequestFirmBankingCommand(String fromBankName, String fromBankAccountNumber, String toBankName, String toBankAccountNumber, int moneyAmount) {
        this.fromBankName = fromBankName;
        this.fromBankAccountNumber = fromBankAccountNumber;
        this.toBankName = toBankName;
        this.toBankAccountNumber = toBankAccountNumber;
        this.moneyAmount = moneyAmount;
    }
}
