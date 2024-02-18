package com.membership.application.port.in;

import jakarta.validation.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static com.membership.application.port.in.ModifyMembershipCommand.*;
import static org.assertj.core.api.Assertions.*;


@RunWith(SpringRunner.class)
class ModifyMembershipCommandTest {
    @Test
    void validateFailSelf() {
        Assertions.assertThrows(ValidationException.class, () -> {
            ModifyMembershipCommand command = ModifyMembershipCommand.builder()
                    .membershipId("1")
                    .name("hi")
                    .address("email")
                    .email("address")
                    .build();
        });
    }

    @Test
    void validateSuccessSelf() {
        assertThat(ModifyMembershipCommand.builder()
                .membershipId("1")
                .name("hi")
                .address("email")
                .email("address")
                .isValid(true)
                .build()).isInstanceOf(ModifyMembershipCommand.class);
    }
}