package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Obrazek {
    private BufferedImage image;

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //g2d.drawImage(image, 0, 0, this);
    }
}
