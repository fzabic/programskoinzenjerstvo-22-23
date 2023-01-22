package org.example.domain.worker;

import org.example.domain.BaseModel;
import org.example.domain.train.Train;
import org.example.domain.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Worker extends BaseModel<Integer> implements IValet, IFuelWorker{

    private final List<Vehicle> vehicles = new ArrayList<>();
    private Double salary;

    public Worker(Double salary) {
        this(null, salary);
    }

    public Worker(Integer id, Double salary) {
        super(id);
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double earned(){
        return vehicles.stream().mapToDouble(v -> v.calculateCharging() * salary).sum();
    }

    @Override
    public void fillUpVehicle(Vehicle vehicle) {
        if (vehicle.getFuel().needsRefill()) vehicle.getFuel().refill();
    }

    @Override
    public Boolean parkVehicle(Vehicle vehicle, Train train) {
        fillUpVehicle(vehicle);
        return train.addTransferable(vehicle) && vehicles.add(vehicle);
    }
}
