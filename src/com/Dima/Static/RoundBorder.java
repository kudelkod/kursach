package com.Dima.Static;

import javax.swing.border.Border;
import java.awt.*;

/**
 *
 */
public class RoundBorder implements Border {
    private int radius;

    /**
     * @param radius
     */
    public RoundBorder(int radius) {
        this.radius = radius;
    }


    /**
     * @param c
     * @return
     */
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }


    /**
     * @return
     */
    public boolean isBorderOpaque() {
        return true;
    }


    /**
     * @param c
     * @param g
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}
