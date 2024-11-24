package view;

import javax.swing.*;

import model.classes.DateLabelFormatter;
import org.jdatepicker.impl.*;
import view.panels.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class InputForm implements ActionListener {
//    private JTextField fNik, fNama, fTempatLahir, fAlamat, fRtRw, fKelDesa, fKecamatan, fKotaPembuatanKtp, fWNA;
//    private JDatePickerImpl fTanggalLahir, tanggalPembuatanKTPField;
//    private JFileChooser fcFoto, fcTtd;
    private JButton submit;

    Map<String, String> inputData, inputRadio, inputComboBox;
    Map<String, Date> inputDate;
    Map<String, File> inputFile;
    Map<String,Object> allInput = new HashMap<>();

    public InputForm() {
        initComponents();
    }

    private void initComponents() {
        JFrame frame = new JFrame();
        frame.setTitle("Input Data");
        frame.setBounds(400, 200, 1280, 720);
        frame.setLocationRelativeTo(null);

        InputPanel input = new InputPanel();
        InputDate date = new InputDate();
        InputRadio radio = new InputRadio();
        InputComboBox comboBox = new InputComboBox();
        InputCheckBox checkBox = new InputCheckBox();
        FileChooser fileChooser = new FileChooser();

        JTextField fNik, fNama, fTempatLahir, fAlamat, fRtRw, fKelDesa, fKecamatan, fBerlakuHingga, fKotaPembuatanKtp;
        JDatePickerImpl fTanggalLahir, fTanggalPembuatanKTP;
        JFileChooser fcFoto, fcTtd;


        JPanel c = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 50);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        fNik = new JTextField(16);
        c.add(input.createInputTextPanel(fNik, "NIK : "), gbc);

        gbc.gridx++;
        fNama = new JTextField(20);
        c.add(input.createInputTextPanel(fNama, "Nama : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        fTempatLahir = new JTextField(20);
        c.add(input.createInputTextPanel(fTempatLahir, "Tempat Lahir : "), gbc);

        gbc.gridx++;
        fTanggalLahir = new JDatePickerImpl(date.createDatePanel(), new DateLabelFormatter());
        c.add(date.createInputDatePanel(fTanggalLahir, "Tanggal Lahir : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        c.add(radio.createRadGender("Jenis Kelamin : "), gbc);

        gbc.gridx++;
        c.add(radio.createRadGolDarah("Golongan Darah : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        fAlamat = new JTextField(20);
        c.add(input.createInputTextPanel(fAlamat, "Alamat : "), gbc);

        gbc.gridx++;
        fRtRw = new JTextField(20);
        c.add(input.createInputTextPanel(fRtRw, "RT/RW : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        fKelDesa = new JTextField(20);
        c.add(input.createInputTextPanel(fKelDesa, "Kelurahan/Desa : "), gbc);

        gbc.gridx++;
        fKecamatan = new JTextField(20);
        c.add(input.createInputTextPanel(fKecamatan, "Kecamatan : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        c.add(comboBox.createInputComboBoxAgama("Agama : "), gbc);

        gbc.gridx++;
        c.add(comboBox.createInputComboBoxStatusKawin("Status Perkawinan : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        gbc.gridwidth = 2;
        c.add(checkBox.createCheckBoxPekerjaan("Pekerjaan : "), gbc);

        gbc.gridx--;
        gbc.gridy++;
        c.add(radio.createRadWN("Kewarganegaraan : "), gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        fcFoto = new JFileChooser();
        c.add(fileChooser.createFileChooser(fcFoto, "Foto : "), gbc);

        gbc.gridy++;
        fcTtd = new JFileChooser();
        c.add(fileChooser.createFileChooser(fcTtd, "Tanda Tangan : "), gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
        fBerlakuHingga = new JTextField(20);
        c.add(input.createInputTextPanel(fBerlakuHingga, "Berlaku hingga : "), gbc);

        gbc.gridy++;
        fKotaPembuatanKtp = new JTextField(20);
        c.add(input.createInputTextPanel(fKotaPembuatanKtp, "Kota Pembuatan KTP : "), gbc);

        gbc.gridy++;
        fTanggalPembuatanKTP = new JDatePickerImpl(date.createDatePanel(), new DateLabelFormatter());
        c.add(date.createInputDatePanel(fTanggalPembuatanKTP, "Tanggal Pembuatan KTP : "), gbc);

        frame.add(c);

        JScrollPane scrollPane = new JScrollPane(c);
        frame.add(scrollPane);

        submit = new JButton("Submit!");
        submit.setBounds(10, 100, 200, 40);
        submit.addActionListener(this);
        submit.setEnabled(true);
        submit.setVisible(true);

        gbc.gridx--;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        c.add(submit, gbc);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void onSubmit() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        onSubmit();
    }
}
