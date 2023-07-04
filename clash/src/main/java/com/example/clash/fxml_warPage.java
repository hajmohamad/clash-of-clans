package com.example.clash;
import Model.Building.Building;
import Model.Hero.Hero;
import Model.Player;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class fxml_warPage implements Initializable {
    @FXML
    private AnchorPane ap;
    ImageView arrowImg;
    @FXML
    private VBox hbx_PlayerHeroes;
    private ArrayList<Hero> JustHero=new ArrayList();
    public  ArrayList<Building> JustBuilding=new ArrayList();
    @FXML
    private ImageView img_BackGroung=new ImageView();
    ArrayList<BuildingThread> buildingThreads=new ArrayList<>();
    public ArrayList<Building>  putBuildingOnPage(){

        for (Building building : Player.getWarPlayer().getPlayerMap().getMapBuilding()) {
            if(building.getClassName().equals("ArcherDB")||
                    building.getClassName().equals("FireDB")||
                    building.getClassName().equals("MortarDB")){
                BuildingThread buildingThread=new BuildingThread(ap,JustBuilding,JustHero,building,arrowImg);
                buildingThreads.add(buildingThread);
                Thread blThread=new Thread( buildingThread);
                blThread.start();
            }
            Building builing = building.copy();
            Building imgTemp=  building.copy();
            Player.buildingInMap+=1;
            builing.setLayoutY(Player.getWarPlayer().getPlayerMap().getyPosition().get(Player.getWarPlayer().getPlayerMap().getMapBuilding().indexOf(building)));
            builing.setLayoutX(Player.getWarPlayer().getPlayerMap().getxPosition().get(Player.getWarPlayer().getPlayerMap().getMapBuilding().indexOf(building)));
            imgTemp.setLayoutY(Player.getWarPlayer().getPlayerMap().getyPosition().get(Player.getWarPlayer().getPlayerMap().getMapBuilding().indexOf(building)));
            imgTemp.setLayoutX(Player.getWarPlayer().getPlayerMap().getxPosition().get(Player.getWarPlayer().getPlayerMap().getMapBuilding().indexOf(building)));
            ap.getChildren().add(builing);
            JustBuilding.add(builing);
        }
//        checkWin();




        return JustBuilding;
    }
    public void MackDraga(Hero img){
        img.setOnMousePressed(e->{

        });

        img.setOnMouseDragged(ez -> {
            img.setTranslateX(ez.getSceneX());
            img.setTranslateY(ez.getSceneY());

                });
        img.setOnMouseReleased(ez -> {
           HeroThread heroThread=new HeroThread(img,ap,JustBuilding,buildingThreads);
           Thread thread=new Thread(heroThread);
           thread.start();
            });

    }
    public void checkWin() {
        Thread tr=new Thread(() -> {
            System.out.println("THREAD IS RUN");
            while (true){

                if(Player.buildingInMap==3) {
                    System.out.println("hi");
                    break;
//            Rectangle rc=new Rectangle(1366,763, Color.rgb(128, 128, 128, 0.5));
//            rc.setOpacity(0.6);
//            ap.getChildren().add(rc);
//                break;}
                }}
            System.out.println("THREAD IS OFF");

        });
        tr.start();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

         arrowImg=new ImageView();
        ap.getChildren().add(arrowImg);
        arrowImg.setVisible(false);
        putBuildingOnPage();
        img_BackGroung.setImage(Player.getWarPlayer().getPlayerMap().getMapBackGround().getImage());
        for(Hero hero:Player.getPlayer().getPlayerHero()){
            ImageView h=new ImageView(hero.getHeroImg().getImage());
            h.setFitWidth(150);
            h.setFitHeight(150);
            hbx_PlayerHeroes.getChildren().add(h);
             h.setOnMousePressed(e->{
                 Hero img=hero.copy();
                 img.setFitWidth(150);
                 img.setFitHeight(150);
                 JustHero.add(img);
                 ap.getChildren().add(img);
                 MackDraga(img);
             });
         }
    }






}
