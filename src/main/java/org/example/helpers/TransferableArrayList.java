package org.example.helpers;

import java.util.ArrayList;

public class TransferableArrayList<T> extends ArrayList<T> {

    private final Integer limit;

    public TransferableArrayList(Integer limit) {
        this.limit = limit;
    }

    @Override
    public boolean add(T t) {
        return this.size() < limit && super.add(t);
    }
}
