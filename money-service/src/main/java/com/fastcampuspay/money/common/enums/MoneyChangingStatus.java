package com.fastcampuspay.money.common.enums;

import com.fastcampuspay.money.common.mapper.EnumMapperType;
import lombok.Getter;

@Getter
public enum MoneyChangingStatus implements EnumMapperType {
    NOT_ENOUGH_MONEY("잔액부족"),
    NOT_EXIST_MEMBERSHIP("미멤버십"),
    NOT_EXIST_MONEY_CHANGING_REQUEST("미변액요청");

    private final String title;
    MoneyChangingStatus(String title) {this.title = title;}

    @Override
    public String getCode() { return name();}

    @Override
    public String getTitle() { return title; }
}