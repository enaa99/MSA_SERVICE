package com.moneyservice.application.service;

import com.moneyservice.adapter.out.persistence.MoneyChangingRequestMapper;
import com.moneyservice.application.port.in.IncreaseMoneyRequestCommand;
import com.moneyservice.application.port.in.IncreaseMoneyRequestUseCase;
import com.moneyservice.application.port.out.IncreaseMoneyPort;
import com.moneyservice.domain.ChangingMoneyStatusEnum;
import com.moneyservice.domain.ChangingTypeEnum;
import com.moneyservice.domain.MoneyChangingRequest;
import lombok.RequiredArgsConstructor;
import msa.hexagonal.common.common.UseCase;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@UseCase
@Transactional
@RequiredArgsConstructor
public class IncreaseMoneyRequestService implements IncreaseMoneyRequestUseCase {

    private final IncreaseMoneyPort increaseMoneyPort;
    private final MoneyChangingRequestMapper moneyChangingRequestMapper;
    @Override
    public MoneyChangingRequest increaseMoneyRequest(IncreaseMoneyRequestCommand command) {

        // 머니의 충전, 증액이라는 과정
        // 1. 고객 정보가 정상인지 확인(Member-Service)

        // 2. 고객의 연동된 계좌가 있는지, 고객의 연동된 계좌의 잔액이 충분한 지 확인(Banking-Service)

        // 3. 법인 계좌 상태도 정상인지 확인(Banking-Service)

        // 4. 증액을 위한 "기록", 요청 상태로 MoneyChangingRequest를 생성(MoneyChangingRequest)

        // 5. 펌뱅킹 수행 (고객의 연동 계좌 -> 법인 계좌)(Banking-Service)

        // 6-1. 결과가 정상이라면, 성공적으로 MoneyChangingRequest 상태값을 변동 후에 확인

        // 성공 시 meber의 money값 증액 필요

        // 6-2. 결과가 실패라면, 실패라고 MoneyChangingRequest 상태값을 변동 후에 확


        return moneyChangingRequestMapper.mapToDomainEntity(
                increaseMoneyPort.createMoneyChangingRequest(
                        new MoneyChangingRequest.TargetMembershipId(command.getTagetMembershipId()),
                        new MoneyChangingRequest.ChangingType(ChangingTypeEnum.INCREASING),
                        new MoneyChangingRequest.ChangingMoneyAmount(command.getAmount()),
                        new MoneyChangingRequest.ChangingMoneyStatus(ChangingMoneyStatusEnum.REQUESTED),
                        new MoneyChangingRequest.Uuid(UUID.randomUUID())
                )
        );
    }
}
