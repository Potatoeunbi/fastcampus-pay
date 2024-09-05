package com.fastcampuspay.money.common.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum MoneyChangingStatusAdvanced {
    REQUESTED("요청", Collections.emptyList()),
    SUCCEEDED("성공", Collections.emptyList()),
    CANCELLED("취소", Collections.emptyList()),
    FAILED("실패", Arrays.asList(MoneyChangingStatus.NOT_ENOUGH_MONEY, MoneyChangingStatus.NOT_EXIST_MEMBERSHIP, MoneyChangingStatus.NOT_EXIST_MONEY_CHANGING_REQUEST));

    @Getter
    private final String title;
    private final List<MoneyChangingStatus> causeList;

    MoneyChangingStatusAdvanced(String title, List<MoneyChangingStatus> causeList) {
        this.title = title;
        this.causeList = causeList;
    }

    public static MoneyChangingStatusAdvanced findByCauseCode(String code) {
        return Arrays.stream(MoneyChangingStatusAdvanced.values())
                .filter(MoneyChangingStatus -> MoneyChangingStatus.hasCauseCode(code))
                .findAny()
                .orElse(null);
    }

    public boolean hasCauseCode(String code) {
        return causeList.stream().anyMatch(c -> c.getTitle().equals(code));
    }
}
