package com.arrggh.caerus.data.impl.map;

import com.arrggh.caerus.data.impl.AbstractDataTest;
import com.arrggh.caerus.data.impl.DataException;
import com.arrggh.caerus.model.impl.map.Path;
import com.arrggh.caerus.model.map.IPath;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class PathDataTest extends AbstractDataTest {
    private static final String EXAMPLE_PATH = "{\"id\":0,\"srcRoomId\":1,\"dstRoomId\":2}";
    private static final long PATH_ID = 0;

    private static final long SRC_ROOM_ID = 1;
    private static final long DST_ROOM_ID = 2;

    private final PathData.IConfiguration configuration = () -> folder.getRoot();
    private PathData data;

    @Before
    public void setUp() throws IOException {
        folder.newFolder("paths");
        File file = folder.newFile("paths/0.json");
        FileWriter writer = new FileWriter(file);
        IOUtils.write(EXAMPLE_PATH, writer);
        writer.close();
        data = new PathData(configuration);
    }

    @Test
    public void testReadFileThatExists() {
        IPath path = data.read(PATH_ID);
        assertEquals(PATH_ID, path.getId());
        assertEquals(SRC_ROOM_ID, path.getSourceRoomId());
        assertEquals(DST_ROOM_ID, path.getDestinationRoomId());
    }

    @Test(expected = DataException.class)
    public void testReadFileThatDoesNotExists() {
        data.read(9999);
    }

    @Test
    public void testWriteFile() {
        data.write(new Path(PATH_ID, SRC_ROOM_ID, DST_ROOM_ID));
    }

    @Test(expected = DataException.class)
    public void testCannotWriteFile() {
        PathData data2 = new PathData(new PathData.IConfiguration() {
            @Override
            public File getDataDirectory() {
                return new File("/zzzzzzzzzzzzzzzzzzzzzzz");
            }
        });
        data2.write(new Path(PATH_ID, SRC_ROOM_ID, DST_ROOM_ID));
    }
}