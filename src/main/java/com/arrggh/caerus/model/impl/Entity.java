package com.arrggh.caerus.model.impl;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Entity {
    @JsonProperty
    protected final long id;

    protected Entity(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
