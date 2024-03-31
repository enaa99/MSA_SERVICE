package com.banking.adapter.out.persistence;

import com.banking.application.port.out.RequestFirmbankingPort;
import com.banking.domain.FirmBankingRequest;
import lombok.RequiredArgsConstructor;
import msa.hexagonal.common.common.PersistanceAdapter;

import java.util.UUID;

@PersistanceAdapter
@RequiredArgsConstructor
public class RequestFirmbankingPersistenceAdapter implements RequestFirmbankingPort {
    private final SpringDataFirmbankingRequestRepository firmbankingRequestRepository;
    @Override
    public RequestFirmbankingJapEntity createFirmbankingRequest(FirmBankingRequest.FromBankName fromBankName, FirmBankingRequest.FromBankAccountNumber fromBankAccountNumber, FirmBankingRequest.ToBankName toBankName, FirmBankingRequest.ToBankAccountNumber toBankAccountNumber, FirmBankingRequest.MoneyAmount moneyAmount, FirmBankingRequest.FirmBankingStatus firmBankingStatus) {
        return firmbankingRequestRepository.save(new RequestFirmbankingJapEntity(
                fromBankName.getFromBankName(),
                fromBankAccountNumber.getFromBankAccountNumber(),
                toBankName.getToBankName(),
                toBankAccountNumber.getToBankAccountNumber(),
                moneyAmount.getMoneyAmount(),
                firmBankingStatus.getFirmBankingStatus(),
                UUID.randomUUID()
        ));
    }

    @Override
    public RequestFirmbankingJapEntity modifyFirmbankingRequest(RequestFirmbankingJapEntity entity) {
        return firmbankingRequestRepository.save(entity);
    }

}
