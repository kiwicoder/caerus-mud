package com.arrggh.caerus.apps.map;

import java.io.File;

public class Directories {
    private final File roomDirectory;
    private final File doorDirectory;
    private final File pathDirectory;
    private final File rootDirectory;

    public Directories(File directory) {
        rootDirectory = directory;
        roomDirectory = new File(directory, "rooms");
        doorDirectory = new File(directory, "doors");
        pathDirectory = new File(directory, "paths");
    }

    public File getRootDirectory() {
        return rootDirectory;
    }

    public File getRoomDirectory() {
        return roomDirectory;
    }

    public File getPathDirectory() {
        return pathDirectory;
    }

    public File getDoorDirectory() {
        return doorDirectory;
    }

    public boolean createDirectories() {
        return createDirectory(roomDirectory) && createDirectory(doorDirectory) && createDirectory(pathDirectory);
    }

    public boolean verifyDirectories() {
        return verifyDirectory(roomDirectory) && verifyDirectory(doorDirectory) && verifyDirectory(pathDirectory);
    }

    private static boolean createDirectory(File directory) {
        directory.mkdir();
        return verifyDirectory(directory);
    }

    private static boolean verifyDirectory(File directory) {
        return directory.exists() && directory.isDirectory();
    }
}
