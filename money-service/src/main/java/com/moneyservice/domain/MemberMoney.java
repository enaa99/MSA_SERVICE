package com.moneyservice.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberMoney {
    private final String memberMoneyId;

    private final String memberShipId;

    private final int balance;

    //private final int linkedBankAccount;


    public static MemberMoney generateMemberMoney(
            MemberMoneyId memberMoneyId,
            MembershipId membershipId,
            Balance balance
    ) {

        return new MemberMoney(
                memberMoneyId.value,
                membershipId.value,
                balance.value
        );
    }


    public record MemberMoneyId(String value) {
    }

    public record MembershipId(String value) {
    }

    public record Balance(int value) {
    }


}
