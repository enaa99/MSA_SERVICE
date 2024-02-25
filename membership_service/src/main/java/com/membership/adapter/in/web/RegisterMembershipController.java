package com.membership.adapter.in.web;

import com.membership.application.port.in.RegisterMembershipCommand;
import com.membership.application.port.in.RegisterMembershipUseCase;
import com.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import msa.hexagonal.common.common.WebAdapter;
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

        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isValid(true)
                .isCorp(request.isCorp())
                .build();

        return registerMembershipUseCase.registerMembership(command);
    }
}
