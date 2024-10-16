package com.fastcampuspay.money.application.service;

import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.money.adapter.out.persistence.MoneyChangingRequestMapper;
import com.fastcampuspay.money.application.port.in.IncreaseMoneyRequestCommand;
import com.fastcampuspay.money.application.port.in.IncreaseMoneyRequestUseCase;
import com.fastcampuspay.money.application.port.out.IncreaseMoneyPort;
import com.fastcampuspay.money.domain.MoneyChangingRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
/*@Transactional
 1. 설명 : 클래스 단위 혹은 메서드 단위에 선언해주면 된다.
 2. 우선순위 : 클래스 메소드 -> 클래스 -> 인터페이스 메소드 -> 인터페이스
 */
public class IncreaseMoneyRequestService implements IncreaseMoneyRequestUseCase {

    private final IncreaseMoneyPort increaseMoneyPort;
    private final MoneyChangingRequestMapper mapper;

    @Override
    public MoneyChangingRequest increaseMoneyRequest(IncreaseMoneyRequestCommand command) {

        //머니의 충전.증액이라느 과정
        // 1. 고객 정보가 정상인지 확인

        // 2. 고객의 연동된 계좌가 있는지, 그리고 정상적인지 확인, 고객의 연동된 계좌의 잔액이 충분한지도 확인

        // 3. 법인 계좌 상태도 정상인지 확인

        // 4. 증액을 위한 "기록". 요청 상태로 MoneyChangingRequest를 생성한다.

        // 5. 펌뱅킹을 수행하고 (고객의 연동된 계좌 -> 패캠페이 법인 계좌)

        // 6-1. 결과가 정상적이라면. 성공으로 MoneyChangingRequest 상태값을 변동 후에 리턴

        // 6-2. 결과가 실패라면, 실패라고 MoneyChangingRequest 상태값을 변동 후에 리턴

        return null;
    }
}
