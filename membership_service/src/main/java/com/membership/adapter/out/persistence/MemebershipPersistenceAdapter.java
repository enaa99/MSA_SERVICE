package com.membership.adapter.out.persistence;

import com.membership.application.port.out.FindMembershipPort;
import com.membership.application.port.out.ModifyMembershipPort;
import com.membership.domain.Membership;
import com.membership.application.port.out.RegisterMembershipPort;
import lombok.RequiredArgsConstructor;
import msa.hexagonal.common.common.PersistanceAdapter;

@PersistanceAdapter
@RequiredArgsConstructor
public class MemebershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;
    @Override
    public MembershipJpaEntity createMembership(
            Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsCorp membershipIsCorp) {
        return membershipRepository.save(
        new MembershipJpaEntity(
                membershipName.getValueName(),
                membershipAddress.getValueAddress(),
                membershipEmail.getValueEmail(),
                membershipIsValid.isValueValid(),
                membershipIsCorp.isValueIsCorp()
        ));
    }

    @Override
    public MembershipJpaEntity findMembership(Membership.MembershipId membershipId) {
        return membershipRepository.getReferenceById(Long.parseLong(membershipId.getValuId()));
    }

    @Override
    public MembershipJpaEntity modifyMembership(Membership.MembershipId membershipId, Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsCorp membershipIsCorp) {

        MembershipJpaEntity entity = membershipRepository.getReferenceById(Long.parseLong(membershipId.getValuId()));

        entity.setName(membershipName.getValueName());
        entity.setAddress(membershipAddress.getValueAddress());
        entity.setEmail(membershipEmail.getValueEmail());
        entity.setValid(membershipIsValid.isValueValid());
        entity.setCorp(membershipIsCorp.isValueIsCorp());

        return membershipRepository.save(entity);
    }
}
