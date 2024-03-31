package com.banking.adapter.out.external.bank;

import com.banking.adapter.out.persistence.SpringDataRegisteredBankAccountRepository;
import com.banking.application.port.out.RequestExternalFirmbankingPort;
import com.banking.application.port.out.RequsetBankAcocuntInfoPort;
import com.banking.domain.FirmBankingRequest;
import lombok.RequiredArgsConstructor;
import msa.hexagonal.common.common.ExternalSystemAdapter;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class BankAccountAdapter implements RequsetBankAcocuntInfoPort, RequestExternalFirmbankingPort {

    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest requset) {
        return new BankAccount(requset.getBankName(), requset.getBankAccountNumber(), true);
    }

    @Override
    public FirmbankingResult requestExternalFirmbanking(ExternalFirmbankingRequest request) {
        // 실제로 외부 은행에 http 통신을 통해서
        // 펌 뱅킹 요청을 하고


        // 그 결과를
        // 외부 은행의 실제 결과를 -> 페이의 FirmbankingResult 파싱

        return new FirmbankingResult(0);
    }
}
