package com.xio.common.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: polarbear
 * @Date: 2019/7/9 16:59
 * @Description: Test_Demo
 */


public class User {

    private String userName;
    private Integer age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public List<User> getUserList(){
        List<User> newPerson = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setAge(i+10);
            user.setUserName("xio"+i);
            newPerson.add(user);
        }
        return newPerson;
    }



}
