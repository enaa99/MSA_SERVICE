package com.banking.adapter.in.web;

import com.banking.application.port.in.RegisterBankAccountCommand;
import com.banking.application.port.in.RegisterBankAccountUseCase;
import com.banking.domain.RegisteredBankingAccount;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import msa.hexagonal.common.common.WebAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@WebAdapter
@RestController
@RequiredArgsConstructor
@Slf4j
public class RegisterBankAccountController {
    private final RegisterBankAccountUseCase registerBankAccountUseCase;
    @PostMapping("/banking/register")
    RegisteredBankingAccount registerBankAccount(@RequestBody RegisterBankAccountRequest request) {
        //register --
        // request--> Command
        // Usecase --(requset X, command)

        RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
                .membershipId(request.getMembershipId())
                .bankName(request.getBankName())
                .bankAccountNumber(request.getBankAccountNumber())
                .isValid(request.isValid())
                .build();

        Optional<RegisteredBankingAccount> registeredBankingAccount = registerBankAccountUseCase.registerBankAccount(command);
        return registeredBankingAccount.orElseGet(null);
    }
}
