package org.example.domain.train;

import org.example.domain.BaseModel;
import org.example.domain.vehicle.ITransferable;
import org.example.helpers.TransferableArrayList;

import java.util.List;

public abstract class Train extends BaseModel<Integer> implements ITransporter {

    protected final Integer limit;
    protected final List<ITransferable> transferables;

    public Train(Integer limit) {
        this(null, limit);
    }

    public Train(Integer id, Integer limit) {
        super(id);
        this.limit = limit;
        this.transferables = new TransferableArrayList<>(limit);
    }

    @Override
    public Integer getLimit() {
        return limit;
    }

    @Override
    public double getProfit() {
        return transferables.stream().mapToDouble(ITransferable::calculateCharging).sum();
    }

    @Override
    public List<ITransferable> getTransferables() {
        return transferables;
    }

    @Override
    public abstract Boolean addTransferable(ITransferable transferable);

    @Override
    public Boolean removeTransferable(ITransferable transferable) {
        return transferables.remove(transferable);
    }
}
