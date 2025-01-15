package com.moneyservice.adapter.out.persistence;

import com.moneyservice.application.port.out.IncreaseMoneyPort;
import com.moneyservice.domain.ChangingMoneyStatusEnum;
import com.moneyservice.domain.ChangingTypeEnum;
import com.moneyservice.domain.MoneyChangingRequest;
import lombok.RequiredArgsConstructor;
import msa.hexagonal.common.common.PersistanceAdapter;

import java.sql.Timestamp;

@PersistanceAdapter
@RequiredArgsConstructor
public class MoneyChangingRequestPersistenceAdapter implements IncreaseMoneyPort {
    private final SpringDataMoneyChangingRepository moneyChangingRepository;

    @Override
    public MoneyChangingRequestJpaEntity createMoneyChangingRequest(MoneyChangingRequest.TargetMembershipId targetMembershipId, MoneyChangingRequest.ChangingType changingType, MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount, MoneyChangingRequest.ChangingMoneyStatus changingMoneyStatus, MoneyChangingRequest.Uuid uuid) {
        return moneyChangingRepository.save(
                new MoneyChangingRequestJpaEntity(
                        targetMembershipId.value(),
                        ChangingTypeEnum.getIntValue(changingType.value()),
                        changingMoneyAmount.value(),
                        new Timestamp(System.currentTimeMillis()),
                        ChangingMoneyStatusEnum.getIntValue(changingMoneyStatus.value()),
                        uuid.value()
                )
        );
    }
}
