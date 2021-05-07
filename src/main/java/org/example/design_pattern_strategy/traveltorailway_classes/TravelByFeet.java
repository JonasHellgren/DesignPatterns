package org.example.design_pattern_strategy.traveltorailway_classes;

public class TravelByFeet implements TravelStrategy
{
    @Override
    public String howToTravel()    {
        return "Feet";
    }

    @Override
    public Double speedOfTravelMeterPerSec() {
        return 1d;
    }

}