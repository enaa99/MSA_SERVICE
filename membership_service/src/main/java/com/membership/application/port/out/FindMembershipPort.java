package com.membership.application.port.out;

import com.membership.adapter.out.persistence.MembershipJpaEntity;
import com.membership.domain.Membership;

import java.util.Optional;

public interface FindMembershipPort {
    Optional<MembershipJpaEntity> findMembership(
            Membership.MembershipId membershipId
    );
}
