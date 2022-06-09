package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Picture_Filter {


    int a=332,b=602;
    int[][] mapa = new int[a][b];



    void scan() throws FileNotFoundException {
        File f = new File("C:\\Users\\piotr\\IdeaProjects\\przyciemnianie\\Mapa_MD_no_terrain_low_res_Gray.txt");
        Scanner scan= new Scanner(f);

        for(int x=1;x<a-1;x++){
            for(int y=1;y<b-1;y++){
                mapa[x][y]=scan.nextInt();
            }
        }
    }

    void dolnoprzepustowy() throws FileNotFoundException {
        int[][] filtrMapa = new int[a][b];
        int[][] filtr=new int[3][3];
        filtr[0][0] =1; filtr[0][1] =1; filtr[0][2] =1;
        filtr[1][0] =1; filtr[1][1] =1; filtr[1][2] =1;
        filtr[2][0] =1; filtr[2][1] =1; filtr[2][2] =1;

        int suma = 0;
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                suma +=filtr[i][j];
            }
        }
        for(int x=1;x<a-1;x++){
            for(int y=1;y<b-1;y++){

                int tmp=0;
                tmp =   mapa[x-1][y-1]*filtr[0][0] + mapa[x][y-1]*filtr[1][0] + mapa[x+1][y-1]*filtr[2][0] +
                        mapa[x-1][y]  *filtr[0][1] + mapa[x][y]  *filtr[1][1] + mapa[x+1][y]  *filtr[2][1] +
                        mapa[x-1][y+1]*filtr[0][2] + mapa[x][y+1]*filtr[1][2] + mapa[x+1][y+1]*filtr[2][2] ;


                        filtrMapa[x][y]=tmp/suma;



            }
        }

        File nfile = new File("mapa_dolnoP.txt");

        PrintWriter wr = new PrintWriter(nfile);
        for (int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                wr.print(filtrMapa[i][j] + " ");
            }
            wr.println();
        }
    }

    void gornoprzepustowy() throws FileNotFoundException {
        int[][] filtrMapa = new int[a][b];
        int[][] filtr=new int[3][3];
        filtr[0][0] =-1; filtr[0][1] =-1; filtr[0][2] =-1;
        filtr[1][0] =-1; filtr[1][1] = 9; filtr[1][2] =-1;
        filtr[2][0] =-1; filtr[2][1] =-1; filtr[2][2] =-1;

        int suma = 0;
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                suma +=filtr[i][j];
            }
        }

        for(int x=1;x<a-1;x++){
            for(int y=1;y<b-1;y++){

                int tmp=0;
                tmp =   mapa[x-1][y-1]*filtr[0][0] + mapa[x][y-1]*filtr[1][0] + mapa[x+1][y-1]*filtr[2][0] +
                        mapa[x-1][y]  *filtr[0][1] + mapa[x][y]  *filtr[1][1] + mapa[x+1][y]  *filtr[2][1] +
                        mapa[x-1][y+1]*filtr[0][2] + mapa[x][y+1]*filtr[1][2] + mapa[x+1][y+1]*filtr[2][2] ;


                filtrMapa[x][y]=tmp/1;



            }
        }

        File nfile = new File("mapa_gornP.txt");

        PrintWriter wr = new PrintWriter(nfile);
        for (int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                wr.print(filtrMapa[i][j] + " ");
            }
            wr.println();
        }
    }

    void filtrGausa() throws FileNotFoundException {
        int[][] filtrMapa = new int[a][b];
        int[][] filtr=new int[3][3];
        filtr[0][0] =1; filtr[0][1] =4; filtr[0][2] =1;
        filtr[1][0] =4; filtr[1][1] = 32; filtr[1][2] =4;
        filtr[2][0] =1; filtr[2][1] =4; filtr[2][2] =1;

        int suma = 0;
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                suma +=filtr[i][j];
            }
        }

        for(int x=1;x<a-1;x++){
            for(int y=1;y<b-1;y++){

                int tmp=0;
                tmp =   mapa[x-1][y-1]*filtr[0][0] + mapa[x][y-1]*filtr[1][0] + mapa[x+1][y-1]*filtr[2][0] +
                        mapa[x-1][y]  *filtr[0][1] + mapa[x][y]  *filtr[1][1] + mapa[x+1][y]  *filtr[2][1] +
                        mapa[x-1][y+1]*filtr[0][2] + mapa[x][y+1]*filtr[1][2] + mapa[x+1][y+1]*filtr[2][2] ;


                filtrMapa[x][y]=tmp/suma;



            }
        }

        File nfile = new File("mapa_gaus.txt");

        PrintWriter wr = new PrintWriter(nfile);
        for (int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                wr.print(filtrMapa[i][j] + " ");
            }
            wr.println();
        }
    }

}
