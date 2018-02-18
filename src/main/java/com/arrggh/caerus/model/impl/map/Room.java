package com.arrggh.caerus.model.impl.map;

import com.arrggh.caerus.model.impl.Entity;
import com.arrggh.caerus.model.map.IRoom;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

public final class Room extends Entity implements IRoom {
    @JsonProperty
    private final String name;
    @JsonProperty
    private final Map<String, Long> paths;

    @JsonCreator
    public Room(@JsonProperty("id") long id, @JsonProperty("name") String name, @JsonProperty("paths") Map<String, Long> paths) {
        super(id);
        this.name = name;
        this.paths = paths;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Map<String, Long> getPaths() {
        return paths;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Room room = (Room) o;
        return Objects.equals(id, room.id) &&
                Objects.equals(name, room.name) &&
                Objects.equals(paths, room.paths);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, paths);
    }
}
