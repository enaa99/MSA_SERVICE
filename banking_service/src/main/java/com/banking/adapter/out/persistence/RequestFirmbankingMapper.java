package com.banking.adapter.out.persistence;

import com.banking.domain.FirmBankingRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RequestFirmbankingMapper {
    public FirmBankingRequest mapToDomainEntity(RequestFirmbankingJapEntity requestFirmbankingJapEntity, UUID uuid) {
        return FirmBankingRequest.generateFirmBankingRequest(
                new FirmBankingRequest.FirmbankingRequestId(requestFirmbankingJapEntity.getRequestFrimbankingId() + ""),
                new FirmBankingRequest.FromBankName(requestFirmbankingJapEntity.getFromBankName() + ""),
                new FirmBankingRequest.FromBankAccountNumber(requestFirmbankingJapEntity.getFromBankAccountNumber()),
                new FirmBankingRequest.ToBankName(requestFirmbankingJapEntity.getToBankName()),
                new FirmBankingRequest.ToBankAccountNumber(requestFirmbankingJapEntity.getToBankAccountNumber()),
                new FirmBankingRequest.MoneyAmount(requestFirmbankingJapEntity.getMoneyAmount()),
                new FirmBankingRequest.FirmBankingStatus(requestFirmbankingJapEntity.getFirmbankingStatus()),
                uuid
        );
    }
}
