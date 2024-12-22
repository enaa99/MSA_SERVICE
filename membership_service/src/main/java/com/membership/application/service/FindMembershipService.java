package com.membership.application.service;


import com.membership.adapter.out.persistence.MembershipJpaEntity;
import com.membership.adapter.out.persistence.MembershipMapper;
import com.membership.application.port.in.FindMembershipCommand;
import com.membership.application.port.in.FindMembershipUseCase;
import com.membership.application.port.out.FindMembershipPort;
import com.membership.common.exception.MembershipNotFoundException;
import com.membership.domain.Membership;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import msa.hexagonal.common.common.UseCase;

@RequiredArgsConstructor
@UseCase
@Transactional
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipPort;
    private final MembershipMapper membershipMapper;
    @Override
    public Membership findMembership(FindMembershipCommand command) {
        MembershipJpaEntity entity = findMembershipPort.findMembership(new Membership.MembershipId(command.getMembershipId()))
                .orElseThrow(() -> new MembershipNotFoundException("Membership not found with ID: " + command.getMembershipId()));

        return membershipMapper.mapToDomainEntity(entity);
    }

    @Override
    public Membership findAxonMembership(FindMembershipCommand command) {
        return null;
    }
}
