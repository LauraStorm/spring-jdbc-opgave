package com.example.demo.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTestExTest1 {

    @Test
    void intervalOfTheDay() {
        //Arrange
        UnitTestEx1 unitTestEx = new UnitTestEx1();
        String expectedMorning = "Morning";
        String expectedAfternoon ="Afternoon";
        String expectedEvening = "Evening";
        String expectedNight = "Night";

        //Act
        String morningResult = unitTestEx.intervalOfTheDay(5); //test 4 og 5  + 11 & 12
        String afternoonResult = unitTestEx.intervalOfTheDay(12); // 11 & 12
        String eveningResult = unitTestEx.intervalOfTheDay(16); //15 + 16
        String nightResult = unitTestEx.intervalOfTheDay(22); //21 & 22

        //Assert
        assertEquals(expectedMorning,morningResult);
        assertEquals(expectedAfternoon,afternoonResult);
        assertEquals(expectedEvening,eveningResult);
        assertEquals(expectedNight,nightResult);

    }
}