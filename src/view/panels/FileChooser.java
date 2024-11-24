package view.panels;

import javax.swing.*;

import static view.panels.Panel.createPanel;

public class FileChooser {
    public JPanel createFileChooser(JFileChooser fileChooser, String labelText) {
        JPanel panel = createPanel(labelText);
        panel.add(fileChooser);
        return panel;
    }
}
