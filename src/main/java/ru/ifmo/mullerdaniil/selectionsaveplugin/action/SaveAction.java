package ru.ifmo.mullerdaniil.selectionsaveplugin.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;
import ru.ifmo.mullerdaniil.selectionsaveplugin.io.DefaultSelectionSaver;
import ru.ifmo.mullerdaniil.selectionsaveplugin.io.SelectionSaver;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SaveAction extends AnAction {
    private final SelectionSaver selectionSaver = new DefaultSelectionSaver();

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Editor editor = event.getData(PlatformDataKeys.EDITOR);

        if (editor != null) {
            String selectionText = editor.getSelectionModel().getSelectedText();

            if (selectionText == null) {
                Messages.showInfoMessage("A text must be selected to be saved.", "Information");
            } else {
                String fileName = Messages.showInputDialog("Enter the name of the file:",
                        "Save",
                        Messages.getQuestionIcon(),
                        "selection_" + getCurrentTimeString(),
                        null);

                if (fileName == null || fileName.isBlank()) {
                    Messages.showErrorDialog("Invalid file name", "Invalid File Name");
                } else {
                    try {
                        this.selectionSaver.saveSelection(selectionText, fileName);
                    } catch (IOException e) {
                        Messages.showErrorDialog("Unable to save the file.", "Save Error");
                    } catch (Exception e) {
                        Messages.showErrorDialog(e.getMessage(), "Unexpected Save Error");
                    }
                }
            }
        }

    }

    @Override
    public boolean isDumbAware() {
        return true;
    }

    public static String getCurrentTimeString() {
        var dateTime = LocalDateTime.now();
        var formatter = DateTimeFormatter.ofPattern("dd-MM-yyy_hh-mm-ss");

        return dateTime.format(formatter);
    }
}