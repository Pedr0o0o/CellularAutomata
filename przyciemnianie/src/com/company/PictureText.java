package com.company;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PictureText {

    int a= 600;
    int b = 330;
    int[][] mapa= new int[a][b];

    public void odczyt() throws FileNotFoundException {
        File m = new File("C:\\Users\\piotr\\IdeaProjects\\przyciemnianie\\Mapa_MD_no_terrain_low_res_Gray.txt");
        Scanner s =new Scanner(m);
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++) {
                int liczba = s.nextInt();
                mapa[i][j]=liczba;
            }
        }

    }

    public int[][] przyciemnianie(){

        for(int i=0;i< a;i++){
            for(int j=0;j<b;j++){
                mapa[i][j]-=40;
                if(mapa[i][j]<0){
                    mapa[i][j]=0;
                }
            }
        }

        return mapa;
    }

    public int[][] rozjasnianie(){

        for(int i=0;i< a;i++){
            for(int j=0;j<b;j++){
                mapa[i][j]+=50;
                if(mapa[i][j]>255){
                    mapa[i][j]=255;
                }
            }
        }

        return mapa;
    }

    public void saveAsText() throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter("nowa_mapa.txt");
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++) {
                zapis.print(mapa[i][j]+" ");
            }
            zapis.println();
        }

    }


    public void print(){
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++) {
                System.out.print( mapa[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
}
