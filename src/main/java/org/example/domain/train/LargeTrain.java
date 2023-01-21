package org.example.domain.train;

import org.example.domain.vehicle.ITransferable;
import org.example.domain.vehicle.LargeVehicle;

import java.util.List;

public class LargeTrain extends Train{

    public static final Integer LIMIT = 6;

    public LargeTrain() {
        this(null);
    }

    public LargeTrain(Integer id) {
        super(id, LIMIT);
    }

    @Override
    public Boolean addTransferable(ITransferable transferable) {
        if (!LargeVehicle.class.isAssignableFrom(transferable.getClass())) return false;
        transferables.add(transferable);
        return true;
    }
}
