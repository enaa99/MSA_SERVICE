package com.banking.application.port.out;

import com.banking.adapter.out.persistence.RequestFirmbankingJapEntity;
import com.banking.domain.FirmBankingRequest;

public interface RequestFirmbankingPort {

    RequestFirmbankingJapEntity createFirmbankingRequest(
            FirmBankingRequest.FromBankName fromBankName,
            FirmBankingRequest.FromBankAccountNumber fromBankAccountNumber,
            FirmBankingRequest.ToBankName toBankName,
            FirmBankingRequest.ToBankAccountNumber toBankAccountNumber,
            FirmBankingRequest.MoneyAmount moneyAmount,
            FirmBankingRequest.FirmBankingStatus firmBankingStatus
    );

    RequestFirmbankingJapEntity modifyFirmbankingRequest(
            RequestFirmbankingJapEntity entity
    );
}
