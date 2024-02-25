package com.banking.application.port.out;


import com.banking.adapter.out.external.bank.BankAccount;
import com.banking.adapter.out.external.bank.GetBankAccountRequest;

public interface RequsetBankAcocuntInfoPort {
    BankAccount getBankAccountInfo(GetBankAccountRequest requset);
}
