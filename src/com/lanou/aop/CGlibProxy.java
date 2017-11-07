package com.lanou.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by dllo on 17/10/24.
 */
public class CGlibProxy implements MethodInterceptor {
    private Object target; //目标对象
    private LoginUtil loginUtil;//要插入的日志对象

    /**
     * 获得目标对象生成的代理对象
     * @param object  目标对象
     * @return
     */
    public Object getProxyObject(Object object){
        target = object;//重新赋值目标对象
        //1构建增强类对象
        Enhancer enhancer = new Enhancer();
        //2设置回调接口,即设置方法拦截器
        enhancer.setCallback(this);
        //3.设置父类class
        enhancer.setSuperclass(target.getClass());

        return enhancer.create();//创建代理类并返回

    }
    /**
     * 拦截目标对象的方法拦截
     * @param o 被代理后的对象
     * @param method  目标对象中的执行方法
     * @param objects 方法中的参数列表
     * @param methodProxy  代理方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        loginUtil.startMethod();
        Object result = method.invoke(target,objects);
        loginUtil.endMethod();

        return result;//返回方法执行的结果
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
