package com.arrggh.caerus.data.impl;

import com.arrggh.caerus.data.IRoomData;
import com.arrggh.caerus.model.IRoom;
import com.arrggh.caerus.model.impl.Room;

import java.io.File;
import java.io.IOException;

public class RoomData extends AbstractData<IRoom> implements IRoomData {
    @Override
    protected Class getDataClass() {
        return Room.class;
    }

    public interface IConfiguration {
        File getDataDirectory();
    }

    public RoomData(IConfiguration configuration) {
        super(new File(configuration.getDataDirectory(), "rooms"));
    }

    @Override
    public IRoom read(IRoom.Id id) {
        try {
            return readFile(id.toString());
        } catch (IOException e) {
            throw new DataException("Cannot read room: " + id, e);
        }
    }

    @Override
    public void write(IRoom room) {
        try {
            writeFile(room);
        } catch (IOException e) {
            throw new DataException("Cannot write room: " + room, e);
        }
    }
}
