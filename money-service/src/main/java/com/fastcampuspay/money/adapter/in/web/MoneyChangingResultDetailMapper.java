package com.fastcampuspay.money.adapter.in.web;

public class MoneyChangingResultDetailMapper {

    public static MoneyChangingResultDetail mapFromMoneyChangingResult(MoneyChangingResult moneyChangingResult) {
        return new MoneyChangingResultDetail(
                moneyChangingResult.getMoneyChangingRequestId(),
                moneyChangingResult.getMoneyChangingType(),
                moneyChangingResult.getMoneyChangingResultStatus(),
                moneyChangingResult.getAmount()
        );
    }
}
