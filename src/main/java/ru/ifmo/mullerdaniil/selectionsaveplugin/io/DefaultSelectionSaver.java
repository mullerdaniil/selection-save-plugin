package ru.ifmo.mullerdaniil.selectionsaveplugin.io;

import java.io.*;

public class DefaultSelectionSaver implements SelectionSaver {
    private static final String SELECTIONS_FOLDER_NAME = "selections";
    private static final String FILE_EXTENSION = ".txt";

    @Override
    public void saveSelection(String selectionText, String filePath) throws IOException {
        File selectionsFolder = new File(System.getProperty("user.dir"), SELECTIONS_FOLDER_NAME);

        if (!selectionsFolder.exists()) {
            selectionsFolder.mkdir();
        }

        File selectionFile = new File(selectionsFolder, filePath + FILE_EXTENSION);

        try (var writer = new FileWriter(selectionFile, true)) {
            writer.write(selectionText);
        }
    }
}