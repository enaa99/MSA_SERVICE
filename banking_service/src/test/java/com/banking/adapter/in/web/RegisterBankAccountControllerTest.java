package com.banking.adapter.in.web;

import com.banking.domain.RegisteredBankingAccount;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.web.context.WebApplicationContext;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class RegisterBankAccountControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private WebApplicationContext ctx;

    @Test
    @DisplayName("뱅크 계좌 등록 테스트")
    void registerBankAccount() throws Exception {
        RegisterBankAccountRequest request = new RegisterBankAccountRequest("12", "신한은행", "1231235", true);

        RegisteredBankingAccount bankAccount = RegisteredBankingAccount.generateRegisterBankingAccount(
                new RegisteredBankingAccount.RegisteredBankAccountId("1"),
                new RegisteredBankingAccount.MembershipId(request.getMembershipId()),
                new RegisteredBankingAccount.BankName(request.getBankName()),
                new RegisteredBankingAccount.BankAccountNumber(request.getBankAccountNumber()),
                new RegisteredBankingAccount.LinkedStatusIsValid(request.isValid())
        );


        mockMvc.perform(
                        MockMvcRequestBuilders.post("/banking/register")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(request))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().bytes(mapper.writeValueAsBytes(bankAccount)));

    }
}
