package com.fastcampuspay.membership.application.service;

import com.fastcampuspay.membership.application.port.in.RegisterMembershipCommand;
import com.fastcampuspay.membership.application.port.in.RegisterMembershipUsecase;
import com.fastcampuspay.membership.domain.Membership;

public class RegisterMembershipService implements RegisterMembershipUsecase {

    @Override
    public Membership registerMembership(RegisterMembershipCommand membership) {

        //command -> DB

        // biz logic -> DB

        // external system
        // port, adapter를 이용해서 통신해야 함.
        return null;
    }
}
