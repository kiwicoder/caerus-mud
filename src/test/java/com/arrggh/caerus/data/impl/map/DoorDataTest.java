package com.arrggh.caerus.data.impl.map;

import com.arrggh.caerus.data.impl.AbstractDataTest;
import com.arrggh.caerus.data.impl.DataException;
import com.arrggh.caerus.model.impl.map.Door;
import com.arrggh.caerus.model.map.IDoor;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class DoorDataTest extends AbstractDataTest {
    private static final String EXAMPLE_DOOR = "{\"id\":0,\"pathId\":0}";
    private static final long DOOR_ID = 0;
    private static final long PATH_ID = 0;

    private final DoorData.IConfiguration configuration = () -> folder.getRoot();
    private DoorData data;

    @Before
    public void setUp() throws IOException {
        folder.newFolder("doors");
        File file = folder.newFile("doors/0.json");
        FileWriter writer = new FileWriter(file);
        IOUtils.write(EXAMPLE_DOOR, writer);
        writer.close();
        data = new DoorData(configuration);
    }

    @Test
    public void testReadFileThatExists() {
        data.read(DOOR_ID);
    }

    @Test(expected = DataException.class)
    public void testReadFileThatDoesNotExists() {
        IDoor value = data.read(9999);
        assertEquals(DOOR_ID, value.getId());
        assertEquals(PATH_ID, value.getPathId());
    }

    @Test
    public void testWriteFile() {
        data.write(new Door(DOOR_ID, PATH_ID));
    }

    @Test(expected = DataException.class)
    public void testCannotWriteFile() {
        DoorData data2 = new DoorData(new DoorData.IConfiguration() {
            @Override
            public File getDataDirectory() {
                return new File("/zzzzzzzzzzzzzzzzzzzzzzz");
            }
        });
        data2.write(new Door(DOOR_ID, PATH_ID));
    }
}