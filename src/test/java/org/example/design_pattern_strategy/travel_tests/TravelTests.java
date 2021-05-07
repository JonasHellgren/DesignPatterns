package org.example.design_pattern_strategy.travel_tests;

import org.example.design_pattern_strategy.traveltorailway_classes.Travel;
import org.example.design_pattern_strategy.traveltorailway_classes.TravelByAuto;
import org.example.design_pattern_strategy.traveltorailway_classes.TravelByBus;
import org.example.design_pattern_strategy.traveltorailway_classes.TravelStrategy;
import org.junit.Assert;
import org.junit.Test;

public class TravelTests {

    Travel travel=new Travel();
    @Test
    public void ByAuto() {
        travel.setTravelStrategy(new TravelByAuto());
        TravelStrategy travelStrategy=travel.getTravelStrategy();
        System.out.println(travelStrategy.howToTravel());
        Assert.assertEquals("Auto",travelStrategy.howToTravel());
    }

    @Test
    public void ByBus() {
        travel.setTravelStrategy(new TravelByBus());
        TravelStrategy travelStrategy=travel.getTravelStrategy();
        System.out.println(travelStrategy.howToTravel());
        Assert.assertEquals("Bus",travelStrategy.howToTravel());
    }
}
