package com.Dima;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *<strong>Child class AboutAuthor, which is inherited from the class JFrame</strong>
 *
 * <i>In this class implemented Frame about author and it's components</i>
 */
public class AboutAuthor extends JFrame {
    /**
     *<i>Constructor to create Frame about author</i>
     */
    public AboutAuthor() {
        setResizable(false);
        setSize(500,400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Об авторе");
        setLocationRelativeTo(null);
        JLabel label = new JLabel();
        add(label);
        try{
            BufferedImage image = ImageIO.read(new File("D:\\kursach\\out\\artifacts" +
                    "\\kursach_jar\\static\\Author.jpg"));
            ImageIcon icon = new ImageIcon(image.getScaledInstance(120,120, Image.SCALE_SMOOTH));
            label.setIcon(icon);
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        label.setBounds(20, 20,120,120);
        add(new myComponent());
        setVisible(true);
    }

    /**
     *<strong>Child class myComponent, which is inherited from the class JComponent</strong>
     *
     * <i>In this class implemented component for {@link AboutAuthor}</i>
     */
    static class myComponent extends JComponent{
        protected void paintComponent(Graphics g){
            Font font1 = new Font("TimesRoman", Font.BOLD, 12);
            Graphics2D g1 = (Graphics2D) g;
            g1.setFont(font1);
            g1.drawString(" Автор: Куделко Дмитрий", 150, 40);
            g1.drawString(" E-Mail: kudelkod63@gmail.com", 150, 60);
            g1.drawString(" Об Авторе: Студент белорусского национального", 150, 80);
            g1.drawString(" национального технического университета", 150, 100);
            g1.drawString(" обучается на Факультете информационных", 150, 120);
            g1.drawString(" технологий и робототехники", 150,140);

        }
    }
}
