package com.fastcampuspay.membership.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//@AllArgsConstructor 모든 필드 값을 파라미터로 받는 생성자를 생성
@NoArgsConstructor
//@NoArgsConstructor : 파라미터가 없는 디폴트 생성자를 생성
public class ModifyMembershipRequest {
    private String membershipId;
    private String name;
    private String address;
    private String email;
    private boolean isCorp;
}
