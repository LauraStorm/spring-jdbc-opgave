package com.example.demo.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {

    @Test
    void getPriceFromAge() {
        //Arrange
        PriceCalculator calc = new PriceCalculator();
        int expectedInvalidInput = -1;
        int expectedPensionTicket = 10;
        int expectedFreeTravel = 1;
        int expectedYoungTravel = 10;
        int expectedAdultTravel = 20;

        //Act
        int invalidResult = calc.getPriceFromAge(-1);  //test -1 og 0
        int pensionResult = calc.getPriceFromAge(64);  //test 63 og 64
        int freeTravelResult = calc.getPriceFromAge(5); //test 5 og 6
        int youngTravelResult = calc.getPriceFromAge(17); //test 17 og 18 evt 19
        int adultTravelResult = calc.getPriceFromAge(63); //test 63 og 64 og 18

        //Assert
        assertEquals(expectedInvalidInput,invalidResult);
        assertEquals(expectedPensionTicket,pensionResult);
        assertEquals(expectedFreeTravel,freeTravelResult);
        assertEquals(expectedYoungTravel,youngTravelResult);
        assertEquals(expectedAdultTravel,adultTravelResult);
    }

}