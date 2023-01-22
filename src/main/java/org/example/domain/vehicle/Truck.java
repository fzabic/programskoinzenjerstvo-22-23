package org.example.domain.vehicle;

import org.example.domain.fuel.Fuel;
import org.example.domain.vehicle.builder.IVehicleBuilder;

public class Truck extends LargeVehicle{

    //Insert truck specifications

    public Truck(Double charge, Fuel fuel) {
        this(null, charge, fuel);
    }
    public Truck(Integer id, Double charge, Fuel fuel) {
        super(id, charge, fuel);
    }

    public static final class Builder implements IVehicleBuilder<Builder, Truck> {
        private Integer id;
        private Fuel fuel;
        private final Double CHARGE = 90.00;

        @Override
        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        @Override
        public Builder fuel(Fuel fuel) {
            this.fuel = fuel;
            return this;
        }

        @Override
        public Truck build() {
            return new Truck(id, CHARGE, fuel);
        }
    }
}
