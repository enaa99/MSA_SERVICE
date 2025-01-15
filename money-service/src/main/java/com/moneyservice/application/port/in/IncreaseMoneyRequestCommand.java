package com.moneyservice.application.port.in;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import msa.hexagonal.common.common.SelfValidating;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class IncreaseMoneyRequestCommand extends SelfValidating<IncreaseMoneyRequestCommand> {

    @NotNull
    private final String tagetMembershipId;

    @NotNull
    private final int amount;

    public IncreaseMoneyRequestCommand(String tagetMembershipId, int amount) {
        this.tagetMembershipId = tagetMembershipId;
        this.amount = amount;
        this.validateSelf();
    }


}
