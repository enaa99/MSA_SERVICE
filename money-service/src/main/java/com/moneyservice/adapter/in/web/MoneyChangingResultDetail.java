package com.moneyservice.adapter.in.web;

import com.moneyservice.domain.ChangingTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyChangingResultDetail {
    private String moneyChangingRequestId;
    private ChangingTypeEnum moneyChangingType;
    private int amount;
    private MoneyChangingResultStatus status;

    enum MoneyChangingResultStatus{
        SUCCEEDED,
        FAILED,
        FAILED_NOT_ENOUGH_MONEY,
        FAILED_NOT_EXIST_MEMBERSHIP,
        FAILED_NOT_EXIST_MONEY_CHANGING_REQUEST
    }
}


