package com.Dima;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Start StartFrame = new Start();
        StartFrame.setSize(800,600);
        StartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StartFrame.setTitle("Start");
        StartFrame.setLocationRelativeTo(null);
        StartFrame.setVisible(true);
    }
}
