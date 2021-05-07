package org.example.design_pattern_strategy.travel_tests;

import org.example.design_pattern_strategy.Travel;
import org.example.design_pattern_strategy.traveltorailway_classes.TravelByAuto;
import org.example.design_pattern_strategy.traveltorailway_classes.TravelByFeet;
import org.example.design_pattern_strategy.traveltorailway_classes.TravelStrategy;
import org.junit.Assert;
import org.junit.Test;

public class TravelTests {

    Travel travel=new Travel();


    @Test
    public void ByDefault() {
        TravelStrategy travelStrategy=travel.getTravelStrategy();
        System.out.println(travelStrategy.howToTravel());
        Assert.assertEquals("Auto",travelStrategy.howToTravel());
    }

    @Test
    public void ByAuto() {

        travel.setTravelStrategy(new TravelByAuto());
        TravelStrategy travelStrategy=travel.getTravelStrategy();
        System.out.println(travelStrategy.howToTravel());
        Assert.assertEquals("Auto",travelStrategy.howToTravel());
        Assert.assertEquals(20,travelStrategy.speedOfTravelMeterPerSec(),0.1);
    }

    @Test
    public void ByFeet() {
        travel.setTravelStrategy(new TravelByFeet());
        TravelStrategy travelStrategy=travel.getTravelStrategy();
        System.out.println(travelStrategy.howToTravel());
        Assert.assertEquals("Feet",travelStrategy.howToTravel());
        Assert.assertEquals(1,travelStrategy.speedOfTravelMeterPerSec(),0.1);
    }

    @Test
    public void TimeForAutoSmallerTimeForFeet() {
        Travel travelAuto=new Travel(new TravelByAuto());
        Travel travelFeet=new Travel(new TravelByFeet());
        double distance=1000;

        Assert.assertTrue(travelAuto.timeToTravel(distance)<
                travelFeet.timeToTravel(distance));
    }

}
