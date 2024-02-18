package com.membership.application.port.in;

import jakarta.validation.ValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static com.membership.application.port.in.ModifyMembershipCommand.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


@RunWith(SpringRunner.class)
class ModifyMembershipCommandTest {
    @Test
    @DisplayName("ModifyMembershipCommand 실패 테스트")
    void validateFailSelf() {
        assertThrows(ValidationException.class, () -> {
            ModifyMembershipCommand command = builder()
                    .membershipId("1")
                    .name("hi")
                    .address("email")
                    .email("address")
                    .build();
        });
    }

    @Test
    @DisplayName("ModifyMembershipCommand 성공 테스트")
    void validateSuccessSelf() {
        assertThat(builder()
                .membershipId("1")
                .name("hi")
                .address("email")
                .email("address")
                .isValid(true)
                .build()).isInstanceOf(ModifyMembershipCommand.class);
    }
}