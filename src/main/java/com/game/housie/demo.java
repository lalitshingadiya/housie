package com.game.housie;

import java.util.function.BiFunction;
import java.util.function.Consumer;

@FunctionalInterface
 interface  calculate{

    int doCalculate(int a,int b,int c,int d);

}

public class demo {

    public static void main(String[] args) {
        String test = "test";
        demo d = new demo();
        calculate c = d::abcd;
        c.doCalculate(10,20,30,40);
    }

    public int abcd(int a,int b,int c,int d){
        return a+b+c+d;
    }

}
