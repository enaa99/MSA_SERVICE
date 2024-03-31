package com.membership.application.service;

import com.membership.adapter.out.persistence.MembershipJpaEntity;
import com.membership.application.port.in.RegisterMembershipCommand;
import com.membership.application.port.in.RegisterMembershipUseCase;
import com.membership.domain.Membership;
import com.membership.adapter.out.persistence.MembershipMapper;
import com.membership.application.port.out.RegisterMembershipPort;
import lombok.RequiredArgsConstructor;
import msa.hexagonal.common.common.UseCase;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;

    private final MembershipMapper membershipMapper;

    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {

        MembershipJpaEntity jpaEntity = registerMembershipPort.createMembership(
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsCorp(command.isCorp())
        );

        return membershipMapper.mapToDomainEntity(jpaEntity);
    }
}
