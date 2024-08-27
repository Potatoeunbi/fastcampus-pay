package com.fastcampuspay.money.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//@AllArgsConstructor 모든 필드 값을 파라미터로 받는 생성자를 생성
@NoArgsConstructor
//@NoArgsConstructor : 파라미터가 없는 디폴트 생성자를 생성

/*
 머니를 변동하는 request에는 무엇이 들어갈까?
 이 api는 request 쪽에서만 받는 데이터기 떄문에
 이 api를 호출하는 request가 줄 데이터가 무엇인지 집중해서 정의하는 거임.
 */
public class IncreaseMoneyChangingRequest {
    private String targetMembershipId;
    private int amount;
}
