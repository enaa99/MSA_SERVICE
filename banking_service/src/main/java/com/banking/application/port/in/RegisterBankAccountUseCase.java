package com.banking.application.port.in;

import com.banking.domain.RegisteredBankingAccount;

import java.util.Optional;

public interface RegisterBankAccountUseCase {

    Optional<RegisteredBankingAccount> registerBankAccount(RegisterBankAccountCommand command);
}
