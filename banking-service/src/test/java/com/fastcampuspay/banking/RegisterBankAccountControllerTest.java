package com.fastcampuspay.banking;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
/*
@RunWith
- 기능 : 어노테이션은 JUnit의 기본 실행 방식을 변경하거나, 커스텀한 실행 방식을 사용하고자 할 때 사용
- 테스트 실행자: @RunWith 어노테이션을 사용하여 테스트 클래스를 실행할 때 사용할 테스트 실행자를 지정할 수 있음
- 예시: SpringRunner.class를 @RunWith 어노테이션에 지정하여 스프링 애플리케이션 컨텍스트와 관련된 테스트를 실행할 수 있음
 */
@SpringBootTest
@AutoConfigureMockMvc
/*
@AutoConfigureMockMvc : 스프링 부트 테스트에서 MockMvc를 자동으로 구성하기 위해 사용. @SpringBootTest에서는 MockMvc를 빈으로 등록 안함
(MockMvc는 스프링 MVC 애플리케이션의 테스트를 작성할 때 사용되는 프레임워크)
 */
public class RegisterBankAccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void testRegisterBankAccount() throws Exception {

//        RegisterMembershipRequest request = new RegisterMembershipRequest("name", "email", "address", false);
//
//        Membership membership = Membership.generateMember(
//                new Membership.MembershipId("1"),
//                new Membership.MembershipName("name"),
//                new Membership.MembershipEmail("email"),
//                new Membership.MembershipAddress("address"),
//                new Membership.MembershipIsValid(true),
//                new Membership.MembershipIsCorp(false)
//        );
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.post("/membership/register")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(mapper.writeValueAsString(request))
//        ).andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string(mapper.writeValueAsString(membership)));
    }
}