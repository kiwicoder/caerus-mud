package com.arrggh.caerus.data.impl.map;

import com.arrggh.caerus.data.impl.AbstractData;
import com.arrggh.caerus.data.impl.DataException;
import com.arrggh.caerus.data.map.IPathData;
import com.arrggh.caerus.model.impl.map.Path;
import com.arrggh.caerus.model.map.IPath;

import java.io.File;
import java.io.IOException;

public class PathData extends AbstractData<IPath, Path> implements IPathData {
    @Override
    protected Class<Path> getDataClass() {
        return Path.class;
    }

    public interface IConfiguration {
        File getDataDirectory();
    }

    public PathData(IConfiguration configuration) {
        super(new File(configuration.getDataDirectory(), "paths"));
    }

    @Override
    public IPath read(long id) {
        try {
            return readFile(id);
        } catch (IOException e) {
            throw new DataException("Cannot read Path: " + id, e);
        }
    }

    @Override
    public void write(IPath path) {
        try {
            writeFile(path);
        } catch (IOException e) {
            throw new DataException("Cannot write Path: " + path, e);
        }
    }
}
