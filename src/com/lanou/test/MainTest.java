package com.lanou.test;

import com.lanou.service.PersonServiceImp;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dllo on 17/10/24.
 */
public class MainTest {

    private ApplicationContext context;

    @Before
    public void init(){
        //启动Spring容器
        context = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    /**
     * 测试Resource注解
     */
    @Test
    public void test(){
        PersonServiceImp personServiceImp = (PersonServiceImp) context.getBean("personService");
        System.out.println(personServiceImp.login("三儿", "123"));
    }
}
