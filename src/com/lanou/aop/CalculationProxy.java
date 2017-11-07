package com.lanou.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by dllo on 17/10/24.
 */
public class CalculationProxy implements InvocationHandler {

    private Object target;//目标对象
    private LoginUtil loginUtil;//日志业务对象


    /**
     * 拦截被JDK动态的代理对象中的所有方法调用
     * @param proxy :被代理后的对象
     * @param method:执行的方法(反射)
     * @param args 执行的方法所需要的参数列表
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //前置日志加入
        loginUtil.startMethod();

        //调用目标对象中的方法
       Object result = method.invoke(target,args);

        //后置日志加入
        loginUtil.endMethod();

        return result;//返回执行的结果
    }
    /*
    获得目标对象的代理对象
     */

    public Object getProxyObject(Object object){
        target = object;//重新指定目标对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), //获得目标对象的classLoad
                                        target.getClass().getInterfaces(),//获得目标对象的接口集合
                                         this);//指定目标对象的拦截器
    }


    public CalculationProxy() {
    }

    public CalculationProxy(Object target, LoginUtil loginUtil) {
        this.target = target;
        this.loginUtil = loginUtil;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public LoginUtil getLoginUtil() {
        return loginUtil;
    }

    public void setLoginUtil(LoginUtil loginUtil) {
        this.loginUtil = loginUtil;
    }
}
