package com.membership.application.port.in;

import com.membership.domain.Membership;

public interface FindMembershipUseCase {

    Membership findMembership(FindMembershipCommand command);
    Membership findAxonMembership(FindMembershipCommand command);
}
