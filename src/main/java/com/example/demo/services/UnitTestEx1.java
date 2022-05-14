package com.example.demo.services;

public class UnitTestEx1 {

    /*
    //Exercise 1:
    5-12 return "morning"
    12-16 return "afternoon"
    16-22 return "evening"
    22-5 return "night"
     */
    public String intervalOfTheDay (int time){
        String dayResult ="";
        if (time >= 5 && time < 12){
            dayResult = "Morning";
        }
        else if (time >= 12 && time < 16){
            dayResult = "Afternoon";
        }
        else if (time >= 16 && time < 22){
            dayResult = "Evening";
        }
        else { //time >= 22 && time < 5
            dayResult = "Night";
        }
        return dayResult;
    }

}
