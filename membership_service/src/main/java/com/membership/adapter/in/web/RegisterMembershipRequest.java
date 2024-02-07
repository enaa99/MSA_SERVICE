package com.membership.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class RegisterMembershipRequest {
    private String name;
    private String address;
    private String email;
    private boolean isCorp;
}
