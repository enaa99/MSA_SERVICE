package com.banking.application.port.out;

import com.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.banking.domain.RegisteredBankingAccount;

public interface RegisterBankAccountPort {
    RegisteredBankAccountJpaEntity createRegisteredBankAccount(
            RegisteredBankingAccount.MembershipId membershipId,
            RegisteredBankingAccount.BankName bankName,
            RegisteredBankingAccount.BankAccountNumber bankAccountNumber,
            RegisteredBankingAccount.LinkedStatusIsValid isValid
    );

}
