package com.arrggh.caerus.model.map;

import com.arrggh.caerus.model.IEntity;

import java.util.Map;

public interface IRoom extends IEntity {
    String getName();

    Map<String, Long> getPaths();
}
