package com.arrggh.caerus.model.impl.map;

import com.arrggh.caerus.model.impl.Entity;
import com.arrggh.caerus.model.map.IDoor;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public final class Door extends Entity implements IDoor {
    @JsonProperty
    private final long pathId;

    @JsonCreator
    public Door(@JsonProperty("id") long id, @JsonProperty("pathId") long pathId) {
        super(id);
        this.pathId = pathId;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public long getPathId() {
        return pathId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Door door = (Door) o;
        return Objects.equals(id, door.id) && Objects.equals(pathId, door.pathId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pathId);
    }
}
