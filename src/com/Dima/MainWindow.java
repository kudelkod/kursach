package com.Dima;

import com.Dima.Model.Array;
import com.Dima.Static.RoundedBorders;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;


/**
 *<strong>Child class MainWindow, which is inherited from the class JFrame</strong>
 *
 * <i>in this class implemented core program Frame and it's components</i>
 *
 * @author Dmitriy Kudelko
 * @version 1.0
 */
public class MainWindow extends JFrame {
    /**
     *<i>Constructor to create core program Frame </i>
     */
    public MainWindow(){
        setResizable(false);
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font = new Font("TimesRoman", Font.BOLD, 14);
        setTitle("Sorting numeric data using the 'Comb method'");
        setLocationRelativeTo(null);

        Array array = new Array();
        String[] items = new String[]{"1000", "10000", "100000"};

        setLayout(new GridLayout(0,3, 10,10));

        JPanel panelSourceArray = new JPanel();

        JPanel panelComponents = new JPanel(new GridLayout
                (10,1, 10, 20));

        JPanel panelSortArray = new JPanel();

        JPanel panelRadioButton = new JPanel(new GridLayout
                (1,2));
        panelRadioButton.setBorder(new RoundedBorders(8));

        JComboBox<String> cmbBox= new JComboBox<>(items);
        cmbBox.setBorder(new RoundedBorders(4));
        cmbBox.setFont(font);
        cmbBox.setToolTipText("Select number " +
                "of elements to for array");
        panelComponents.add(cmbBox);

        JButton jbtCreat = new JButton
                ("Create array");
        jbtCreat.setBorder(new RoundedBorders(8));
        jbtCreat.setFont(font);
        jbtCreat.setToolTipText("Create array" +
                " with random numbers");
        panelComponents.add(jbtCreat);

        JButton jbtCleanUnsorted = new JButton
                ("Clear source array");
        jbtCleanUnsorted.setBorder(new RoundedBorders(8));
        jbtCleanUnsorted.setFont(font);
        jbtCleanUnsorted.setToolTipText("Clean area" +
                " with source array");
        panelComponents.add(jbtCleanUnsorted);

        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton rbIncrease = new JRadioButton
                ("Sort Increase");
        rbIncrease.setToolTipText
                ("Select a type of sorting");
        rbIncrease.setSelected(true);
        JRadioButton rbWaning = new JRadioButton
                ("Sort Waning");
        rbWaning.setToolTipText
                ("Select a type of sorting");
        buttonGroup.add(rbIncrease);
        buttonGroup.add(rbWaning);
        panelRadioButton.add(rbIncrease);
        panelRadioButton.add(rbWaning);
        panelComponents.add(panelRadioButton);

        JButton jbtSort = new JButton("Sort");
        jbtSort.setBorder(new RoundedBorders(8));
        jbtSort.setFont(font);
        jbtSort.setToolTipText("MainWindow source array");
        panelComponents.add(jbtSort);

        JButton jbtCleanSorted = new JButton
                ("Clear sorted array");
        jbtCleanSorted.setBorder(new RoundedBorders(8));
        jbtCleanSorted.setFont(font);
        jbtCleanSorted.setToolTipText
                ("Clean area with sorted array");
        panelComponents.add(jbtCleanSorted);

        JButton jbtFile = new JButton
                ("Writing to a file");
        jbtFile.setBorder(new RoundedBorders(8));
        jbtFile.setFont(font);
        jbtFile.setToolTipText
                ("Writing data to a file");
        panelComponents.add(jbtFile);

        JButton jbtExit = new JButton("Exit");
        jbtExit.setBorder(new RoundedBorders(8));
        jbtExit.setFont(font);
        jbtExit.setToolTipText("Exit the program");
        panelComponents.add(jbtExit);

        JLabel labelSourceArray = new JLabel
                ("Source array: ");
        labelSourceArray.setFont(font);
        panelSourceArray.add(labelSourceArray);

        JTextArea listSourceArray = new JTextArea
                (25,15);
        listSourceArray.setBorder(new RoundedBorders(8));
        listSourceArray.setLineWrap(true);
        listSourceArray.setWrapStyleWord(true);
        listSourceArray.setFont(font);

        JLabel labelSortedArray = new JLabel
                ("Sorted array: ");
        labelSortedArray.setFont(font);
        panelSortArray.add(labelSortedArray);

        JTextArea listSortedArray = new JTextArea
                (25,15);
        listSortedArray.setBorder(new RoundedBorders(8));
        listSortedArray.setLineWrap(true);
        listSortedArray.setWrapStyleWord(true);
        listSortedArray.setFont(font);

        JTextArea listTime = new JTextArea
                ("Sorting execution time");
        listTime.setBorder(new RoundedBorders(8));
        listTime.setFont(font);
        panelComponents.add(listTime);

        JScrollPane scrollSourceArray = new JScrollPane
                (listSourceArray);
        panelSourceArray.add(scrollSourceArray);

        JScrollPane scrollSortedArray = new JScrollPane
                (listSortedArray);
        panelSortArray.add(scrollSortedArray);

        MenuBar menuBar = new MenuBar();
        setMenuBar(menuBar);

        Menu mnuFile = new Menu("File...");
        mnuFile.setFont(font);
        Menu mnuHelp = new Menu("Information...");
        mnuHelp.setFont(font);
        MenuItem inFile = new MenuItem
                ("Writing to a file");
        inFile.setFont(font);
        MenuItem aboutProgram = new MenuItem
                ("About program");
        aboutProgram.setFont(font);
        MenuItem aboutAuthor = new MenuItem
                ("About author");
        aboutAuthor.setFont(font);
        mnuHelp.add(aboutProgram);
        mnuHelp.add(aboutAuthor);
        mnuFile.add(inFile);

        menuBar.add(mnuFile);
        menuBar.add(mnuHelp);

        setVisible(true);

        add(panelSourceArray);
        add(panelComponents);
        add(panelSortArray);

        setVisible(true);

        aboutProgram.addActionListener
                (e -> new AboutProgram());

        aboutAuthor.addActionListener
                (e -> new AboutAuthor());

        inFile.addActionListener(e ->{

            FileNameExtensionFilter filterTxt =
                    new FileNameExtensionFilter(".txt", ".*");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(filterTxt);

            if ( fileChooser.showSaveDialog(null)
                    == JFileChooser.APPROVE_OPTION ) {
                try ( FileWriter writer = new FileWriter
                        (fileChooser.getSelectedFile() +
                                fileChooser.getFileFilter().getDescription())) {
                    String[] text = array.getArray().split(", ");
                    for (String s : text) {
                        writer.append(s);
                        writer.append("\n");
                    }
                    JOptionPane.showMessageDialog(null, "Data recorded successful");
                }
                catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        jbtCreat.addActionListener(e -> {
            listSourceArray.setText(null);
            array.createArray();
            String[] s = array.getArray().split(", ");
            for (String value : s) {
                listSourceArray.append(value);
                listSourceArray.append("\n");
            }
        });

        jbtSort.addActionListener(e -> {
            try {
                if (rbIncrease.isSelected()) {
                    listSortedArray.setText(null);
                    listTime.setText(null);
                    long startTime = System.currentTimeMillis();
                    array.sortArrayIncreace();
                    String[] s = array.getArray().split(",");
                    for (String value : s) {
                        listSortedArray.append(value);
                        listSortedArray.append("\n");
                    }
                    long endTime = System.currentTimeMillis();
                    listTime.append("Sorting time: " +
                            (endTime - startTime) + " ms");
                } else if (rbWaning.isSelected()) {
                    listSortedArray.setText(null);
                    listTime.setText(null);
                    long startTime = System.currentTimeMillis();
                    array.sortArrayWaning();
                    String[] s = array.getArray().split(", ");
                    for (String value : s) {
                        listSortedArray.append(value);
                        listSortedArray.append("\n");
                    }
                    long endTime = System.currentTimeMillis();
                    listTime.append("Sorting time: " +
                            (endTime - startTime) + " ms");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Select a sorting type!");
                }
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null,
                        "Create array please!");
            }
        });

        jbtExit.addActionListener(e -> System.exit(0));

        jbtCleanUnsorted.addActionListener
                (e -> listSourceArray.setText(null));

        jbtCleanSorted.addActionListener
                (e -> listSortedArray.setText(null));

        jbtFile.addActionListener(e ->{
            FileNameExtensionFilter filterTxt =
                    new FileNameExtensionFilter(".txt", ".txt");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(filterTxt);

            if ( fileChooser.showSaveDialog(null)
                    == JFileChooser.APPROVE_OPTION ) {
                try ( FileWriter writer = new FileWriter
                        (fileChooser.getSelectedFile() +
                        fileChooser.getFileFilter().getDescription())) {
                    String[] text = array.getArray().split(", ");
                    for (String s : text) {
                        writer.append(s);
                        writer.append("\n");
                    }
                    JOptionPane.showMessageDialog(null, "Data recorded successful");
                }
                catch (IOException ioException) {
                        ioException.printStackTrace();
                }
            }
        });

        cmbBox.addActionListener(e -> {
                int n = Integer.parseInt((String) Objects.
                        requireNonNull(cmbBox.getSelectedItem()));
                array.setNumberOfElements(n);
        });
    }
}
