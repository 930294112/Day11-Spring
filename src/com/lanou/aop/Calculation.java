package com.lanou.aop;

/**
 * Created by dllo on 17/10/24.
 */
public class Calculation implements ICalculation{
    public int add(int a,int b){
        System.out.println("add");
        return a + b;
    }

    public int sub(int a,int b){
        return a - b;
    }

    public int mul(int a,int b){
        return a * b;
    }

    public int div(int a,int b){
        System.out.println("div");
        return a / b;
    }
}
