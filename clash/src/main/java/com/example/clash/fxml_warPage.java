package com.example.clash;

import Controller.PlayerController;
import Model.Building.Building;
import Model.Hero.Hero;
import Model.Player;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class fxml_warPage  {
    private AnchorPane ap=new AnchorPane();
    public static long startTime = 0;
    ImageView arrowImg;
    long time = 0;
    private VBox hbx_PlayerHeroes;
    private ArrayList<Hero> JustHero = new ArrayList();
    public ArrayList<Building> JustBuilding = new ArrayList();
    private ImageView img_BackGroung = new ImageView();
    ArrayList<BuildingThread> buildingThreads = new ArrayList<>();

    public ArrayList<Building> putBuildingOnPage() {

        for (Building building : Player.getWarPlayer().getPlayerMap().getMapBuilding()) {
            Building builing = building.copy();
            Building imgTemp = building.copy();
            Player.buildingInMap += 1;
            builing.setLayoutY(Player.getWarPlayer().getPlayerMap().getyPosition().get(Player.getWarPlayer().getPlayerMap().getMapBuilding().indexOf(building)));
            builing.setLayoutX(Player.getWarPlayer().getPlayerMap().getxPosition().get(Player.getWarPlayer().getPlayerMap().getMapBuilding().indexOf(building)));
            imgTemp.setLayoutY(Player.getWarPlayer().getPlayerMap().getyPosition().get(Player.getWarPlayer().getPlayerMap().getMapBuilding().indexOf(building)));
            imgTemp.setLayoutX(Player.getWarPlayer().getPlayerMap().getxPosition().get(Player.getWarPlayer().getPlayerMap().getMapBuilding().indexOf(building)));
            ap.getChildren().add(builing);
            JustBuilding.add(builing);
            System.out.println("*/*"+building.getBoundsInParent().getCenterY()+"*+/*"+building.getBoundsInParent().getCenterX());
            if (building.getClassName().equals("ArcherDB") ||
                    building.getClassName().equals("FireDB") ||
                    building.getClassName().equals("MortarDB")) {
                BuildingThread buildingThread = new BuildingThread(ap, JustBuilding, JustHero, building, arrowImg);
                buildingThreads.add(buildingThread);
                Thread blThread = new Thread(buildingThread);
               // blThread.start();
            }
        }
//        checkWin();


        return JustBuilding;
    }

    public void MackDraga(Hero img) {
        img.setOnMousePressed(e -> {

        });

        img.setOnMouseDragged(ez -> {
            img.setTranslateX(ez.getSceneX());
            img.setTranslateY(ez.getSceneY());

        });
        img.setOnMouseReleased(ez -> {
            for(Building BUILDING:JustBuilding){
                if(BUILDING.getBoundsInParent().intersects(img.getBoundsInParent())){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("مکان اشتباه");
                    alert.setHeaderText(null);
                    alert.setContentText("شما نمی توانید سرباز خور را در این مکان رها کنید");
                    alert.showAndWait();
                    img.setTranslateX(ez.getSceneX()-50);
                    img.setTranslateY(ez.getSceneY()-50);
                }
            }
            HeroThread heroThread = new HeroThread(img, ap, JustBuilding, JustHero, buildingThreads);
            Thread thread = new Thread(heroThread);
            thread.start();
        });

    }

    boolean win = false;
    boolean lose = false;

    public void choseWhoWiner() {
        if (Player.getPlayer().getHeroName().size() == 0 && JustHero.size() == 0) {
            lose = true;
        } else if (JustBuilding.size() == 0) {
            win = true;
        }
        if (win || lose) {
            if ((time == 0)) {
                time = System.currentTimeMillis() - fxml_warPage.startTime;
                time = time / 1000;
                int CStar = (int) ((double) time / (Player.getWarPlayer().getPlayerMap().getMapBuilding().size())) / 3;
                if (win) {
                    PlayerController.addLoserToDataBase(Player.getWarPlayer());
                    PlayerController.addWinerToDataBase(Player.getPlayer());
                    long finalTime = time;
                    Platform.runLater(() -> {

                        VBox winer = new VBox();
                        winer.setLayoutX(500);
                        winer.setLayoutY(40);
                        winer.setStyle("-fx-background-color: gray");
                        winer.setAlignment(Pos.CENTER);
                        winer.setOpacity(1);
                        HBox star = new HBox();
                        for (int i = 0; i < CStar && i < 3; i++) {
                            ImageView imgSTAR = new ImageView(new Image(Main.class.getResource("img/star.png").toString()));
                            imgSTAR.setFitWidth(150);
                            imgSTAR.setFitHeight(150);
                            star.getChildren().add(imgSTAR);
                        }

                        star.prefHeight(221);
                        star.prefWidth(1090);
                        Label lbWINER = new Label("WINER");
                        lbWINER.prefHeight(221);
                        lbWINER.prefWidth(1090);
                        winer.getChildren().add(lbWINER);
                        winer.getChildren().add(star);
                        Label lbtime = new Label("time :" +
                                finalTime);
                        lbtime.prefHeight(221);
                        winer.getChildren().add(lbtime);
                        Label money = new Label("Award received :"+Player.getWarPlayer().getLevel()*100);
                        lbtime.prefHeight(221);
                        Button nextPage=new Button("رفتن به صفحه اصلی");
                        nextPage.setOnMouseClicked(EZ->{
                            try {
                                allPageshow.show_playerFirsPAGE();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }                        });
                        winer.getChildren().add(money);
                        winer.getChildren().add(nextPage);
                        ap.getChildren().add(winer);

                    });
                } else {
                    PlayerController.addWinerToDataBase(Player.getWarPlayer());
                    PlayerController.addLoserToDataBase(Player.getPlayer());
                }
            }
        }
    }
    public void initialize() {
        arrowImg = new ImageView();
        ap.getChildren().add(arrowImg);
        arrowImg.setVisible(false);
        putBuildingOnPage();
        img_BackGroung.setImage(Player.getWarPlayer().getPlayerMap().getMapBackGround().getImage());
        ap.getChildren().add(hbx_PlayerHeroes);
        for (Hero hero : Player.getPlayer().getPlayerHero()) {
            ImageView h = new ImageView(hero.getHeroImg().getImage());
            h.setFitWidth(150);
            h.setFitHeight(150);
            hbx_PlayerHeroes.getChildren().add(h);
            h.setOnMousePressed(e -> {
                if (startTime == 0) {
                    startTime = System.currentTimeMillis();
                }
                if (Player.getPlayer().getHeroName().contains(hero.getHeroName())) {
                    Hero img = hero.copy();
                    img.setFitWidth(150);
                    img.setFitHeight(150);
                   // Player.getPlayer().decreaseHeroName(hero.getHeroName());
                    System.out.println(Player.getPlayer().getHeroName());
                    JustHero.add(img);
                    ap.getChildren().add(img);
                    MackDraga(img);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("اتمام رسیدن تعداد سرباز");
                    alert.setHeaderText(null);
                    alert.setContentText("را استفاده کردید" + hero.getHeroName() + "شما تمام سرباز های  ");
                    alert.showAndWait();
                }
            });
        }
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                choseWhoWiner();
            }
        }, 0, 2000);
    }
    public  void mama(){
        hbx_PlayerHeroes=new VBox();
        ap.getChildren().add(img_BackGroung);

        initialize();
        Scene scene = new Scene(ap, 1366, 763);
        allPageshow.mainStage.setScene(scene);
        allPageshow.mainStage.show();    }

}
