package com.merchant.user.constant;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/29
 */
public enum UserEnum {

    /**
     * 客户
     */
    CUSTOMER(100, "客户"),
    /**
     * 商家
     */
    MERCHANT(200,"商家");


    private final int value;
    private final String name;

    UserEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getValue(){
        return this.value;
    }

    public static UserEnum valueOf(final int value){
        switch (value){

            case 1:
                return CUSTOMER;
            case 2:
                return MERCHANT;
            default:
                return null;
        }
    }

}
