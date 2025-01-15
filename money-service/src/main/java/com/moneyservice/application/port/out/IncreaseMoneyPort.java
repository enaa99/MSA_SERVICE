package com.moneyservice.application.port.out;

import com.moneyservice.adapter.out.persistence.MoneyChangingRequestJpaEntity;
import com.moneyservice.domain.MoneyChangingRequest;

public interface IncreaseMoneyPort {
    MoneyChangingRequestJpaEntity createMoneyChangingRequest(
            MoneyChangingRequest.TargetMembershipId targetMembershipId,
            MoneyChangingRequest.ChangingType changingType,
            MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount,
            MoneyChangingRequest.ChangingMoneyStatus changingMoneyStatus,
            MoneyChangingRequest.Uuid uuid
    );


}
