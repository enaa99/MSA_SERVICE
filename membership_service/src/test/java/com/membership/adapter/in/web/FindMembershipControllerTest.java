package com.membership.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.membership.application.port.in.FindMembershipCommand;
import com.membership.domain.Membership;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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
class FindMembershipControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;
    @ParameterizedTest
    @ValueSource(strings = {"1"})
    @DisplayName("멤버쉽 아이디를 찾는다")
    void findMembershipByMemberId(String id) throws Exception {
        // given

        RegisterMembershipRequest request = new RegisterMembershipRequest("name","address","email",true);

        Membership membership = Membership.generateMembership(
                new Membership.MembershipId(id),
                new Membership.MembershipName(request.getName()),
                new Membership.MembershipEmail(request.getEmail()),
                new Membership.MembershipAddress(request.getAddress()),
                new Membership.MembershipIsValid(true),
                new Membership.MembershipIsCorp(request.isCorp())
        );

        FindMembershipCommand command = FindMembershipCommand.builder()
                .membershipId(id)
                .build();

        //when then
            mockMvc.perform(
                    MockMvcRequestBuilders.post("/membership/register")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(mapper.writeValueAsString(request))
            ).andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(
                MockMvcRequestBuilders.get("/membership/{id}",command.getMembershipId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(mapper.writeValueAsString(membership)));
    }

    @Test
    void findAxonMembershipByMemberId() {
    }
}