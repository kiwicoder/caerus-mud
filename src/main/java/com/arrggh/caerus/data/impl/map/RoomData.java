package com.arrggh.caerus.data.impl.map;

import com.arrggh.caerus.data.impl.AbstractData;
import com.arrggh.caerus.data.impl.DataException;
import com.arrggh.caerus.data.map.IRoomData;
import com.arrggh.caerus.model.impl.map.Room;
import com.arrggh.caerus.model.map.IRoom;

import java.io.File;
import java.io.IOException;

public class RoomData extends AbstractData<IRoom, Room> implements IRoomData {
    @Override
    protected Class<Room> getDataClass() {
        return Room.class;
    }

    public interface IConfiguration {
        File getDataDirectory();
    }

    public RoomData(IConfiguration configuration) {
        super(new File(configuration.getDataDirectory(), "rooms"));
    }

    @Override
    public IRoom read(long id) {
        try {
            return readFile(id);
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
