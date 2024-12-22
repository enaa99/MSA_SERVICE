package com.membership.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Membership {
    private final String membershipId;
    private final String name;
    private final String email;
    private final String address;
    private final boolean isValid;
    private final boolean isCorp;

    public static Membership generateMembership(
        MembershipId membershipId,
        MembershipName membershipName,
        MembershipEmail membershipEmail,
        MembershipAddress membershipAddress,
        MembershipIsValid membershipIsValid,
        MembershipIsCorp membershipIsCorp
    ){

        return new Membership(
                membershipId.valuId,
                membershipName.valueName,
                membershipEmail.valueEmail,
                membershipAddress.valueAddress,
                membershipIsValid.valueValid,
                membershipIsCorp.valueIsCorp
        );}


    @Value
    public static class MembershipId {
        String valuId;
        public MembershipId(String value) {
            this.valuId = value;
        }
    }
    @Value
    public static class MembershipName {
        String valueName;
        public MembershipName(String value) {
            this.valueName = value;
        }
    }
    @Value
    public static class MembershipEmail {
        String valueEmail;
        public MembershipEmail(String value) {
            this.valueEmail = value;
        }
    }
    @Value
    public static class MembershipAddress {
        String valueAddress;
        public MembershipAddress(String value) {
            this.valueAddress = value;
        }
    }

    @Value
    public static class MembershipIsValid {
        boolean valueValid;
        public MembershipIsValid(boolean value) {
            this.valueValid = value;
        }
    }

    @Value
    public static class MembershipIsCorp {
        boolean valueIsCorp;
        public MembershipIsCorp(boolean value) {
            this.valueIsCorp = value;
        }
    }
}
