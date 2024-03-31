package com.banking.application.port.in;

import com.banking.domain.FirmBankingRequest;

public interface RequestFirmBankingUseCase {

    FirmBankingRequest requestFirmBanking(RequestFirmBankingCommand command);
}
