package view.panels;

import model.enums.GolonganDarah;
import model.enums.JenisKelamin;

import javax.swing.*;

import static view.panels.Panel.createPanel;

public class InputRadio {
    private ButtonGroup bGender, bGolDarah, bKewarganegaraan;

    public JPanel createRadGender(String labelText) {
        JPanel panel = createPanel(labelText);
        JRadioButton pria = new JRadioButton(String.valueOf(JenisKelamin.PRIA));
        JRadioButton wanita = new JRadioButton(String.valueOf(JenisKelamin.WANITA));
        pria.setActionCommand(pria.getText());
        wanita.setActionCommand(wanita.getText());

        bGender = new ButtonGroup();
        bGender.add(pria);
        bGender.add(wanita);

        panel.add(pria);
        panel.add(wanita);
        return panel;
    }

    public JPanel createRadGolDarah(String labelText) {
        JPanel panel = createPanel(labelText);
        JRadioButton a = new JRadioButton(String.valueOf(GolonganDarah.A));
        JRadioButton b = new JRadioButton(String.valueOf(GolonganDarah.B));
        JRadioButton o = new JRadioButton(String.valueOf(GolonganDarah.O));
        JRadioButton ab = new JRadioButton(String.valueOf(GolonganDarah.AB));

        bGolDarah = new ButtonGroup();
        bGolDarah.add(a);
        bGolDarah.add(b);
        bGolDarah.add(o);
        bGolDarah.add(ab);

        panel.add(a);
        panel.add(b);
        panel.add(o);
        panel.add(ab);
        return panel;
    }

    public JPanel createRadWN(String labelText) {
        JPanel panel = createPanel(labelText);
        JRadioButton wni = new JRadioButton("WNI");
        JRadioButton wna = new JRadioButton("WNA");

        bKewarganegaraan  = new ButtonGroup();
        bKewarganegaraan.add(wni);
        bKewarganegaraan.add(wna);
        
        JTextField fWNA = new JTextField(20);
        fWNA.setVisible(false);

        panel.add(wni);
        panel.add(wna);
        panel.add(fWNA);

        wna.addActionListener(e -> {
            if (wna.isSelected()) {
                fWNA.setVisible(true);
                panel.revalidate();;
                panel.repaint();
            }
        });

        wni.addActionListener(e -> {
            if (wni.isSelected()) {
                fWNA.setVisible(false);
                panel.revalidate();
                panel.repaint();
            }
        });

        return panel;
    }
}
