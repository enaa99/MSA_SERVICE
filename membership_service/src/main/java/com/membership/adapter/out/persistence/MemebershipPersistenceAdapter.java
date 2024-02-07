package com.membership.adapter.out.persistence;

import com.membership.application.port.out.FindMembershipPort;
import com.membership.domain.Membership;
import com.membership.application.port.out.RegisterMembershipPort;
import common.PersistanceAdapter;
import lombok.RequiredArgsConstructor;

@PersistanceAdapter
@RequiredArgsConstructor
public class MemebershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {

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

    @Override
    public MembershipJpaEntity findMembership(Membership.MembershipId membershipId) {
        return membershipRepository.getReferenceById(Long.parseLong(membershipId.getValuId()));
    }
}
