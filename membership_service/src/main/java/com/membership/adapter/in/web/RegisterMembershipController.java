package com.membership.adapter.in.web;

import com.membership.application.port.in.RegisMembershipCommand;
import com.membership.application.port.in.RegisterMembershipUseCase;
import com.membership.domain.Membership;
import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
@Slf4j
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;


    @PostMapping("/membership/register")
    Membership registerMembership(@RequestBody RegisterMembershipRequest request) {
        //register --
        // request--> Command
        // Usecase --(requset X, command)

        RegisMembershipCommand command = RegisMembershipCommand.builder()
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isValid(true)
                .isCorp(request.isCorp())
                .build();

        return registerMembershipUseCase.registerMembership(command);
    }
}
