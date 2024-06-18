package com.fastcampuspay.membership.adapter.in.web;

import com.fastcampuspay.membership.application.port.in.FindMembershipCommand;
import com.fastcampuspay.membership.domain.Membership;
import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class ModifyMembershipController {

    private final ModifyMembershipUseCase modifyMembershipUseCase;
    @PostMapping(path = "/membership/modify/{membershipId}")
    ResponseEntity<Membership> modifyMembershipByMemberId(@RequestBody ModifyMembershipRequest request) {
        //@PathVariable 어노테이션을 사용하여 {membershipId} 변수로 표시되는 URI의 템플릿 부분을 추출합니다 .

        /* request ~~
        request -> Command
        Usecase ~~(request를 받는게 아니라, command를 받아야함.)
        이렇게 하는 이유 : request 값이 바뀌더라도, 추가적으로 값을 더 추가하더라도. command라는 중간 계층을 이용해서 쉽게 호환성을 맞출 수 있음. 그래서 command를 이용
         */
        FindMembershipCommand command = FindMembershipCommand.builder()
                .membershipId(membershipId)
                .build();

        return ResponseEntity.ok(findMembershipUseCase.findMembership(command));
    }
}
