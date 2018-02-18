package com.arrggh.caerus.data.map;

import com.arrggh.caerus.model.map.IDoor;

public interface IDoorData {
    IDoor read(long id);

    void write(IDoor Door);
}
