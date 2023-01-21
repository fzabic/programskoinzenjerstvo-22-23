package org.example.domain.train;

import org.example.domain.vehicle.ITransferable;
import org.example.domain.vehicle.SmallVehicle;

public class SmallTrain extends Train{
    public static final Integer LIMIT = 6;

    public SmallTrain() {
        this(null);
    }

    public SmallTrain(Integer id) {
        super(id, LIMIT);
    }

    @Override
    public Boolean addTransferable(ITransferable transferable) {
        if (!SmallVehicle.class.isAssignableFrom(transferable.getClass())) return false;
        transferables.add(transferable);
        return true;
    }
}
