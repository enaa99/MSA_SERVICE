package com.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisteredBankingAccount {
    private final String registeredBankAccountId;
    private final String membershipId;
    private final String bankName; //enum
    private final String bankAccountNumber;
    private final boolean linkedStatusIsValid;

    public static RegisteredBankingAccount generateRegisterBankingAccount(
        RegisteredBankAccountId registeredBankAccountId,
        MembershipId membershipId,
        BankName bankName,
        BankAccountNumber bankAccountNumber,
        LinkedStatusIsValid isValid

    ){
        return new RegisteredBankingAccount(
                registeredBankAccountId.valuId,
                membershipId.valueId,
                bankName.valueName,
                bankAccountNumber.valueNumber,
                isValid.valueIsValid

        );}


    @Value
    public static class RegisteredBankAccountId {
        String valuId;
        public RegisteredBankAccountId(String value) {
            this.valuId = value;
        }
    }
    @Value
    public static class MembershipId {
        String valueId;
        public MembershipId(String value) {
            this.valueId = value;
        }
    }
    @Value
    public static class BankName {
        String valueName;
        public BankName(String value) {
            this.valueName = value;
        }
    }
    @Value
    public static class BankAccountNumber {
        String valueNumber;
        public BankAccountNumber(String  value) {
            this.valueNumber = value;
        }
    }

    @Value
    public static class LinkedStatusIsValid {
        boolean valueIsValid;
        public LinkedStatusIsValid(boolean value) {
            this.valueIsValid = value;
        }
    }
}
