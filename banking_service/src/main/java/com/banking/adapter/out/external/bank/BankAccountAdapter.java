package com.banking.adapter.out.external.bank;

import com.banking.adapter.out.persistence.SpringDataRegisteredBankAccountRepository;
import com.banking.application.port.out.RequsetBankAcocuntInfoPort;
import lombok.RequiredArgsConstructor;
import msa.hexagonal.common.common.ExternalSystemAdapter;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class BankAccountAdapter implements RequsetBankAcocuntInfoPort {

    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest requset) {
        return new BankAccount(requset.getBankName(), requset.getBankAccountNumber(), true);
    }
}
