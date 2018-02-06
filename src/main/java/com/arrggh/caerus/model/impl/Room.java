package com.arrggh.caerus.model.impl;

import com.arrggh.caerus.model.IRoom;

import java.util.Objects;

public final class Room implements IRoom {
    private final IRoom.Id id;
    private final String name;

    public Room(IRoom.Id id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Room[id='%s', name='%s'", id, name);
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
                Objects.equals(name, room.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public interface Id extends IRoom.Id {

    }
}
