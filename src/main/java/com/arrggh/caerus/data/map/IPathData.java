package com.arrggh.caerus.data.map;

import com.arrggh.caerus.model.map.IPath;

public interface IPathData {
    IPath read(long id);

    void write(IPath Path);
}
