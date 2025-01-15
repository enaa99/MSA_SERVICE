package com.moneyservice.application.port.in;

import com.moneyservice.domain.MoneyChangingRequest;

public interface IncreaseMoneyRequestUseCase {

    MoneyChangingRequest increaseMoneyRequest(IncreaseMoneyRequestCommand command);
}
