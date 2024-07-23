package com.fastcampuspay.banking.application.port.in;


import com.fastcampuspay.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class FindRegisterBankAccountCommand extends SelfValidating<FindRegisterBankAccountCommand> {
    private final String bankAccountNumber;
}
