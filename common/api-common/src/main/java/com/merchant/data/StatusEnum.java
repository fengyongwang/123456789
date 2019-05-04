package com.merchant.data;

public enum StatusEnum {

    /**
     * 有效
     */
    EFFECTIVE(1, "有效"),
    /**
     * 无效
     */
    INVALID(0,"无效");


    private final int value;
    private final String name;

    StatusEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getValue(){
        return this.value;
    }

    public static StatusEnum valueOf(final int value){
        switch (value){

            case 1:
                return EFFECTIVE;
            case 0:
                return INVALID;
            default:
                return null;
        }
    }

}
