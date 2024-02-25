package com.membership.adapter.in.web;

import com.membership.application.port.in.ModifyMembershipCommand;
import com.membership.application.port.in.ModifyMembershipUseCase;
import com.membership.domain.Membership;
import lombok.extern.slf4j.Slf4j;
import msa.hexagonal.common.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@Slf4j
public class ModifyMembershipController {

    private final ModifyMembershipUseCase modifyMembershipUseCase;

    public ModifyMembershipController(ModifyMembershipUseCase modifyMembershipUseCase) {
        this.modifyMembershipUseCase = modifyMembershipUseCase;
    }


    @PostMapping("/membership/modify/{membershipId}")
    ResponseEntity<Membership> modifyMembership(@RequestBody ModifyMembershipRequest request) {

        ModifyMembershipCommand command = ModifyMembershipCommand.builder()
                .membershipId(request.getMembershipId())
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isValid(request.isValid())
                .isCorp(request.isCorp())
                .build();

        return ResponseEntity.ok(modifyMembershipUseCase.modifyMembership(command));
    }
}
