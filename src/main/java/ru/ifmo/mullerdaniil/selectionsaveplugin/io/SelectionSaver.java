package ru.ifmo.mullerdaniil.selectionsaveplugin.io;

import java.io.IOException;

public interface SelectionSaver {
    void saveSelection(String selectionText, String filePath) throws IOException;
}