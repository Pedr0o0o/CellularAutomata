package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

public class Image {
    BufferedImage image;
    int wight;
    int height;


    void scan() throws IOException {
        File imageFile = new File("Mapa.bmp");
        try {
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }

        wight=image.getWidth();
        height=image.getHeight();


        Raster r= image.getRaster();

        for(int x=0;x<wight;x++){
            for(int y=0;y<height;y++){
                int tmpColor = image.getRGB(x,y);
                tmpColor+=60;
                image.setRGB(x,y,tmpColor);

            }
        }


        File pic=new File ("NowaMapa.bmp");
        ImageIO.write(image,"bmp",pic);

    }



}
