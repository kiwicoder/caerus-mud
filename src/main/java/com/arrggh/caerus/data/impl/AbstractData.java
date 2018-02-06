package com.arrggh.caerus.data.impl;

import com.arrggh.caerus.model.IEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public abstract class AbstractData<T extends IEntity<?>> {
    private final ObjectMapper mapper = new ObjectMapper();
    private final File directory;

    abstract Class<T> getDataClass();

    protected AbstractData(File directory) {
        this.directory = directory;
    }

    protected T readFile(String id) throws IOException {
        File input = new File(directory, id + ".json");
        return mapper.readValue(input, getDataClass());
    }

    protected void writeFile(T data) throws IOException {
        File output = new File(directory, data.getId() + ".json");
        mapper.writeValue(output, data);
    }
}
