package com.arrggh.caerus.data.impl.map;

import com.arrggh.caerus.data.impl.AbstractDataTest;
import com.arrggh.caerus.data.impl.DataException;
import com.arrggh.caerus.model.impl.map.Room;
import com.arrggh.caerus.model.map.IRoom;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RoomDataTest extends AbstractDataTest {
    private static final String EXAMPLE_ROOM = "{\"id\":0,\"name\":\"Test Room\",\"paths\":{\"south\":1,\"north\":0,\"west\":2}}";
    private static final long ROOM_ID = 0;

    private final RoomData.IConfiguration configuration = () -> folder.getRoot();
    private RoomData data;
    private static final Map<String, Long> paths = new HashMap<>();

    @BeforeClass
    public static void testSetUp() {
        paths.put("north", 0l);
        paths.put("south", 1l);
        paths.put("west", 2l);
    }

    @Before
    public void setUp() throws IOException {
        folder.newFolder("rooms");
        File file = folder.newFile("rooms/0.json");
        FileWriter writer = new FileWriter(file);
        IOUtils.write(EXAMPLE_ROOM, writer);
        writer.close();
        data = new RoomData(configuration);
    }

    @Test
    public void testReadFileThatExists() {
        IRoom room = data.read(ROOM_ID);
        assertEquals(ROOM_ID, room.getId());
        assertEquals("Test Room", room.getName());
        assertEquals(paths, room.getPaths());
    }

    @Test(expected = DataException.class)
    public void testReadFileThatDoesNotExists() {
        data.read(9999);
    }

    @Test
    public void testWriteFile() {
        data.write(new Room(ROOM_ID, "Test Room", paths));
    }

    @Test(expected = DataException.class)
    public void testCannotWriteFile() {
        RoomData data2 = new RoomData(new RoomData.IConfiguration() {
            @Override
            public File getDataDirectory() {
                return new File("/zzzzzzzzzzzzzzzzzzzzzzz");
            }
        });
        data2.write(new Room(ROOM_ID, "Test Room", paths));
    }
}