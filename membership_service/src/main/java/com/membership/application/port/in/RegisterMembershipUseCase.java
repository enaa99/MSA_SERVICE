package com.membership.application.port.in;

import com.membership.domain.Membership;

public interface RegisterMembershipUseCase {

    Membership registerMembership(RegisterMembershipCommand command);
}
