package com.banking.application.port.out;

import com.banking.adapter.out.external.bank.ExternalFirmbankingRequest;
import com.banking.adapter.out.external.bank.FirmbankingResult;

public interface RequestExternalFirmbankingPort {
    FirmbankingResult requestExternalFirmbanking(ExternalFirmbankingRequest request);
}
