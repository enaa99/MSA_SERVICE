package com.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FirmBankingRequest {
    @Getter
    private final String firmbankingRequestId;
    @Getter
    private final String fromBankName;
    @Getter
    private final String fromBankAccountNumber;
    @Getter
    private final String toBankName;
    @Getter
    private final String toBankAccountNumber;
    @Getter
    private final int moneyAmount; //Only Won
    @Getter
    private final String firmbankingStatus; // 0: 요청, 1: 완료, 2: 실패
    @Getter
    private final UUID uuid;

    public static FirmBankingRequest generateFirmBankingRequest(
        FirmbankingRequestId firmbankingRequestId,
        FromBankName fromBankName,
        FromBankAccountNumber fromBankAccountNumber,
        ToBankName toBankName,
        ToBankAccountNumber toBankAccountNumber,
        MoneyAmount moneyAmount,
        FirmBankingStatus firmBankingStatus,
        UUID uuid
    ){

        return new FirmBankingRequest(
                firmbankingRequestId.getFirmbankingRequestId(),
                fromBankName.getFromBankName(),
                fromBankAccountNumber.getFromBankAccountNumber(),
                toBankName.getToBankName(),
                toBankAccountNumber.getToBankAccountNumber(),
                moneyAmount.getMoneyAmount(),
                firmBankingStatus.getFirmBankingStatus(),
                uuid
        );
    }
    @Value
    public static class FirmbankingRequestId{
        String firmbankingRequestId;
        public FirmbankingRequestId(String value)
        {
            this.firmbankingRequestId = value;
        }
    }
    @Value
    public static class FromBankName{
        String fromBankName;
        public FromBankName(String value)
        {
            this.fromBankName = value;
        }
    }
    @Value
    public static class FromBankAccountNumber{
        String fromBankAccountNumber;
        public FromBankAccountNumber(String value)
        {
            this.fromBankAccountNumber = value;
        }
    }
    @Value
    public static class ToBankName{
        String toBankName;
        public ToBankName(String value)
        {
            this.toBankName = value;
        }
    }
    @Value
    public static class ToBankAccountNumber{
        String toBankAccountNumber;
        public ToBankAccountNumber(String value)
        {
            this.toBankAccountNumber = value;
        }
    }
    @Value
    public static class MoneyAmount{
        int moneyAmount;
        public MoneyAmount(int value)
        {
            this.moneyAmount = value;
        }
    }
    @Value
    public static class FirmBankingStatus{
        String  firmBankingStatus;
        public FirmBankingStatus(String value)
        {
            this.firmBankingStatus = value;
        }
    }
}
