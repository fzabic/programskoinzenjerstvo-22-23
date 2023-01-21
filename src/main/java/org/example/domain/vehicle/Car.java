package org.example.domain.vehicle;

import org.example.domain.fuel.Fuel;

public class Car extends SmallVehicle{

    //Insert car specifications

    public Car(Double charge, Fuel fuel) {
        this(null, charge, fuel);
    }

    protected Car(Integer id, Double charge, Fuel fuel) {
        super(id, charge, fuel);
    }
}
