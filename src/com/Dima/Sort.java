package com.Dima;
import com.Dima.Static.*;
import com.Dima.Model.Array;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;


/**
 *<strong>Child class Sort, which is inherited from the class JFrame</strong>
 *
 * <i>in this class implemented core program Frame and it's components</i>
 *
 * @author Dmitriy Kudelko
 * @version 1.0
 */
public class Sort extends JFrame {
    /**
     *<i>Constructor to create core program Frame </i>
     */
    public Sort(){
        setResizable(true);
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font = new Font("Verdana", Font.PLAIN, 14);
        Font font1 = new Font("TimesRoman", Font.BOLD, 14);
        setTitle("Sorting numeric data using the 'Comb method'");
        setLocationRelativeTo(null);

        Array array = new Array();
        String[] items = new String[]{"1000", "10000", "100000"};

        setLayout(new GridLayout(0,3, 10,10));

        JPanel panel1 = new JPanel();

        JPanel panel2 = new JPanel(new GridLayout(10,1, 10, 20));

        JPanel panel3 = new JPanel();

        JComboBox<String> cmbBox= new JComboBox<>(items);
        cmbBox.setBorder(new RoundBorder(4));
        cmbBox.setFont(font);
        panel2.add(cmbBox);

        JButton jbtCreat = new JButton("Create array");
        jbtCreat.setBorder(new RoundBorder(8));
        jbtCreat.setFont(font1);
        panel2.add(jbtCreat);

        JButton jbtCleanUnsorted = new JButton("Clear source array");
        jbtCleanUnsorted.setBorder(new RoundBorder(8));
        jbtCleanUnsorted.setFont(font1);
        panel2.add(jbtCleanUnsorted);

        JButton jbtSortWaning = new JButton("Sort waning");
        jbtSortWaning.setBorder(new RoundBorder(8));
        jbtSortWaning.setFont(font1);
        panel2.add(jbtSortWaning);

        JButton jbtSortIncrease = new JButton("Sort increase");
        jbtSortIncrease.setBorder(new RoundBorder(8));
        jbtSortIncrease.setFont(font1);
        panel2.add(jbtSortIncrease);

        JButton jbtCleanSorted = new JButton("Clear sorted array");
        jbtCleanSorted.setBorder(new RoundBorder(8));
        jbtCleanSorted.setFont(font1);
        panel2.add(jbtCleanSorted);

        JButton jbtFile = new JButton("Writing to a file");
        jbtFile.setBorder(new RoundBorder(8));
        jbtFile.setFont(font1);
        panel2.add(jbtFile);

        JButton jbtExit = new JButton("Exit");
        jbtExit.setBorder(new RoundBorder(8));
        jbtExit.setFont(font1);
        panel2.add(jbtExit);

        JLabel label1 = new JLabel("Source array: ");
        label1.setFont(font1);
        panel1.add(label1);

        JTextArea list1 = new JTextArea(25,15);
        list1.setBorder(new RoundBorder(8));
        list1.setLineWrap(true);
        list1.setWrapStyleWord(true);
        list1.setFont(font1);

        JLabel label2 = new JLabel("Sorted array: ");
        label2.setFont(font1);
        panel3.add(label2);

        JTextArea list2 = new JTextArea(25,15);
        list2.setBorder(new RoundBorder(8));
        list2.setLineWrap(true);
        list2.setWrapStyleWord(true);
        list2.setFont(font1);

        JTextArea list3 = new JTextArea("Sorting execution time");
        list3.setBorder(new RoundBorder(8));
        list3.setFont(font1);
        panel2.add(list3);

        JScrollPane scroll1 = new JScrollPane(list1);
        panel1.add(scroll1);

        JScrollPane scroll2 = new JScrollPane(list2);
        panel3.add(scroll2);

        MenuBar menuBar = new MenuBar();
        setMenuBar(menuBar);

        Menu fileMenu = new Menu("File...");
        fileMenu.setFont(font1);
        Menu helpMenu = new Menu("Information...");
        helpMenu.setFont(font1);
        MenuItem inFile = new MenuItem("Writing to a file");
        inFile.setFont(font1);
        MenuItem aboutProgramm = new MenuItem("About program");
        aboutProgramm.setFont(font1);
        MenuItem aboutAuthor = new MenuItem("About author");
        aboutAuthor.setFont(font1);
        helpMenu.add(aboutProgramm);
        helpMenu.add(aboutAuthor);
        fileMenu.add(inFile);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        setVisible(true);

        add(panel1);
        add(panel2);
        add(panel3);

        setVisible(true);

        aboutProgramm.addActionListener(e -> new AboutProgram());

        aboutAuthor.addActionListener(e -> new AboutAuthor());

        inFile.addActionListener(e ->{

            try(FileWriter writer = new FileWriter("file.txt", true))
            {
                // запись всей строки
                String[] text = array.getArray().split(", ");
                for (String s : text) {
                    writer.append(s);
                    writer.append("\n");
                }
                writer.flush();
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
        });

        jbtCreat.addActionListener(e -> {
            list1.setText(null);
            array.createArray();
            String[] s = array.getArray().split(", ");
            for (String value : s) {
                list1.append(value);
                list1.append("\n");
            }
        });

        jbtSortWaning.addActionListener(e -> {
            list2.setText(null);
            list3.setText(null);
            long startTime = System.currentTimeMillis();
            array.sortArrayWaning();
            String[] s = array.getArray().split(", ");
            for (String value : s) {
                list2.append(value);
                list2.append("\n");
            }
            long endTime = System.currentTimeMillis();
            list3.append("Sorting time: " + (endTime-startTime) + " ms");
        });

        jbtSortIncrease.addActionListener(e -> {
            list2.setText(null);
            list3.setText(null);
            long startTime = System.currentTimeMillis();
            array.sortArrayIncreace();
            String[] s = array.getArray().split(",");
            for (String value : s) {
                list2.append(value);
                list2.append("\n");
            }
            long endTime = System.currentTimeMillis();
            list3.append("Sorting time: " + (endTime-startTime) + " ms");
        });

        jbtExit.addActionListener(e -> System.exit(0));

        jbtCleanUnsorted.addActionListener(e -> list1.setText(null));

        jbtCleanSorted.addActionListener(e -> list2.setText(null));

        jbtFile.addActionListener(e ->{

            try(FileWriter writer = new FileWriter("file.txt", false))
            {
                // запись всей строки
                String[] text = array.getArray().split(", ");
                for (String s : text) {
                    writer.append(s);
                    writer.append("\n");
                }
                writer.flush();
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
        });

        cmbBox.addActionListener(e -> {
            int n = Integer.parseInt((String) Objects.requireNonNull(cmbBox.getSelectedItem()));
            array.setNumberOfElements(n);
        });
    }
}
