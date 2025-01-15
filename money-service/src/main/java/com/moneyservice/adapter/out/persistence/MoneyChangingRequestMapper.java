package com.moneyservice.adapter.out.persistence;

import com.moneyservice.domain.ChangingMoneyStatusEnum;
import com.moneyservice.domain.ChangingTypeEnum;
import com.moneyservice.domain.MoneyChangingRequest;
import org.springframework.stereotype.Component;

@Component
public class MoneyChangingRequestMapper {
    public MoneyChangingRequest mapToDomainEntity(MoneyChangingRequestJpaEntity moneyChangingRequestJpaEntity) {
        return MoneyChangingRequest.generateMoneyChangingRequest(

                new MoneyChangingRequest.MoneyChangingRequestId(moneyChangingRequestJpaEntity.getMoneyChangingRequestId()+""),
                new MoneyChangingRequest.TargetMembershipId(moneyChangingRequestJpaEntity.getTargetMembershipId()),
                new MoneyChangingRequest.ChangingType(ChangingTypeEnum.getEnumValue(moneyChangingRequestJpaEntity.getMoneyChangingType())),
                new MoneyChangingRequest.ChangingMoneyAmount(moneyChangingRequestJpaEntity.getMoneyAmount()),
                new MoneyChangingRequest.ChangingMoneyStatus(ChangingMoneyStatusEnum.getEnumValue(moneyChangingRequestJpaEntity.getChangingMoneyStatus())),
                new MoneyChangingRequest.Uuid(moneyChangingRequestJpaEntity.getUuid()),
                new MoneyChangingRequest.CreatedAt(moneyChangingRequestJpaEntity.getTimestamp())

        );
    }
}
