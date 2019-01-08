package com.example.entity;

/**
 * @Author Barry
 * @date 2019/1/8
 */
public enum SexEnum {
    MALE ( 1, "男"),

    FEMALE ( 2, "女");

    private String name;
    private int id;

    SexEnum(int id, String name){
        this.id = id;
        this.name = name;
    }

    public static SexEnum getSeEnumById(int id){
        for(SexEnum sex :SexEnum.values() ){
            if( sex.getId() == id) {
                return sex;
            }
        }
        return  null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
