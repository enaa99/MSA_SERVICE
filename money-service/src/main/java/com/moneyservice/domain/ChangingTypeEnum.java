package com.moneyservice.domain;

public enum ChangingTypeEnum{
    INCREASING,
    DECREASING;

    public static ChangingTypeEnum getEnumValue(int value) {
    switch (value){
        case 0 -> {
            return INCREASING;
        }
        case 1 -> {
            return DECREASING;
        }
        default -> {
            return null;
        }
    }
    }
    public static int getIntValue(ChangingTypeEnum value) {
        switch (value){
            case INCREASING -> {
                return 0;
            }
            case DECREASING -> {
                return 1;
            }
            default -> {
                return -1;
            }
        }
    }
}


