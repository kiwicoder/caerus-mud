package com.arrggh.caerus.data.map;

import com.arrggh.caerus.model.map.IRoom;

public interface IRoomData {
    IRoom read(long id);

    void write(IRoom room);
}
