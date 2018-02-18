package com.arrggh.caerus.data.impl.map;

import com.arrggh.caerus.data.impl.AbstractData;
import com.arrggh.caerus.data.impl.DataException;
import com.arrggh.caerus.data.map.IDoorData;
import com.arrggh.caerus.model.impl.map.Door;
import com.arrggh.caerus.model.map.IDoor;

import java.io.File;
import java.io.IOException;

public class DoorData extends AbstractData<IDoor, Door> implements IDoorData {
    @Override
    protected Class<Door> getDataClass() {
        return Door.class;
    }

    public interface IConfiguration {
        File getDataDirectory();
    }

    public DoorData(IConfiguration configuration) {
        super(new File(configuration.getDataDirectory(), "doors"));
    }

    @Override
    public IDoor read(long id) {
        try {
            return readFile(id);
        } catch (IOException e) {
            throw new DataException("Cannot read Door: " + id, e);
        }
    }

    @Override
    public void write(IDoor door) {
        try {
            writeFile(door);
        } catch (IOException e) {
            throw new DataException("Cannot write Door: " + door, e);
        }
    }
}
