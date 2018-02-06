package com.arrggh.caerus.data;

import com.arrggh.caerus.model.IRoom;

public interface IRoomData {
    IRoom read(IRoom.Id id);

    void write(IRoom room);
}
