package com.moneyservice.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class IncreaseMoneyChangingRequest {
    private String targetMembershipId;
    // 충전
    private int amount;
}
