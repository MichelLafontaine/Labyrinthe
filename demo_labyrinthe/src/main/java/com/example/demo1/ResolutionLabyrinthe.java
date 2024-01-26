package com.example.demo1;

import java.util.ArrayList;

public class ResolutionLabyrinthe {
    int[][] labyrinthe;
    int departX;
    int departY;
    int arriveX;
    int arriveY;

    public ResolutionLabyrinthe(int[][] labyrinthe, int departX, int departY, int arriveX, int arriveY) {
        this.labyrinthe = labyrinthe;
        this.departX = departX;
        this.departY = departY;
        this.arriveX = arriveX;
        this.arriveY = arriveY;
    }

    public int[][] getLabyrinthe() {
        return labyrinthe;
    }

    public void resolution(){
        int[] verificationEnvironnement = new int[4];
        int emplacementX = departX;
        int emplacementY = departY;
        boolean premierPassage = false;
        boolean retour = false;
        do{
            verificationEnvironnement[0] = labyrinthe[emplacementX][emplacementY - 1];
            verificationEnvironnement[1] = labyrinthe[emplacementX][emplacementY + 1];
            verificationEnvironnement[2] = labyrinthe[emplacementX - 1][emplacementY];
            verificationEnvironnement[3] = labyrinthe[emplacementX + 1][emplacementY];
            for (int i = 0; i < 4; i++){
                    if (verificationEnvironnement[i] == 1){
                        premierPassage = true;
                    }
                    if (verificationEnvironnement[i] == 2){
                        retour = true;
                    }
            }
            if (premierPassage){
                if(verificationEnvironnement[0] == 1){
                    emplacementY--;
                } else if (verificationEnvironnement[1] == 1){
                    emplacementY++;
                } else if (verificationEnvironnement[2] == 1){
                    emplacementX--;
                } else if (verificationEnvironnement[3] == 1) {
                    emplacementX++;
                }
                labyrinthe[emplacementX][emplacementY] = 2;
            } else if (retour) {
                labyrinthe[emplacementX][emplacementY] = 3;
                if(verificationEnvironnement[0] == 2){
                    emplacementY--;
                } else if (verificationEnvironnement[1] == 2){
                    emplacementY++;
                } else if (verificationEnvironnement[2] == 2){
                    emplacementX--;
                } else if (verificationEnvironnement[3] == 2) {
                    emplacementX++;
                }
            }
            premierPassage = false;
            retour = false;
        } while (labyrinthe[arriveY][arriveX] != 2);
    }
}
