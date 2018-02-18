package com.arrggh.caerus.model.impl.map;

import com.arrggh.caerus.model.impl.Entity;
import com.arrggh.caerus.model.map.IPath;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public final class Path extends Entity implements IPath {
    @JsonProperty
    private final long srcRoomId;
    @JsonProperty
    private final long dstRoomId;

    @JsonCreator
    public Path(@JsonProperty("id") long id, @JsonProperty("srcRoomId") long srcRoomId, @JsonProperty("dstRoomId") long dstRoomId) {
        super(id);
        this.srcRoomId = srcRoomId;
        this.dstRoomId = dstRoomId;
    }

    @Override
    @JsonProperty("srcRoomId")
    public long getSourceRoomId() {
        return srcRoomId;
    }

    @Override
    @JsonProperty("dstRoomId")
    public long getDestinationRoomId() {
        return dstRoomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Path path = (Path) o;
        return Objects.equals(id, path.id) && Objects.equals(srcRoomId, path.srcRoomId) && Objects.equals(dstRoomId, path.dstRoomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, srcRoomId, dstRoomId);
    }
}
