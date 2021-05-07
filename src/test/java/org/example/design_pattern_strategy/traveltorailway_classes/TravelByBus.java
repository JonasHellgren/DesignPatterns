package org.example.design_pattern_strategy.traveltorailway_classes;

public class TravelByBus implements TravelStrategy
{
    @Override
    public String howToTravel()    {
        return "Bus";
    }

}