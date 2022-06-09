package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Automaty_k {

    int reg = 90;
    int liczba = 15;
    int wielkosc =15;

    int[] DECnaBIN(int number){
        int[] bin = new int[8];
        int tmp = number;
        int i=0;

        do {
            bin[i] = tmp%2;
            tmp=tmp/2;

            i++;
        }while (tmp>0);

        for(int j=0;j<bin.length/2;j++){
            int t = bin[j];
            bin[j]=bin[bin.length-j-1];
            bin[bin.length-j-1] = t;
        }

        return bin;
    }

    int binNaDec(int tab[]){
        int decNumber =0;
        int j=0;
        for(int i=tab.length-1;i>=0;i--){
            decNumber += tab[i]^j;
            j++;
        }
        return decNumber;
    }

    void a_kom(){
        int[][] mapaODt = new int[liczba][];
        int[] n = DECnaBIN(reg);

        int[] mapa = new int[10];
        int nOP = n.length;

        for(int i=0;i<nOP;i++){
            mapa[i+1] = n[i];
        }
        mapa[0] = n[nOP-1];
        mapa[mapa.length-1] = n[0];
        mapaODt[0]=mapa;

        for(int h=1;h<liczba;h++) {

            int[] mapap1 = new int[10];

            for (int i = 0; i < nOP; i++) {
                int licz=0;

                int[] tabtmp = new int[3];
                int z = 0;
                for (int j = -1; j < 2; j++) {
                    tabtmp[z] = mapaODt[h-1][i + 1 + j];
                    z++;
                }

                licz = binNaDec(tabtmp);
                mapap1[i + 1] = mapaODt[h-1][licz];
            }
            mapap1[0] = mapap1[mapap1.length - 2];
            mapap1[mapap1.length - 1] = mapap1[1];
            
            mapaODt[h] = mapap1;

        }

        for(int j=0;j<liczba;j++) {
            for (int i = 0; i < mapaODt[j].length; i++) {
                System.out.print(mapaODt[j][i] + " ");
            }
            System.out.println();
        }
    }


}
