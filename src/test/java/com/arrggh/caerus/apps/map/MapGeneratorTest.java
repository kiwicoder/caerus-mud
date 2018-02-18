package com.arrggh.caerus.apps.map;

import com.arrggh.caerus.apps.MapGenerator;
import org.apache.commons.cli.ParseException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class MapGeneratorTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testMapGeneratorCreatesFiles() throws ParseException {
        runCreateCommandLine();
        runVerifyCommandLine();
    }

    private void runCreateCommandLine() throws ParseException {
        String[] args = {"--create", "--directory", folder.getRoot().toString()};
        MapGenerator.main(args);

        assertDirectoryExists(folder.getRoot(), "rooms");
        assertDirectoryExists(folder.getRoot(), "doors");
        assertDirectoryExists(folder.getRoot(), "paths");
    }

    private void runVerifyCommandLine() throws ParseException {
        String[] args = {"--verify", "--directory", folder.getRoot().toString()};
        MapGenerator.main(args);
    }

    private void assertDirectoryExists(File root, String directory) {
        File test = new File(root, directory);
        assertTrue(test.isDirectory());
        assertTrue(test.exists());
        assertTrue(test.canWrite());
        assertTrue(test.canRead());
    }
}