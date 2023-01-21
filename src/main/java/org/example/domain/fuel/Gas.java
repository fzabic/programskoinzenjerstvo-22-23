package org.example.domain.fuel;

public class Gas extends Fuel{

    public Gas(Double current_percentage) {
        this(null, current_percentage);
    }
    public Gas(Integer id, Double current_percentage) {
        super(id, current_percentage);
    }

    @Override
    public Boolean needsRefill() {
        return current_percentage <= MIN_PERCENTAGE;
    }

    @Override
    public void refill() {
        current_percentage = MAX_PERCENTAGE;
    }
}
