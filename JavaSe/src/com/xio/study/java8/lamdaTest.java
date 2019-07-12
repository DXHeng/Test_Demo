package com.xio.study.java8;




import cn.hutool.json.JSONUtil;
import com.xio.common.bean.Person;
import com.xio.common.bean.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author: polarbear
 * @Date: 2019/6/20 16:10
 * @Description: Test_Demo
 */
public class lamdaTest {

    public void checkAndExcute(List<Integer> list, Predicate predicate, Consumer consumer) {
//        list.forEach(p ->
//                {
//                    if (predicate.test(p)) {
//                        consumer.accept(p);
//                    }
//                }
//        );

        Predicate negate = predicate.negate();
        System.out.print(negate);

        /**
         *  default Predicate<T> negate() {
         *         return (t) -> !test(t);
         *     }
         */
        list.stream().filter(predicate.negate()).forEach(System.out::println);

    }

    @Test
    public void negateTest(){


        List<Integer> list = Arrays.asList(1, null, 3, 4, null, 6);

//        Optional<List<Integer>> listOptional = Optional.ofNullable(list);

        checkAndExcute(list, e -> e == null, e -> System.out.print(e));

//        list.stream().filter(e -> e == null).forEach(System.out::println);


//        List<Integer> collect = list.stream().collect(Collectors.toList());

        System.out.println(
                "sum is:"+list
                        .stream()
                        .filter(
                            num -> num != null
                        )
                        .distinct()
                        .mapToInt(num -> num * 2)
                        .peek(System.out::print)
                        .skip(2)
                        .limit(4)
                        .sum()
        );

    }



    @Test
    public void mapTest(){
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax.stream().map((cost) -> cost + 0.12*cost).forEach(System.out::println);
    }



    @Test
    public void CollectTest(){
        List<User> newPerson = new User().getUserList();
        User user = new User();
        user.setAge(17);
        user.setUserName("xiong");
        newPerson.add(user);
        Map<Integer, List<User>> collect = newPerson.stream().collect(Collectors.groupingBy(User::getAge));
        System.out.println(JSONUtil.formatJsonStr(JSONUtil.toJsonStr(collect)));
    }


}
