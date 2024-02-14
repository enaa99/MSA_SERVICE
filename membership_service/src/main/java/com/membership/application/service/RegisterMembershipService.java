package com.membership.application.service;

import com.membership.adapter.out.persistence.MembershipJpaEntity;
import com.membership.application.port.in.RegisterMembershipUseCase;
import com.membership.domain.Membership;
import com.membership.adapter.out.persistence.MembershipMapper;
import com.membership.application.port.in.RegisMembershipCommand;
import com.membership.application.port.out.RegisterMembershipPort;
import common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;

    private final MembershipMapper membershipMapper;
    @Override
    public Membership registerMembership(RegisMembershipCommand command) {

        // command -> DB

        // biz loginc -> DB

        // external system
        // port, adapter
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
