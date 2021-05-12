package com.Dima;

import javax.swing.*;
import java.awt.*;

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
        setSize(800,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Об авторе");
        setLocationRelativeTo(null);
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
            Font font1 = new Font("TimesRoman", Font.BOLD, 14);
            Graphics2D g1 = (Graphics2D) g;
            g1.setFont(font1);
            g1.drawString(" Автор: Куделко Дмитрий", 0, 150);
            g1.drawString(" E-Mail: kudelkod63@gmail.com", 0, 200);
            g1.drawString(" Об Авторе: Студент белорусского национального технического университета", 0, 250);
            g1.drawString(" обучается на Факультете информационных технологий и робототехники", 0, 300);

        }
    }
}
