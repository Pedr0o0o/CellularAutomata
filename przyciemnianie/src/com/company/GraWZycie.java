package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GraWZycie {


    int szerokosc = 202;
    int dlugosc = 202;
    int pokolenia =5;




    int[][] tablicaStart(){

        int[][] plac_zabaw = new int[szerokosc][dlugosc];

        for(int i=1;i<szerokosc-1;i++){
            for(int j =1 ;j<dlugosc-1;j++){
                plac_zabaw[i][j] = (int)(Math.random()+0.6);
            }
        }

        return  plac_zabaw;
    }



    void zycie() throws IOException {


        int[][] plac_zabaw = tablicaStart();

        for(int p=0;p<pokolenia;p++) {

            int[][] nextGeneration = new int[szerokosc][dlugosc];
            print(plac_zabaw,p);

            for (int x = 1; x < szerokosc - 1; x++) {
                for (int y = 1; y < dlugosc - 1; y++) {

                    int live = 0;

                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            if (plac_zabaw[x + i][y + j] == 1) {
                                live++;
                            }
                        }
                    }

                    if (plac_zabaw[x][y] == 1) {
                        live--;
                    }

                    if (plac_zabaw[x][y] == 1 && live == 3) plac_zabaw[x][y] = 1;
                    else if (plac_zabaw[x][y] == 0 && (live == 2 || live == 3)) nextGeneration[x][y] = 1;
                    else if (plac_zabaw[x][y] == 1 && live > 3) nextGeneration[x][y] = 0;
                    else if (plac_zabaw[x][y] == 1 && live < 2) nextGeneration[x][y] = 0;


                }//tablica
            }//tablica

            plac_zabaw = nextGeneration;


        }//pokolenia
        print(plac_zabaw,pokolenia);
    }

    void print(int[][] tabObraz, int numer) throws IOException {

        BufferedImage bI = new BufferedImage(szerokosc, dlugosc, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < szerokosc; i++) {
            for (int j = 0; j < dlugosc; j++) {
                {
                    if (tabObraz[i][j] == 1) {
                        bI.setRGB(i, j, Color.BLACK.getRGB());
                    } else {
                        bI.setRGB(i, j, Color.WHITE.getRGB());
                    }
                }
            }

            String name = "obraz"+numer+".jpg";
            ImageIO.write(bI, "BMP", new File(name));
        }
    }





}
