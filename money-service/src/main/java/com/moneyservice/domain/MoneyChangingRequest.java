package com.moneyservice.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MoneyChangingRequest {
    private final String moneyChangingRequestId;

    // 어떤 고객의 증액/감액 요청했는지의 멤버 정
    private final String targetMembershipId;

    // 그 요청이 증액 요청인지 / 감액 요청인지
    private final ChangingTypeEnum changingType; // enum 0, 증액 1: 감액


    // 증액 또는 감액 요청의 금액
    private final int changingMoneyAccount;

    // 머니 변액 요청에 대한 상태
    private final ChangingMoneyStatusEnum changingMoneyStatus; // enum

    private final UUID uuid;
    private final Date createdAt;

    public static MoneyChangingRequest generateMoneyChangingRequest(
            MoneyChangingRequestId moneyChangingRequestId,
            TargetMembershipId targetMembershipId,
            ChangingType changingType,
            ChangingMoneyAmount changingMoneyAmount,
            ChangingMoneyStatus changingMoneyStatus,
            Uuid uuid,
            CreatedAt createdAt
    ) {

        return new MoneyChangingRequest(
                moneyChangingRequestId.value,
                targetMembershipId.value,
                changingType.value,
                changingMoneyAmount.value,
                changingMoneyStatus.value,
                uuid.value,
                createdAt.value
        );
    }


    public record MoneyChangingRequestId(String value) {
    }

    public record TargetMembershipId(String value) {
    }

    public record ChangingType(ChangingTypeEnum value) {
    }

    public record ChangingMoneyAmount(int value) {
    }

    public record ChangingMoneyStatus(ChangingMoneyStatusEnum value) {
    }

    public record Uuid(UUID value) {
    }

    public record CreatedAt(Date value) {
    }


}
