package com.banking.adapter.out.persistence;

import com.banking.application.port.out.RegisterBankAccountPort;
import com.banking.domain.RegisteredBankingAccount;
import lombok.RequiredArgsConstructor;
import msa.hexagonal.common.common.PersistanceAdapter;

@PersistanceAdapter
@RequiredArgsConstructor
public class RegisteredBankAccountPersistenceAdapter implements RegisterBankAccountPort {

    private final SpringDataRegisteredBankAccountRepository registeredBankAccountRepository;

    @Override
    public RegisteredBankAccountJpaEntity createRegisteredBankAccount(RegisteredBankingAccount.MembershipId membershipId, RegisteredBankingAccount.BankName bankName, RegisteredBankingAccount.BankAccountNumber bankAccountNumber, RegisteredBankingAccount.LinkedStatusIsValid isValid) {
        return registeredBankAccountRepository.save(
                new RegisteredBankAccountJpaEntity(
                        membershipId.getValueId(),
                        bankName.getValueName(),
                        bankAccountNumber.getValueNumber(),
                        isValid.isValueIsValid()
                )
        );
    }
}
