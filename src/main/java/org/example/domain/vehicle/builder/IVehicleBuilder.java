package org.example.domain.vehicle.builder;

import org.example.domain.fuel.Fuel;

public interface IVehicleBuilder<V, T> {
    V id(Integer id);

    V fuel(Fuel fuel);

    T build();

}
