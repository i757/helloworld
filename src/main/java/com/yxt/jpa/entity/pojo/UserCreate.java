package com.yxt.jpa.entity.pojo;

import com.yxt.util.KeyConstants;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public class UserCreate {

    @NotBlank(message = KeyConstants.USER_NAME_NOT_NULL)
    @Size(min = 0,max = 50,message = KeyConstants.USER_NAME_TOO_LANG)
    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
