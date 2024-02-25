package com.banking.adapter.out.persistence;

import com.banking.domain.RegisteredBankingAccount;
import org.springframework.stereotype.Component;

@Component
public class RegisteredBankAccountMapper {
    public RegisteredBankingAccount mapToDomainEntity(RegisteredBankAccountJpaEntity registeredBankAccountJpaEntity) {
        return RegisteredBankingAccount.generateRegisterBankingAccount(
                new RegisteredBankingAccount.RegisteredBankAccountId(registeredBankAccountJpaEntity.getRegisteredBankAccountId()+""),
                new RegisteredBankingAccount.MembershipId(registeredBankAccountJpaEntity.getMembershipId()+""),
                new RegisteredBankingAccount.BankName(registeredBankAccountJpaEntity.getBankName()),
                new RegisteredBankingAccount.BankAccountNumber(registeredBankAccountJpaEntity.getBankAccountNumber()),
                new RegisteredBankingAccount.LinkedStatusIsValid(registeredBankAccountJpaEntity.isLinkedStatusIsValid())
        );
    }
}
