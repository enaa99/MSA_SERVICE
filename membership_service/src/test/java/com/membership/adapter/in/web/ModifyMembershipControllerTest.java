package com.membership.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.membership.domain.Membership;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
@SpringBootTest
@AutoConfigureMockMvc
class ModifyMembershipControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    @DisplayName("멤버십 변경 테스트")
    void modifyMembership() throws Exception {
        // given
        String id = "1";

        RegisterMembershipRequest request = new RegisterMembershipRequest("name","address","email",true);
        Membership membership = Membership.generateMembership(
                new Membership.MembershipId(id),
                new Membership.MembershipName(request.getName()),
                new Membership.MembershipEmail(request.getEmail()),
                new Membership.MembershipAddress(request.getAddress()),
                new Membership.MembershipIsValid(true),
                new Membership.MembershipIsCorp(request.isCorp())
        );

        // membership 저장
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/membership/register")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(request))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(mapper.writeValueAsString(membership)));


        // Modifiy MemberShip
        ModifyMembershipRequest modifyRequest = new ModifyMembershipRequest();
        modifyRequest.setName("hi");
        modifyRequest.setAddress("Seoul");
        modifyRequest.setEmail("abcd@gmail.com");
        modifyRequest.setValid(true);
        modifyRequest.setCorp(false);

        // when, then
        Membership membership2 = Membership.generateMembership(
                new Membership.MembershipId(id),
                new Membership.MembershipName(modifyRequest.getName()),
                new Membership.MembershipEmail(modifyRequest.getEmail()),
                new Membership.MembershipAddress(modifyRequest.getAddress()),
                new Membership.MembershipIsValid(modifyRequest.isValid()),
                new Membership.MembershipIsCorp(modifyRequest.isCorp())
        );

        mockMvc.perform(
                MockMvcRequestBuilders.put("/membership/{membershipId}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(modifyRequest))
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(mapper.writeValueAsString(membership2)));

    }
}