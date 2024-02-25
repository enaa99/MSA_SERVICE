package com.banking.application.service;

import com.banking.adapter.out.external.bank.BankAccount;
import com.banking.adapter.out.external.bank.GetBankAccountRequest;
import com.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.banking.adapter.out.persistence.RegisteredBankAccountMapper;
import com.banking.application.port.in.RegisterBankAccountCommand;
import com.banking.application.port.in.RegisterBankAccountUseCase;
import com.banking.application.port.out.RegisterBankAccountPort;
import com.banking.application.port.out.RequsetBankAcocuntInfoPort;
import com.banking.domain.RegisteredBankingAccount;
import lombok.RequiredArgsConstructor;
import msa.hexagonal.common.common.UseCase;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

    private final RegisterBankAccountPort registerBankAccountPort;
    private final RequsetBankAcocuntInfoPort requsetBankAcocuntInfoPort;
    private final RegisteredBankAccountMapper registeredBankAccountMapper;
    @Override
    public Optional<RegisteredBankingAccount> registerBankAccount(RegisterBankAccountCommand command) {

        // 은행 계좌를 등록해야하는 서비(비즈니스 로직)
        // 1. 등록된 계좌인지 확인한다
        // 외부의 은행에 이 계좌가 정상인지? 확인한다

        // 2. 등록가능한 계좌라면, 등록한다. 성공하면 등록정보 확인
        // 2-1. 등록가능하지 않은 계좌라면, 에러를 리턴
        //Biz Logic -> External System
        // Port -> Adapter -> External System
        BankAccount accountInfo = requsetBankAcocuntInfoPort.getBankAccountInfo(new GetBankAccountRequest(command.getBankName(), command.getBankAccountNumber()));
        boolean accountInfoValid = accountInfo.isValid();

        if(accountInfoValid){
            RegisteredBankingAccount registeredBankingAccount = registeredBankAccountMapper.mapToDomainEntity(registerBankAccountPort.createRegisteredBankAccount(
                    new RegisteredBankingAccount.MembershipId(command.getMembershipId()),
                    new RegisteredBankingAccount.BankName(command.getBankName()),
                    new RegisteredBankingAccount.BankAccountNumber(command.getBankAccountNumber()),
                    new RegisteredBankingAccount.LinkedStatusIsValid(command.isValid())));
            return Optional.ofNullable(registeredBankingAccount);
        } else {
            return Optional.empty();
        }

    }
}
