package org.example.domain.vehicle;

import org.example.domain.fuel.Fuel;

public abstract class SmallVehicle extends Vehicle implements ISizable{

    public SmallVehicle(Double charge, Fuel fuel) {
        this(null, charge, fuel);
    }
    protected SmallVehicle(Integer id, Double charge, Fuel fuel) {
        super(id, charge, fuel);
    }

    @Override
    public String size() {
        return "Size: small vehicle";
    }
}
