package org.example.domain.train;

import org.example.domain.vehicle.ITransferable;

import java.util.List;

public interface ITransporter extends ILimitable, IProfitable {

    List<ITransferable> getTransferables();
    Boolean addTransferable(ITransferable transferable);
    Boolean removeTransferable(ITransferable transferable);
}
