package org.example.domain.vehicle;

import org.example.domain.fuel.Fuel;

public abstract class LargeVehicle extends Vehicle implements ISizable{

    public LargeVehicle(Double charge, Fuel fuel) {
        this(null,charge, fuel);
    }

    public LargeVehicle(Integer id, Double charge, Fuel fuel) {
        super(id, charge, fuel);
    }

    @Override
    public String size() {
        return "Size: large vehicle";
    }
}
