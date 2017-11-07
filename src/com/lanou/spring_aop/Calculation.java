package com.lanou.spring_aop;

import org.springframework.stereotype.Component;

/**
 * Created by dllo on 17/10/24.
 * 目标对象
 */
@Component
public class Calculation {

    /**
     * 连接点 joinPoint (add)
     * @param a
     * @param b
     * @return
     */
    public int add(int a,int b){
        return a + b;
    }

    /**
     * 连接点 joinPoint (sub)
     * @param a
     * @param b
     * @return
     */
    public int sub(int a,int b){
        return a - b;
    }

}
