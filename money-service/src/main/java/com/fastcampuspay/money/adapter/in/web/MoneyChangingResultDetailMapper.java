package com.fastcampuspay.money.adapter.in.web;

import com.fastcampuspay.money.domain.MoneyChangingRequest;

public class MoneyChangingResultDetailMapper {

    public static MoneyChangingResultDetail mapToMoneyChangingDetail(MoneyChangingRequest moneyChangingRequest) {
        return new MoneyChangingResultDetail(
                moneyChangingRequest.getMoneyChangingRequestId(),
                moneyChangingRequest.getChangingMoneyType(),
                moneyChangingRequest.getChangingMoneyStatus(),
                moneyChangingRequest.getChangingMoneyAmount()
        );
    }

    public static MoneyChangingResultDetail mapFromMoneyChangingResult(MoneyChangingRequest moneyChangingRequest) {
        return new MoneyChangingResultDetail(
                moneyChangingRequest.getMoneyChangingRequestId(),
                moneyChangingRequest.getChangingMoneyType(),
                moneyChangingRequest.getChangingMoneyStatus(),
                moneyChangingRequest.getChangingMoneyAmount()
        );
    }
}
