package com.fastcampuspay.banking.adapter.out.external.bank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// 외부의 통신을 담당하는 패키지이니, 똑같이 생겼더라도 다른 목적을 가지고 쓰는 거라 다시 정의하는 걸 알아야함.
public class ExternalFirmBankingRequest {
    private String fromBankName;

}
