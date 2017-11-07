package com.lanou.spring_aop;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dllo on 17/10/24.
 */
public class AopAnnotation {

    private ApplicationContext context;

    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("spring-aop-annotation.xml");
    }

    @Test
    public void test(){
       Calculation calculation = context.getBean(Calculation.class);
        int result = calculation.add(3, 5);
        System.out.println(result);
    }
}
