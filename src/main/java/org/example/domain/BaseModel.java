package org.example.domain;

import java.util.Objects;

public class BaseModel<T extends Comparable<T>> {
    protected T id;

    public BaseModel(){}

    public BaseModel(T id){
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj ||
                (obj != null && getClass() == obj.getClass() && Objects.equals(id, ((BaseModel<?>) obj).id));
    }
}
