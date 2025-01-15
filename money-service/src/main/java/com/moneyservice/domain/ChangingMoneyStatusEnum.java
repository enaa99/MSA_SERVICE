package com.moneyservice.domain;

public enum ChangingMoneyStatusEnum {
    REQUESTED,
    SUCCEEDED,
    FAILED,
    CANCELLED;

    public static ChangingMoneyStatusEnum getEnumValue(int value){
        switch (value){
            case 0 ->{
                return REQUESTED;
            }
            case 1 ->{
                return SUCCEEDED;
            }
            case 2 ->{
                return FAILED;
            }
            case 3 ->{
                return CANCELLED;
            }
            default -> {
                return null;
            }
        }
    }
    public static int getIntValue(ChangingMoneyStatusEnum value){
        switch (value){
            case REQUESTED -> {
                return 0;
            }
            case SUCCEEDED -> {
                return 1;
            }
            case FAILED -> {
                return 2;
            }
            case CANCELLED -> {
                return 3;
            }
        }
        return 2;
    }
}
