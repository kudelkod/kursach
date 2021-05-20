package com.Dima;

import com.Dima.Static.RoundedBorders;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


/**
 *<strong>Child class SplashScreen, which is inherited from the class JFrame</strong>
 *
 * <i>In this class implemented SplashScreen and it's component</i>
 *
 * @author Dmitriy Kudelko
 * @version 1.0
 */
public class SplashScreen extends JFrame {

    /**
     *<i>Constructor to create SplashScreen</i>
     */
    public SplashScreen(){
        setResizable(false);
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SplashScreen");
        setLocationRelativeTo(null);
        JLabel label = new JLabel();
        JButton jbtStart = new JButton("Next");
        jbtStart.setBorder(new RoundedBorders(8));
        JButton jbtExit = new JButton("Exit");
        jbtExit.setBorder(new RoundedBorders(8));
        add(label);
        add(jbtStart);
        add(jbtExit);
        jbtStart.setBounds(80,500,285,30);
        jbtExit.setBounds(410,500,285,30);
        //label.setSize(800,600);
        try{
            BufferedImage image = ImageIO.read(new File(
                    "D:\\kursach\\out\\artifacts" +
                    "\\kursach_jar\\static\\Comb_sort.gif"));
            ImageIcon icon = new ImageIcon(image.getScaledInstance
                    (200,200, Image.SCALE_SMOOTH));
            label.setIcon(icon);
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        label.setBounds(80, 250,200,200);



        jbtExit.addActionListener(e -> System.exit(0));
        jbtStart.addActionListener(e -> {
            dispose();
            new MainWindow();
        });
        add(new myComponent());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            /**
             * <i>метод закрывающий приложение при бездействии</i>
             */
            @Override
            public void run() {
                dispose();
                timer.cancel();
            }
        },
                60000);

        setVisible(true);
    }

    /**
     *<strong>Child class myComponent, which is inherited from the class JComponent</strong>
     *
     * <i>In this class implemented component for {@link SplashScreen}</i>
     */
    static class myComponent extends JComponent{
        protected void paintComponent(Graphics g){
            Font fontTitle = new Font("TimesRoman", Font.BOLD, 14);
            Graphics2D graphicsTitle = (Graphics2D) g;
            graphicsTitle.setFont(fontTitle);
            graphicsTitle.drawString(" Белорусский национальный " +
                    "технический университет", 200, 30);
            graphicsTitle.drawString(" Выполнил: студент гр.10702318", 530, 300);
            graphicsTitle.drawString(" Куделко Дмитрий Владимирович", 530, 320);
            graphicsTitle.drawString(" Проверил: к.ф.-м.н.,доц.", 530, 370);
            graphicsTitle.drawString(" Сидорик Валерий Владимирович", 530, 390);

            Font fontInfo = new Font("TimesRoman", Font.BOLD, 12);
            Graphics2D graphicsInfo = (Graphics2D) g;
            graphicsInfo.setFont(fontInfo);
            graphicsInfo.drawString(" Факультет информационных " +
                    "технологий и робототехники", 230, 60);
            graphicsInfo.drawString(" Кафедра программного обеспечения" +
                    " информационных систем и технологий", 172, 80);
            graphicsInfo.drawString(" Минск, 2021", 350, 480);

            Font fontTheme = new Font("TimesRoman", Font.BOLD, 25);
            Graphics2D graphicsTheme = (Graphics2D) g;
            graphicsTheme.setFont(fontTheme);
            graphicsTheme.drawString(" Курсовая работа", 280, 140);
            graphicsTheme.drawString(" Cортировка числовых " +
                    "данных методом 'Расчески'", 75, 200);


            Font fontDist = new Font("TimesRoman", Font.BOLD, 16);
            Graphics2D graphicsDist = (Graphics2D) g;
            graphicsDist.setFont(fontDist);
            graphicsDist.drawString(" По дисциплине " +
                    "'Программирование на языке Java' ", 180, 165);

        }
    }
}
