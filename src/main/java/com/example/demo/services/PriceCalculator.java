package com.example.demo.services;

public class PriceCalculator {

    public int getPriceFromAge(int age){
        if(age >= 0 && age < 6){
            return 1;
        }
        if (age >= 6 && age < 18 ){
            return 10;
        }
        if (age >= 18 && age <64){
            return 20;
        }
        if(age < 0){
            return -1;
        }

        if(age >= 64){
            return 10;
        }

        return 80;
    }
}
