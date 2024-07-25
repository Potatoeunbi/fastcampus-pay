package com.fastcampuspay.banking.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//@AllArgsConstructor 모든 필드 값을 파라미터로 받는 생성자를 생성
@NoArgsConstructor
//@NoArgsConstructor : 파라미터가 없는 디폴트 생성자를 생성
public class RequestFirmBankingRequest {
    // a->b 실물계좌로 요청 하기 위한 request
    private String fromBankName;
    private String fromBankAccountNumber;
    private String toBankName;
    private String toBankAccountNumber;
    private int moneyAmount; //only won
}
