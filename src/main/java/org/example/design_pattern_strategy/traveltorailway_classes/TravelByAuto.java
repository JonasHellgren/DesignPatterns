package org.example.design_pattern_strategy.traveltorailway_classes;

public class TravelByAuto implements TravelStrategy
{
    @Override
    public String howToTravel()   {
        return "Auto";
    }

    @Override
    public Double speedOfTravelMeterPerSec() {
        return 20d;
    }


}