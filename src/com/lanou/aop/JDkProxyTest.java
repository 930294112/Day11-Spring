package com.lanou.aop;

import org.junit.Test;

/**
 * Created by dllo on 17/10/24.
 */
public class JDkProxyTest {

    /**
     * 测试JDK动态代理的实现方式
     */
    @Test
    public void testJDKProxy(){
        //1.创建目标业务对象
        Calculation calculation =new Calculation();
        //2.创建要插入的日志的对象
        LoginUtil loginUtil = new LoginUtil();
        //3.创建代理的工具类
        CalculationProxy proxy = new CalculationProxy();
        proxy.setLoginUtil(loginUtil);
        //4.从工具类中获得代理的对象
        ICalculation calculationProxy = (ICalculation) proxy.getProxyObject(calculation);
        //5.通过代理对象调用业务方法
        System.out.println(calculationProxy.add(2, 6));
        System.out.println("****");
        System.out.println(calculationProxy.div(3, 2));
    }

    /**
     * 测试CGlib实现的动态代理
     * @return
     */
    @Test
    public void testCGilbProxy(){
        //创建目标对象
        Calculation target = new Calculation();
        //创建要插入的业务对象
        LoginUtil loginUtil = new LoginUtil();
        //创建代理工具类
        CGlibProxy cGlibProxy = new CGlibProxy();
        cGlibProxy.setLoginUtil(loginUtil);//设置日志对象
        //通过代理工具类获得代理对象
        Calculation calculation = (Calculation) cGlibProxy.getProxyObject(target);
        //调用目标对象的方法
        System.out.println(calculation.add(3, 6));

    }

}
