package com.company;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Picture {

    int a=330,b=600;
    int[][] mapa = new int[a][b];
    int prog=230;
    int[] histogram=new int[256];


    void scan() throws FileNotFoundException {
        File f = new File("C:\\Users\\piotr\\IdeaProjects\\przyciemnianie\\Mapa_MD_no_terrain_low_res_Gray.txt");
        Scanner scan= new Scanner(f);

        for(int x=0;x<a;x++){
            for(int y=0;y<b;y++){
                mapa[x][y]=scan.nextInt();
                histogram[(mapa[x][y])]++;
            }
        }

        for(int i=0;i<256;i++){
            System.out.println(i+" "+histogram[i]);
        }
    }


    void binaryzacja(){

        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                if(mapa[i][j]<prog) mapa[i][j]=0;
                else mapa[i][j]=255;
            }
        }
    }

    void saveAsText() throws FileNotFoundException {
        File nfile = new File("mapa_binarna.txt");

         PrintWriter wr = new PrintWriter(nfile);
         for (int i=0;i<a;i++){
             for(int j=0;j<b;j++){
                 wr.print(mapa[i][j] + " ");
             }
             wr.println();
         }
    }

}
