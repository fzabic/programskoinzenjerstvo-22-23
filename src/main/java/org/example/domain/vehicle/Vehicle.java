package org.example.domain.vehicle;

import org.example.domain.BaseModel;
import org.example.domain.fuel.Fuel;
import org.example.domain.fuel.IRefillable;
import org.example.domain.vehicle.builder.IVehicleBuilder;


public abstract class Vehicle extends BaseModel<Integer> implements ITransferable {

    private final Double charge;
    private final Fuel fuel;
    private Integer parkingSpace;

    public Vehicle(Double charge, Fuel fuel) {
        this(null, charge, fuel);
    }

    public Vehicle(Integer id, Double charge, Fuel fuel) {
        super(id);
        this.charge = charge;
        this.fuel = fuel;
    }

    @Override
    public Double calculateCharging() {
        return charge;
    }

    @Override
    public IRefillable getFuel() {
        return fuel;
    }

    @Override
    public void park(Integer parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    @Override
    public Integer parkingSpaceNumber() {
        return parkingSpace;
    }
}
