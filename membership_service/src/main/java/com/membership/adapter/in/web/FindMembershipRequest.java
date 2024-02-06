package com.membership.adapter.in.web;

import lombok.*;
import org.springframework.stereotype.Service;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class FindMembershipRequest {
    private String membershipId;
}
