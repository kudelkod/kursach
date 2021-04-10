package com.Dima;

import javax.swing.*;

public class Start extends JFrame {
    public Start(){

        JPanel panel = new JPanel();
        JButton jbtStart = new JButton("Start");
        JButton jbtAuthor = new JButton("About Author");
        JButton jbtProgramm = new JButton("About Programm");
        JButton jbtExit = new JButton("Exit");
        panel.add(jbtStart);
        panel.add(jbtAuthor);
        panel.add(jbtProgramm);
        panel.add(jbtExit);
        add(panel);

        jbtStart.addActionListener(e -> {
            Sort SortFrame = new Sort();
            SortFrame.setSize(800,600);
            SortFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            SortFrame.setTitle("Sort");
            SortFrame.setLocationRelativeTo(null);
            SortFrame.setVisible(true);
        });
        jbtAuthor.addActionListener(e -> {
            AboutAuthor AuthorFrame = new AboutAuthor();
            AuthorFrame.setSize(800,600);
            AuthorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            AuthorFrame.setTitle("Sort");
            AuthorFrame.setLocationRelativeTo(null);
            AuthorFrame.setVisible(true);

        });
        jbtProgramm.addActionListener(e -> {
            AboutProgramm ProgrammFrame = new AboutProgramm();
            ProgrammFrame.setSize(800,600);
            ProgrammFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ProgrammFrame.setTitle("Sort");
            ProgrammFrame.setLocationRelativeTo(null);
            ProgrammFrame.setVisible(true);
        });
        jbtExit.addActionListener(e -> dispose());
    }
}
