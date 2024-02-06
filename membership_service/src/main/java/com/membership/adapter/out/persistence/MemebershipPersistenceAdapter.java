package com.membership.adapter.out.persistence;

import com.membership.domain.Membership;
import com.membership.application.port.out.RegisterMembershipPort;
import common.PersistanceAdapter;
import lombok.RequiredArgsConstructor;

@PersistanceAdapter
@RequiredArgsConstructor
public class MemebershipPersistenceAdapter implements RegisterMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;
    @Override
    public MembershipJpaEntity createMembership(Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsCorp membershipIsCorp) {
        return membershipRepository.save(
        new MembershipJpaEntity(
                membershipName.getValueName(),
                membershipEmail.getValueEmail(),
                membershipAddress.getValueEmail(),
                membershipIsValid.isValueValid(),
                membershipIsCorp.isValueIsCorp()
        ));
    }
}
