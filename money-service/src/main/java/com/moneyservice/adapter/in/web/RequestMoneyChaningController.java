package com.moneyservice.adapter.in.web;

import com.moneyservice.application.port.in.IncreaseMoneyRequestCommand;
import com.moneyservice.application.port.in.IncreaseMoneyRequestUseCase;
import com.moneyservice.domain.MoneyChangingRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import msa.hexagonal.common.common.WebAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
@Slf4j
public class RequestMoneyChaningController {
    private final IncreaseMoneyRequestUseCase increaseMoneyRequestUseCase;

    //private final DecreaseMoneyRequestUseCase decreaseMoneyRequestUseCase;

    @PostMapping("/money/increase")
    MoneyChangingResultDetail increaseMoneyChangingRequest(@RequestBody IncreaseMoneyChangingRequest request) {
        //register --
        // request--> Command
        // Usecase --(requset X, command)

        IncreaseMoneyRequestCommand command = IncreaseMoneyRequestCommand.builder()
                .tagetMembershipId(request.getTargetMembershipId())
                .amount(request.getAmount()).
                build();

        MoneyChangingRequest moneyChangingRequest = increaseMoneyRequestUseCase.increaseMoneyRequest(command);
        // MoneyChangingRequest -> MoneyChangingResultDetail
        MoneyChangingResultDetail resultDetail = new MoneyChangingResultDetail();

        return resultDetail;
    }

    @PostMapping("/money/decrease")
    MoneyChangingResultDetail decreaseMoneyChangingRequest(@RequestBody DecreaseMoneyChangingRequest request) {
        //register --
        // request--> Command
        // Usecase --(requset X, command)

//        IncreaseMoneyRequestCommand command = IncreaseMoneyRequestCommand.builder()
//                .membershipId(request.getMembershipId())
//                .bankName(request.getBankName())
//                .bankAccountNumber(request.getBankAccountNumber())
//                .isValid(request.isValid())
//                .build();

//        Optional<RegisteredBankingAccount> registeredBankingAccount = registerBankAccountUseCase.registerBankAccount(command);
//        return registeredBankingAccount.orElseGet(null);
//        -> MoneyChangingResultDetail
//        return increaseMoneyRequestUseCase.increaseMoneyRequest(command);
        return null;
    }
}
