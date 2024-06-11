package com.fastcampuspay.membership.application.service;

import com.fastcampuspay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.fastcampuspay.membership.adapter.out.persistence.MembershipMapper;
import com.fastcampuspay.membership.application.port.in.RegisterMembershipCommand;
import com.fastcampuspay.membership.application.port.in.RegisterMembershipUseCase;
import com.fastcampuspay.membership.application.port.out.RegisterMembershipPort;
import com.fastcampuspay.membership.domain.Membership;
import common.UseCase;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
/*@Transactional
 1. 설명 : 클래스 단위 혹은 메서드 단위에 선언해주면 된다.
 2. 우선순위 : 클래스 메소드 -> 클래스 -> 인터페이스 메소드 -> 인터페이스
 */
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {

        //command -> DB

        // biz logic -> DB

        // external system
        // port, adapter를 이용해서 통신해야 함.

        MembershipJpaEntity jpaEntity = registerMembershipPort.createMembership(
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsCorp(command.isCorp())
        );

        //entity -> Membership : 이 변환하는 과정을 계속 해줘야 해서 편의를 위해서 MembershipMapper를 만들거임.

        return membershipMapper.mapToDomainEntity(jpaEntity);
    }
}
