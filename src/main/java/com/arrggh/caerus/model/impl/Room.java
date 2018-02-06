package com.arrggh.caerus.model.impl;

import com.arrggh.caerus.model.IRoom;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public final class Room implements IRoom {
    @JsonProperty
    private final Room.Id id;
    @JsonProperty
    private final String name;

    @JsonCreator
    public Room(@JsonProperty("id") Room.Id id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public IRoom.Id getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Room[id='%s', name='%s']", id, name);
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

    public static class Id implements IRoom.Id {
        @JsonProperty
        private final long id;

        @JsonCreator
        public Id(@JsonProperty("id") long id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return String.format("%d", id);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Id id1 = (Id) o;
            return id == id1.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}
