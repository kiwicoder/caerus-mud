package com.arrggh.caerus.model.map;

import com.arrggh.caerus.model.IEntity;

public interface IPath extends IEntity {
    long getSourceRoomId();

    long getDestinationRoomId();
}
