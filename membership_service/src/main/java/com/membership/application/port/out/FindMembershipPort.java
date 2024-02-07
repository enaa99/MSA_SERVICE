package com.membership.application.port.out;

import com.membership.adapter.out.persistence.MembershipJpaEntity;
import com.membership.domain.Membership;

public interface FindMembershipPort {
    MembershipJpaEntity findMembership(
            Membership.MembershipId membershipId
    );
}
