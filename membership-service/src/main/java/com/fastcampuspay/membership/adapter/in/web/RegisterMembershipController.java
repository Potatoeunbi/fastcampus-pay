package com.fastcampuspay.membership.adapter.in.web;

import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {
    @PostMapping(path = "/membership/register")
    void registerMembership(@RequestBody final RegisterMembershipRequest request) {

        //request ~~

        // Usecase

    }

}
