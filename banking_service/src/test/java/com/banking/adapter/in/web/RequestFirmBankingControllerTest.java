package com.banking.adapter.in.web;

import com.banking.application.port.in.RequestFirmBankingCommand;
import com.banking.domain.FirmBankingRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class RequestFirmBankingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private WebApplicationContext ctx;
    @Test
    @DisplayName("FrimBanking 요청 테스트")
    void firmBankingRequest() throws Exception {

        RequestFirmBankingRequest request = new RequestFirmBankingRequest("shin", "123","KB","1244",1500);

        RequestFirmBankingCommand command = RequestFirmBankingCommand.builder().
                toBankName(request.getToBankName()).
                toBankAccountNumber(request.getToBankAccountNumber()).
                fromBankName(request.getToBankName()).
                fromBankAccountNumber(request.getFromBankAccountNumber()).
                moneyAmount(request.getMoneyAmount()).
                build();

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/banking/firmbanking/request")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(request))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("toBankName").value(command.getToBankName()))
                .andExpect(MockMvcResultMatchers.jsonPath("toBankAccountNumber").value(command.getToBankAccountNumber()))
                .andExpect(MockMvcResultMatchers.jsonPath("fromBankName").value(command.getFromBankName()))
                .andExpect(MockMvcResultMatchers.jsonPath("fromBankAccountNumber").value(command.getFromBankAccountNumber()))
                .andExpect(MockMvcResultMatchers.jsonPath("moneyAmount").value(command.getMoneyAmount()));




    }

}