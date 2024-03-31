package com.banking.adapter.in.web;

import com.banking.application.port.in.RequestFirmBankingCommand;
import com.banking.application.port.in.RequestFirmBankingUseCase;
import com.banking.domain.FirmBankingRequest;
import lombok.RequiredArgsConstructor;
import msa.hexagonal.common.common.WebAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestFirmBankingController {

    private final RequestFirmBankingUseCase requestFirmBankingUseCase;

    @PostMapping(path = "/banking/firmbanking/request")
    FirmBankingRequest firmBankingRequest(@RequestBody RequestFirmBankingRequest request) {

        RequestFirmBankingCommand command = RequestFirmBankingCommand.builder().
                toBankName(request.getToBankName()).
                toBankAccountNumber(request.getToBankAccountNumber()).
                fromBankName(request.getToBankName()).
                fromBankAccountNumber(request.getFromBankAccountNumber()).
                moneyAmount(request.getMoneyAmount()).
                build();

        return requestFirmBankingUseCase.requestFirmBanking(command);
    }

}
