package com.example.demo1;

public class CreationLabyrinthe {
    private int taille;
    private int[][] labyrinthe;
    private int departX;
    private int departY;
    private int arriveX;
    private int arriveY;
    private int y;
    private int x;

    public CreationLabyrinthe(int taille) {
        this.taille = taille;
    }

    public void labyrintheAleatoire () {

        boolean finished =  false;
        labyrinthe = new int[taille][taille];
        int number = 1;
        for (int row = 0; row < taille - 1; row++) {
            for (int col = 0; col < taille - 1; col++) {
                if (row % 2 == 1 && col % 2 == 1) {
                    labyrinthe[col][row] = number;
                    number++;
                } else {
                    labyrinthe[col][row] = 0;
                }
            }
        }


        do {
            int nbAleatoireCol = (int) (Math.random() * (taille - 1));
            int nbAleatoireRow = (int) (Math.random() * (taille - 1));
            int min = -1;
            int max = -1;
            int cell1;
            int cell2;
            if (labyrinthe[nbAleatoireCol][nbAleatoireRow] == 0) {
                if (nbAleatoireCol > 0 && nbAleatoireCol < taille && nbAleatoireRow > 0 && nbAleatoireRow < taille) {
                    if (labyrinthe[nbAleatoireCol][nbAleatoireRow + 1] != 0
                            && labyrinthe[nbAleatoireCol][nbAleatoireRow - 1] != 0
                            && labyrinthe[nbAleatoireCol][nbAleatoireRow - 1] != labyrinthe[nbAleatoireCol][nbAleatoireRow + 1]) {
                        cell1 = labyrinthe[nbAleatoireCol][nbAleatoireRow + 1];
                        cell2 = labyrinthe[nbAleatoireCol][nbAleatoireRow - 1];
                        min = Math.min(cell1, cell2);
                        max = Math.max(cell2, cell1);
                        labyrinthe[nbAleatoireCol][nbAleatoireRow + 1] = min;
                        labyrinthe[nbAleatoireCol][nbAleatoireRow - 1] = min;
                        labyrinthe[nbAleatoireCol][nbAleatoireRow] = min;
                        finished = true;
                    }
                    if (labyrinthe[nbAleatoireCol + 1][nbAleatoireRow] != 0
                            && labyrinthe[nbAleatoireCol - 1][nbAleatoireRow] != 0
                            && labyrinthe[nbAleatoireCol - 1][nbAleatoireRow] != labyrinthe[nbAleatoireCol + 1][nbAleatoireRow]) {
                        cell1 = labyrinthe[nbAleatoireCol + 1][nbAleatoireRow];
                        cell2 = labyrinthe[nbAleatoireCol - 1][nbAleatoireRow];
                        min = Math.min(cell1, cell2);
                        max = Math.max(cell2, cell1);
                        labyrinthe[nbAleatoireCol + 1][nbAleatoireRow] = min;
                        labyrinthe[nbAleatoireCol - 1][nbAleatoireRow] = min;
                        labyrinthe[nbAleatoireCol][nbAleatoireRow] = min;
                        finished = true;
                    }
                    if (min != 0) {
                        for (int row = 0; row < taille - 1; row++) {
                            for (int col = 0; col < taille - 1; col++) {
                                if (labyrinthe[col][row] == max) {
                                    labyrinthe[col][row] = min;
                                }
                                if (labyrinthe[col][row] != 0 && labyrinthe[col][row] != 1){
                                    finished = false;
                                }
                            }
                        }
                    }

                }
            }
        } while (!finished);
        caseAleatoire();
        departX = x;
        departY = y;
        labyrinthe[x][y] = 2;
        caseAleatoire();
        arriveX = x;
        arriveY = y;
    }

    public void caseAleatoire(){
        do{
            x = (int) (Math.random() * (taille - 1));
            y = (int) (Math.random() * (taille - 1));
        } while (labyrinthe[y][x] == 0);
    }

    public int[][] getLabyrinthe() {
        return labyrinthe;
    }

    public int getDepartX() {
        return departX;
    }

    public int getDepartY() {
        return departY;
    }

    public int getArriveX() {
        return arriveX;
    }

    public int getArriveY() {
        return arriveY;
    }
}
