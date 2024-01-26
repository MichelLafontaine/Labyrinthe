package com.example.demo1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class JeuxLabyrinthe extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        int taille = 21;
        int tailleRectangle = 945 / taille;

        GridPane gridPane = new GridPane(taille,taille);
        gridPane.setHgap(tailleRectangle);
        gridPane.setVgap(tailleRectangle);
        Group group = new Group();

        CreationLabyrinthe creationLabyrinthe = new CreationLabyrinthe(taille);
        creationLabyrinthe.labyrintheAleatoire();

        int[][] labyrinthe = creationLabyrinthe.getLabyrinthe();
        int departX = creationLabyrinthe.getDepartX();
        int departY = creationLabyrinthe.getDepartY();
        int arriveX = creationLabyrinthe.getArriveX();
        int arriveY = creationLabyrinthe.getArriveY();

        ResolutionLabyrinthe resolutionLabyrinthe = new ResolutionLabyrinthe(labyrinthe, departX, departY, arriveX, arriveY);
        resolutionLabyrinthe.resolution();
        labyrinthe = resolutionLabyrinthe.getLabyrinthe();

        for(int row = 0;row< taille;row++){
            for (int col = 0; col < taille; col++) {
                Text text;
                Rectangle rectangle = new Rectangle(row * tailleRectangle,
                        col* tailleRectangle, tailleRectangle, tailleRectangle);
                if (col == departX && row == departY){
                    text = new Text("E");
                } else if(col == arriveX && row == arriveY){
                    text = new Text("S");
                } else {
                    text = new Text("");
                }
                switch (labyrinthe[row][col]){
                    case 1:
                        rectangle.setFill(Color.WHITE);
                        break;
                    case 2:
                        rectangle.setFill(Color.BLUEVIOLET);
                        break;
                    case 3:
                        rectangle.setFill(Color.ORANGE);
                        break;
                    default:
                        rectangle.setFill(Color.BLACK);
                        break;
                }
                text.setFill(Color.BLACK);
                group.getChildren().addAll(rectangle);
            }
        }

        Scene scene = new Scene(group, 945, 945);
        stage.setScene(scene);
        stage.setTitle("Labyrinthe en 2D");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}