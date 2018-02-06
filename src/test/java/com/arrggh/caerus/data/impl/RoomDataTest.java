package com.arrggh.caerus.data.impl;

import com.arrggh.caerus.model.impl.Room;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RoomDataTest {
    private static final String EXAMPLE_ROOM = "{\"id\":{\"id\":0},\"name\":\"Test Room\"}";
    private static final Room.Id ROOM_ID = new Room.Id(0);

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    private File directory;
    private final RoomData.IConfiguration configuration = () -> folder.getRoot();
    private RoomData data;

    @Before
    public void setUp() throws IOException {
        directory = folder.newFolder("rooms");
        File file = folder.newFile("rooms/0.json");
        FileWriter writer = new FileWriter(file);
        IOUtils.write(EXAMPLE_ROOM, writer);
        writer.close();
        data = new RoomData(configuration);
    }

    @Test
    public void testReadFileThatExists() throws IOException {
        data.read(ROOM_ID);
    }

    @Test(expected = DataException.class)
    public void testReadFileThatDoesNotExists() throws IOException {
        data.read(new Room.Id(9999));
    }

    @Test
    public void testWriteFile() {
        data.write(new Room(ROOM_ID, "Test Room"));
    }
}