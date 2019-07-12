package com.xio.study.annotation.JDK;

import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author: polarbear
 * @Date: 2019/6/25 11:00
 * @Description: Test_Demo
 */


public class annotaionDetail {

    /**
     * 注解，可以看作是对 一个 类/方法 的一个扩展的模版，每个 类/方法 按照注解类中的规则，来为 类/方法 注解不同的参数，在用到的地方可以得到不同的 类/方法 中注解的各种参数与值
     * 注解也就是Annotation,相信不少人也和我之前一样以为和注释和doc一样，是一段辅助性的文字，其实注解不是这样的。
     * 从JDK5开始，java增加了对元数据（描述数据属性的信息）的支持。其实说白就是代码里的特殊标志，这些标志可以在编译，类加载，运行时被读取，并执行相应的处理，以便于其他工具补充信息或者进行部署。
     */
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)//因为是运行时测试，所以需要让注解在运行时保留
    public @interface Country {
        String name();
    }


    /**
     * 中国人
     */
    @Country(name = "China")
    public class Chinese {


    }

    /**
     * 四川人
     */
    public class SiChuanese extends Chinese {


    }

//    public class CountryTest {

        @Test
        public void testCountry() {
            System.out.println(SiChuanese.class.getAnnotation(Country.class).name());
            //测试通过
            Assert.assertEquals("China", SiChuanese.class.getAnnotation(Country.class).name());
        }

//    }


}
