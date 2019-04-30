package com.wyf.user.constant;

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
    CUSTOMER(1, "客户"),
    /**
     * 商家
     */
    MERCHANT(2,"商家"),
    /**
     * 系统后台服务者
     */
    SYSTEMSERVICE(0,"系统后台服务者");

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
            case 0:
                return SYSTEMSERVICE;
            default:
                return null;
        }
    }

}
