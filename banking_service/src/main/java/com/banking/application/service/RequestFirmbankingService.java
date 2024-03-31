package com.banking.application.service;

import com.banking.adapter.out.external.bank.ExternalFirmbankingRequest;
import com.banking.adapter.out.external.bank.FirmbankingResult;
import com.banking.adapter.out.persistence.RequestFirmbankingJapEntity;
import com.banking.adapter.out.persistence.RequestFirmbankingMapper;
import com.banking.application.port.in.RequestFirmBankingCommand;
import com.banking.application.port.in.RequestFirmBankingUseCase;
import com.banking.application.port.out.RequestExternalFirmbankingPort;
import com.banking.application.port.out.RequestFirmbankingPort;
import com.banking.domain.FirmBankingRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import msa.hexagonal.common.common.UseCase;

import java.util.UUID;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RequestFirmbankingService implements RequestFirmBankingUseCase {

    private final RequestFirmbankingMapper mapper;
    private final RequestFirmbankingPort requestFirmbankingPort;
    private final RequestExternalFirmbankingPort requestExternalFirmbankingPortngPort;


    @Override
    public FirmBankingRequest requestFirmBanking(RequestFirmBankingCommand command) {

        // Business Logic
        // a -> b 계좌
        // 1. 요청에 대한 정보를 먼저 write. 요청 상태로
        RequestFirmbankingJapEntity requestedEntity = requestFirmbankingPort.createFirmbankingRequest(
                new FirmBankingRequest.FromBankName(command.getFromBankName()),
                new FirmBankingRequest.FromBankAccountNumber(command.getFromBankAccountNumber()),
                new FirmBankingRequest.ToBankName(command.getToBankName()),
                new FirmBankingRequest.ToBankAccountNumber(command.getToBankAccountNumber()),
                new FirmBankingRequest.MoneyAmount(command.getMoneyAmount()),
                new FirmBankingRequest.FirmBankingStatus("0")
        );

        // 2. 외부 은행에 펌뱅킹 요청
        FirmbankingResult result = requestExternalFirmbankingPortngPort.requestExternalFirmbanking(new ExternalFirmbankingRequest(
                        command.getFromBankName(),
                        command.getFromBankAccountNumber(),
                        command.getToBankName(),
                        command.getToBankAccountNumber()
                )
        );

        // Transactional UUID
        UUID randomUUID = UUID.randomUUID();
        requestedEntity.setUuid(randomUUID.toString());
        // 3. 결과에 따라 1번에서 작성된 FirmbankingRequest 정보를 Update

        if (result.getResultCode() == 0) {
            requestedEntity.setFirmbankingStatus("1");
        } else {
            requestedEntity.setFirmbankingStatus("2");
        }
        // 4. 결과를 리턴
        return mapper.mapToDomainEntity(requestFirmbankingPort.modifyFirmbankingRequest(requestedEntity), randomUUID);

    }
}
