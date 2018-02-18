package com.arrggh.caerus.apps.map;

import org.apache.commons.cli.*;

import java.io.File;

public class MapGeneratorApplication {
    public static void main(String[] args) throws ParseException {
        Options options = buildCommandLineOptions();

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("help")) {
            printHelpInformation(options);
            return;
        }

        String directory = cmd.getOptionValue("directory");
        if (directory != null) {
            File dataDirectory = new File(directory);
            Directories directories = new Directories(dataDirectory);
            if (cmd.hasOption("help")) {
                printHelpInformation(options);
            } else if (cmd.hasOption("create")) {
                createDataFiles(directories);
            } else if (cmd.hasOption("verify")) {
                verifyDataFiles(directories);
            } else {
                printHelpInformation(options);
            }
        } else {
            printHelpInformation(options);
        }
    }

    private static void createDataFiles(Directories directories) {
        System.out.println("Creating data files into " + directories.getRootDirectory());
        directories.createDirectories();
        new GenerateMapEntries(directories).generate();
    }

    private static void verifyDataFiles(Directories directories) {
        System.out.println("Verifying data files in " + directories.getRootDirectory());
        directories.verifyDirectories();
    }

    private static Options buildCommandLineOptions() {
        Options options = new Options();
        options.addOption(Option.builder("d")
                .argName("directory")
                .longOpt("directory")
                .hasArg()
                .desc("root data file directory")
                .required()
                .build());
        options.addOption(Option.builder("c")
                .longOpt("create")
                .desc("create the data files")
                .build());
        options.addOption(Option.builder("v")
                .longOpt("verify")
                .desc("verify the data files")
                .build());
        options.addOption(Option.builder("h")
                .longOpt("help")
                .desc("print this message")
                .build());
        return options;
    }

    private static void printHelpInformation(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("MapGenerator", options);
    }
}
