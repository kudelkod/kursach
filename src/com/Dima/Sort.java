package com.Dima;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Objects;


public class Sort extends JFrame {
    public Sort(){
        Array a = new Array();
        String[] items = new String[]{"1000", "10000", "100000"};
        setLayout(new GridLayout(1,3));
        JComboBox cmbBox= new JComboBox(items);
        JButton jbtCleanUnsorted = new JButton("Clean unsorted array");
        JButton jbtFile = new JButton("In file");
        JButton jbtCleanSorted = new JButton("Clean sorted array");
        JButton jbtCreat = new JButton("Creat");
        JButton jbtSortWaning = new JButton("SortW");
        JButton jbtSortIncrease = new JButton("SortI");
        JButton jbtExit = new JButton("Exit");
        JTextArea list1 = new JTextArea(34,15);
        list1.setLineWrap(true);
        list1.setWrapStyleWord(true);
        JTextArea list2 = new JTextArea(34,15);
        list2.setLineWrap(true);
        list2.setWrapStyleWord(true);
        JTextArea list3 = new JTextArea();
        JScrollPane scroll1 = new JScrollPane(list1);
        JScrollPane scroll2 = new JScrollPane(list2);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel(new GridLayout(12,1));
        JPanel panel3 = new JPanel();
        panel1.add(scroll1);
        panel2.add(cmbBox);
        panel2.add(jbtCreat);
        panel2.add(jbtCleanUnsorted);
        panel2.add(jbtSortWaning);
        panel2.add(jbtSortIncrease);
        panel2.add(jbtCleanSorted);
        panel2.add(jbtExit);
        panel2.add(jbtFile);
        panel2.add(list3);
        panel3.add(scroll2);
        add(panel1);
        add(panel2);
        add(panel3);
        jbtCreat.addActionListener(e -> {
            list1.setText(null);
            a.createArray();
            String[] s = a.getArray().split(", ");
            for (String value : s) {
                list1.append(value);
                list1.append("\n");
            }
        });
        jbtSortWaning.addActionListener(e -> {
            list2.setText(null);
            list3.setText(null);
            long startTime = System.currentTimeMillis();
            a.sortArrayWaning();
            String[] s = a.getArray().split(", ");
            for (String value : s) {
                list2.append(value);
                list2.append("\n");
            }
            long endTime = System.currentTimeMillis();
            list3.append("Total execution time: " + (endTime-startTime) + "ms");
        });
        jbtSortIncrease.addActionListener(e -> {
            list2.setText(null);
            list3.setText(null);
            long startTime = System.currentTimeMillis();
            a.sortArrayIncreace();
            String[] s = a.getArray().split(", ");
            for (String value : s) {
                list2.append(value);
                list2.append("\n");
            }
            long endTime = System.currentTimeMillis();
            list3.append("Total execution time: " + (endTime-startTime) + "ms");
        });
        jbtExit.addActionListener(e -> dispose());
        jbtCleanUnsorted.addActionListener(e -> list1.setText(null));
        jbtCleanSorted.addActionListener(e -> list2.setText(null));
        jbtFile.addActionListener(e ->{

            try(FileWriter writer = new FileWriter("file.txt", false))
            {
                // запись всей строки
                String[] text = a.getArray().split(", ");
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
            a.setNumberOfElements(n);
        });
    }
}
