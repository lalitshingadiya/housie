package com.game.housie.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Car {

    Maruti maruti;

    Hyundai hyundai;

    //Constructor based no need to write autowired -- immutable single ton default
    public Car(Maruti maruti){
        this.maruti=maruti;
    }

    //Setter based need to write autowired -- Optional based singleton default
    @Autowired
    public void sethundai(Hyundai hyundai){
        this.hyundai=hyundai;
    }

    //Property based depedency injection -- using reflection API
    @Autowired
    Skoda skoda;

}
