package org.example.domain.fuel;

import org.example.domain.BaseModel;

public abstract class Fuel extends BaseModel<Integer> implements IRefillable {
    protected static final Double MAX_PERCENTAGE = 1.0;
    protected static final Double MIN_PERCENTAGE = 0.1;

    protected Double current_percentage;

    public Fuel(Double current_percentage) {
        this(null, current_percentage);
    }

    public Fuel(Integer id, Double current_percentage) {
        super(id);
        this.current_percentage = current_percentage;
    }

    public void setCurrent_percentage(Double current_percentage) {
        this.current_percentage = current_percentage;
    }

    @Override
    public Double getCurrent_percentage() {
        return current_percentage;
    }
}
