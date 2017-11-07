package com.lanou.spring_aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by dllo on 17/10/24.]
 * 切面类Aspect
 * Component :相当于:<bean id="loginUtil" class="com.lanou.spring_aop.LoginUtil">
 * Aspect 相当于:<aop :aspect ref="loginUtil">
 */
@Component
@Aspect
public class LoginUtil {
    /**
     * 定义切入点表达式
     * 相当于 <aop :pointcut expression="...">
     */
    @Pointcut("execution(* com.lanou.spring_aop.Calculation.*(..))")
    public void method(){}
    /**
     * 前置通知Advice
     */
    @Before("method()")
    public void startAdvice(JoinPoint joinPoint){
        System.out.println("前置通知:startAdvice");
        //获得当前调用的方法名称
        String method = joinPoint.getSignature().getName();
        System.out.println("方法名:" +method);
        System.out.println( "目标类:" + joinPoint.getTarget().getClass());
    }

    /**
     * 后置通知Advice
     */
    @After("method()")
    public void endAdvice(JoinPoint joinPoint){
        System.out.println("后置通知: endAdvice");
        //获得当前调用的方法名称
        String method = joinPoint.getSignature().getName();
        System.out.println("方法名:" +method);
        System.out.println( "目标类:" + joinPoint.getTarget().getClass());
    }
}
