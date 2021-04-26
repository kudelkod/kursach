package com.Dima;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;


public class Sort extends JFrame {
    public Sort(){
        setResizable(false);
        setSize(800,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Сортировка числовых данных методом 'Расчески'");
        setLocationRelativeTo(null);
        Array a = new Array();
        String[] items = new String[]{"1000", "10000", "100000"};
        setLayout(new GridLayout(1,3));
        JComboBox<String> cmbBox= new JComboBox<>(items);
        JButton jbtCleanUnsorted = new JButton("Очистить неотсортированный массив");
        JButton jbtFile = new JButton("Запись в файл");
        JButton jbtCleanSorted = new JButton("Очистить отсортированный массив");
        JButton jbtCreat = new JButton("Создать массив");
        JButton jbtSortWaning = new JButton("Сортировка по убыванию");
        JButton jbtSortIncrease = new JButton("Сортировка по возрастанию");
        JButton jbtExit = new JButton("Выход");
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
        MenuBar menuBar = new MenuBar();
        setMenuBar(menuBar);
        Menu fileMenu = new Menu("Файл...");
        Menu helpMenu = new Menu("Помощь...");
        MenuItem inFile = new MenuItem("Запись в файл");
        MenuItem aboutProgramm = new MenuItem("О программе");
        MenuItem aboutAuthor = new MenuItem("Об авторе");
        helpMenu.add(aboutProgramm);
        helpMenu.add(aboutAuthor);
        fileMenu.add(inFile);
        aboutProgramm.addActionListener(e -> new AboutProgramm());
        aboutAuthor.addActionListener(e -> new AboutAuthor());
        inFile.addActionListener(e ->{

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
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setVisible(true);

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
            String[] s = a.getArray().split(",");
            for (String value : s) {
                list2.append(value);
                list2.append("\n");
            }
            long endTime = System.currentTimeMillis();
            list3.append("Total execution time: " + (endTime-startTime) + "ms");
        });
        jbtExit.addActionListener(e -> System.exit(0));
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
