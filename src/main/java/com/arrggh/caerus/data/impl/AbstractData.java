package com.arrggh.caerus.data.impl;

import com.arrggh.caerus.model.IEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public abstract class AbstractData<INTERFACE extends IEntity, DATA extends INTERFACE> {
    private final ObjectMapper mapper = new ObjectMapper();
    private final File directory;

    protected abstract Class<DATA> getDataClass();

    protected AbstractData(File directory) {
        this.directory = directory;
    }

    protected DATA readFile(long id) throws IOException {
        File input = new File(directory, String.format("%d.json", id));
        return mapper.readValue(input, getDataClass());
    }

    protected void writeFile(INTERFACE data) throws IOException {
        File output = new File(directory, String.format("%d.json", data.getId()));
        mapper.writeValue(output, data);
    }
}
