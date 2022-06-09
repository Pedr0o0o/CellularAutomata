package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class PozarLasu {


    int szerokosc = 302;
    int dlugosc = 302;
    int pokolenia =10;



    int stan(int beg, int somsiadyZywe, int somsiadyPlonace){
        //najwiecej 8 somsiadow kazdego stanu

        int stan = beg;//stan poczatkowy

        if(stan == 0){//nie ma drzewa może cos urosnie
            double prawd = 7*Math.random() + somsiadyZywe; //[0;7] + [0;8]  = [0;15]
            if(prawd>=6.5) stan = 1; //[0;6.5) - nic ; [6.5;15] - cos

        }else if(stan == 1){//jest drzewo moze spłonie

            double prawd = 5*Math.random() + somsiadyPlonace; //[0;5] + [0;8]  = [0;13]
            if(prawd>=4.5) stan = 2; //[0;4.5) - nic ; [4.5;13] - cos

        }else if(stan == 2){//no to drzewo spłoneło i nie ma drzewa
            stan = 0;
        }

        return  stan;
    }


    int[][] tablicaStart(){//poczatkowy las drzew

        int[][] plac_zabaw = new int[szerokosc][dlugosc];

        for(int i=1;i<szerokosc-1;i++){
            for(int j =1 ;j<dlugosc-1;j++){
                plac_zabaw[i][j] = (int)(Math.random()+0.2);
            }
        }

        return  plac_zabaw;
    }

    void pozar() throws IOException {


        int[][] las = tablicaStart();

        for(int p=0;p<pokolenia;p++) {

            int[][] nextGeneration = new int[szerokosc][dlugosc];
            print(las,p);

            for (int x = 1; x < szerokosc - 1; x++) {
                for (int y = 1; y < dlugosc - 1; y++) {

                    int live = 0;
                    int burn = 0;

                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            if (las[x + i][y + j] == 1) {
                                live++;
                            }
                            if (las[x + i][y + j] == 2) {
                                burn++;
                            }
                        }
                    }

                    if (las[x][y] == 1) {
                        live--;
                    }
                    if (las[x][y] == 2) {
                        live--;
                    }

                    nextGeneration[x][y]=stan(las[x][y],live,burn);


                }//tablica
            }//tablica

            las = nextGeneration;


        }//pokolenia
        print(las,pokolenia);
    }

    void print(int[][] tabObraz, int numer) throws IOException {//maluje las

        BufferedImage bI = new BufferedImage(szerokosc, dlugosc, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < szerokosc; i++) {
            for (int j = 0; j < dlugosc; j++) {
                {
                    if (tabObraz[i][j] == 0) {
                        bI.setRGB(i, j, Color.BLACK.getRGB());
                    } else if(tabObraz[i][j] == 1){
                        bI.setRGB(i, j, Color.GREEN.getRGB());
                    }else if(tabObraz[i][j] == 2) {
                        bI.setRGB(i, j, Color.RED.getRGB());
                    }
                }
            }

            String name = "pozar"+numer+".jpg";
            ImageIO.write(bI, "BMP", new File(name));
        }
    }





}
