package com.xio.study.coll;

import com.xio.common.bean.Person;
import com.xio.common.bean.User;
import org.junit.Test;

import java.util.List;

/**
 * @author: polarbear
 * @Date: 2019/7/9 17:01
 * @Description: Test_Demo
 */
public class collTest {



    @Test
    public void forEachTest(){
        List<User> newPerson = new User().getUserList();
        System.out.println(newPerson.size());
        Person person = new Person();
        person.setPersonList(newPerson);

        // -----------------------
//        List<User> personList = person.getPersonList();
//        Iterator iterator = personList.iterator();
//        while (iterator.hasNext()){
//            User next = (User) iterator.next();
//            System.out.println(next.getUserName() + "--"+next.getAge());
//        }\
        // -----------------------
        for (User user : person.getPersonList()) {
            System.out.println(user.getUserName() + "--"+user.getAge());
        }

    }


}
