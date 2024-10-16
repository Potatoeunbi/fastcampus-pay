package com.fastcampuspay.money.adapter.in.web;

import com.fastcampuspay.money.common.enums.MoneyChangingStatusAdvanced;
import com.fastcampuspay.money.common.enums.MoneyChangingType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyChangingResultDetail {
    private String moneyChangingRequestId;
    private MoneyChangingType moneyChangingType;
    private MoneyChangingStatusAdvanced moneyChangingResultStatus;
    private int amount;
}