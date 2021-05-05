package com.Dima;
import com.Dima.Static.*;
import com.Dima.Model.Array;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;


/**
 *<strong>Дочерний класс Sort, который наследуется от класса JFrame</strong>
 *
 * <i>В данном классе реализован основной Frame программы и его компоненты</i>
 *
 * @author Dmitriy Kudelko
 * @version 1.0
 */
public class Sort extends JFrame {
    /**
     *<i>Конструктор для создания Frame</i>
     */
    public Sort(){
        setResizable(true);
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font = new Font("Verdana", Font.PLAIN, 14);
        Font font1 = new Font("TimesRoman", Font.BOLD, 14);
        setTitle("Сортировка числовых данных методом 'Расчески'");
        setLocationRelativeTo(null);

        Array array = new Array();
        String[] items = new String[]{"1000", "10000", "100000"};

        setLayout(new GridLayout(0,3, 10,10));

        JPanel panel1 = new JPanel();

        JPanel panel2 = new JPanel(new GridLayout(10,1, 10, 20));

        JPanel panel3 = new JPanel();

        JComboBox<String> cmbBox= new JComboBox<>(items);
        cmbBox.setFont(font);
        panel2.add(cmbBox);

        JButton jbtCreat = new JButton("Создать массив");
        jbtCreat.setBorder(new RoundBorder(8));
        jbtCreat.setFont(font1);
        panel2.add(jbtCreat);

        JButton jbtCleanUnsorted = new JButton("Очистить исходный массив");
        jbtCleanUnsorted.setBorder(new RoundBorder(8));
        jbtCleanUnsorted.setFont(font1);
        panel2.add(jbtCleanUnsorted);

        JButton jbtSortWaning = new JButton("Сортировка по убыванию");
        jbtSortWaning.setBorder(new RoundBorder(8));
        jbtSortWaning.setFont(font1);
        panel2.add(jbtSortWaning);

        JButton jbtSortIncrease = new JButton("Сортировка по возрастанию");
        jbtSortIncrease.setBorder(new RoundBorder(8));
        jbtSortIncrease.setFont(font1);
        panel2.add(jbtSortIncrease);

        JButton jbtCleanSorted = new JButton("Очистить отсортированный массив");
        jbtCleanSorted.setBorder(new RoundBorder(8));
        jbtCleanSorted.setFont(font1);
        panel2.add(jbtCleanSorted);

        JButton jbtFile = new JButton("Запись в файл");
        jbtFile.setBorder(new RoundBorder(8));
        jbtFile.setFont(font1);
        panel2.add(jbtFile);

        JButton jbtExit = new JButton("Выход");
        jbtExit.setBorder(new RoundBorder(8));
        jbtExit.setFont(font1);
        panel2.add(jbtExit);

        JLabel label1 = new JLabel("Исходный массив: ");
        label1.setFont(font1);
        panel1.add(label1);

        JTextArea list1 = new JTextArea(25,15);
        list1.setBorder(new RoundBorder(8));
        list1.setLineWrap(true);
        list1.setWrapStyleWord(true);
        list1.setFont(font1);

        JLabel label2 = new JLabel("Отсортированный массив: ");
        label2.setFont(font1);
        panel3.add(label2);

        JTextArea list2 = new JTextArea(25,15);
        list2.setBorder(new RoundBorder(8));
        list2.setLineWrap(true);
        list2.setWrapStyleWord(true);
        list2.setFont(font1);

        JTextArea list3 = new JTextArea("Время выполнения сортировки");
        list3.setBorder(new RoundBorder(8));
        list3.setFont(font1);
        panel2.add(list3);

        JScrollPane scroll1 = new JScrollPane(list1);
        panel1.add(scroll1);

        JScrollPane scroll2 = new JScrollPane(list2);
        panel3.add(scroll2);

        MenuBar menuBar = new MenuBar();
        setMenuBar(menuBar);

        Menu fileMenu = new Menu("Файл...");
        fileMenu.setFont(font1);
        Menu helpMenu = new Menu("Информация...");
        helpMenu.setFont(font1);
        MenuItem inFile = new MenuItem("Запись в файл");
        inFile.setFont(font1);
        MenuItem aboutProgramm = new MenuItem("О программе");
        aboutProgramm.setFont(font1);
        MenuItem aboutAuthor = new MenuItem("Об авторе");
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
            list3.append("Время сортировки: " + (endTime-startTime) + " мс");
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
            list3.append("Время сортировки: " + (endTime-startTime) + " мс");
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
