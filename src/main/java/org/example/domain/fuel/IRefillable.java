package org.example.domain.fuel;

public interface IRefillable {
    Boolean needsRefill();
    void refill();
    Double getCurrent_percentage();
}
