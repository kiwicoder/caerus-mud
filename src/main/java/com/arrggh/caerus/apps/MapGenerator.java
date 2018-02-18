package com.arrggh.caerus.apps;

import com.arrggh.caerus.apps.map.MapGeneratorApplication;
import org.apache.commons.cli.ParseException;

public class MapGenerator {
    public static void main(String[] args) throws ParseException {
        new MapGeneratorApplication().main(args);
    }
}
