package com.example.clash;

import Controller.PlayerController;
import Model.Building.Building;
import Model.Building.DefensiveBuilding;
import Model.Building.HouseOfKing;
import Model.Hero.Hero;
import Model.Hero.archer;
import Model.Player;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
public class HeroThread implements Runnable {
    private Hero hero;
    private AnchorPane enemyMap;
    private ArrayList<Building> JustBuilding;
    private ArrayList<Hero> JustHero;
    private ImageView HeroImg;
    private Building nearBuild = null;
    private boolean transitionIsStop=true;
    private fightingImg ClassFighting;
    private RunningImg ClassRunning;
    private DeadImg ClassDead;
    private boolean DeadThread=false;
    ProgressBar PBhealth;
    private ArrayList<BuildingThread> buildingThreadArrayList;
    private boolean blFighting =false;
    public HeroThread(ImageView zhero, AnchorPane enemyMap, ArrayList<Building> enemyBuildingMap,ArrayList<Hero> heroes, ArrayList<BuildingThread> buildingThreads) {
        this.hero =(Hero) zhero;
        this.enemyMap = enemyMap;
        this.JustBuilding = enemyBuildingMap;
        JustHero=heroes;
        HeroImg =(ImageView) zhero;
        buildingThreadArrayList=buildingThreads;
        PBhealth=new ProgressBar(1);
    }
    class fightingImg implements Runnable{
        @Override
        public void run() {
            synchronized (this){
                try {
                    wait();
                    while (!DeadThread){
                    for (ImageView im:hero.getFightingImg()) {
                        if(DeadThread){
                            break;
                        }
                        if(nearBuild.getHealth()<=0){
                            wait();
                        }
                        try {
                            TimeUnit.MILLISECONDS.sleep(60);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        HeroImg.setImage(im.getImage());
                    }

                    }
                }
            catch (InterruptedException e){
            }}

        }
        public synchronized void makeNotify(){this.notify();}
    }
    class RunningImg implements Runnable{
        @Override
        public void run() {
            synchronized (this){
                try {
                    wait();
                    while (!DeadThread){
                        for (ImageView im:hero.getRunningImg()) {
                            if(DeadThread){
                                break;
                            }
                            if(!transitionIsStop){
                                wait();
                            }
                            try {
                                TimeUnit.MILLISECONDS.sleep(60);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            HeroImg.setImage(im.getImage());
                        }

                    }
                }
                catch (InterruptedException e){
                }

        }
            }
         public synchronized void makeNotify(){this.notify();}
    }
    class DeadImg implements Runnable{
        @Override
        public void run() {
            synchronized (this){
                    for (ImageView im:hero.getDeadImg()) {
                        try {
                            TimeUnit.MILLISECONDS.sleep(80);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        HeroImg.setImage(im.getImage());
                    }


            }}
    }
    private boolean firsHouseOfKing=false;
    public void nearBuilding(){
        if(!firsHouseOfKing&&hero.getHeroName().equals("wizard")){
            for (Building bn:JustBuilding){
                if(bn.getClassName().equals(HouseOfKing.getArcherDb().getClassName())){
            nearBuild=bn;
            firsHouseOfKing=true;
                    break;}}
        }
        else{
        double Distance=999.9;
        for(Building n:JustBuilding){
            double tempDistance=  Math.sqrt(Math.pow(n.getBoundsInParent().getCenterY()- HeroImg.getBoundsInParent().getCenterY()-5,2)+
                    Math.pow(n.getBoundsInParent().getCenterX()- HeroImg.getBoundsInParent().getCenterX()-5,2));
            if(tempDistance<Distance){
                Distance=tempDistance;
                nearBuild= n;
                buildingHealth=nearBuild.getHealth();
            }
        }}

    }
    public  void goNearBuild(){
        nearBuilding();
        TranslateTransition tt=new TranslateTransition(Duration.millis(7000),HeroImg);
        Path path=new Path();
        MoveTo moveTo=new MoveTo(HeroImg.getBoundsInParent().getCenterX(),HeroImg.getBoundsInParent().getCenterY());
        LineTo lineTo=new LineTo(nearBuild.getBoundsInParent().getCenterX(),nearBuild.getBoundsInParent().getCenterY());
        path.getElements().addAll(moveTo,lineTo);
        PathTransition pathTransition=new PathTransition();
        pathTransition.setNode(HeroImg);
        pathTransition.setPath(path);
        pathTransition.setDuration(Duration.millis(1500));

        if(nearBuild.getBoundsInParent().getCenterX()>HeroImg.getBoundsInParent().getCenterX()){
            tt.setByX(nearBuild.getBoundsInParent().getCenterX()- HeroImg.getBoundsInParent().getCenterX()-50);
            HeroImg.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        }else{
            tt.setByX(nearBuild.getBoundsInParent().getCenterX()- HeroImg.getBoundsInParent().getCenterX()+50);
            HeroImg.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        }
        if(nearBuild.getBoundsInParent().getCenterY()>HeroImg.getBoundsInParent().getCenterY()){
            tt.setByY(nearBuild.getBoundsInParent().getCenterY()- HeroImg.getBoundsInParent().getCenterY()-50);
        }else{
            tt.setByY(nearBuild.getBoundsInParent().getCenterY()- HeroImg.getBoundsInParent().getCenterY()+50);
        }
        TranslateTransition zz=new TranslateTransition(Duration.millis(7000),PBhealth);
        zz.setByY(tt.getByY());
        zz.setByX(tt.getByX());
        HeroImg.setFitWidth(150);
            HeroImg.setFitHeight(150);
            transitionIsStop=true;
        zz.play();
        tt.play();
        ClassRunning.makeNotify();
        tt.setOnFinished(e->{
           notifyNearBuilding();
            transitionIsStop=false;
                blFighting=true;
        });

    }
    public void notifyNearBuilding(){
        for(BuildingThread buildingThread:buildingThreadArrayList) {
            if(buildingThread.getBuilding().getClassName().equals(nearBuild.getClassName())){
            buildingThread.setNearHero(hero);
                buildingThread.makeNotify();
                System.out.println(buildingThread.getBuilding().getClassName()+"*/*/*//*"+(nearBuild.getClassName()));
            }
        }
    }
    public Boolean heroIsAlive(){
        if(hero.getHealth()>0){
            return true;
        }
        return false;
    }
    public void makeDelay(int delayTime){
        try {
            TimeUnit.MILLISECONDS.sleep(delayTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public void damageBuilding(){
        while(!transitionIsStop&&heroIsAlive()){
              if(blFighting){
                ClassFighting.makeNotify();
                blFighting=false;
            }
              if(!heroIsAlive()){
                  break;
              }
              if(nearBuild.getHealth()>=0){
        makeDelay(200);
        nearBuild.decreaseHealth(hero.getDamagePower());

              }
        if(nearBuild.getHealth()<=0){
            Platform.runLater(() -> {
                nearBuild.setVisible(false);
                enemyMap.getChildren().remove(nearBuild);
                enemyMap.getChildren().remove(nearBuild);
                JustBuilding.remove(nearBuild);
            });
            makeDelay(200);
            break;
        }
        }
    }
    int heroHealth=0;
    int buildingHealth=0;
    @Override
    public void run() {
        heroHealth=hero.getHealth();
        ClassRunning=new RunningImg();
        ClassFighting=new fightingImg();
        ClassDead=new DeadImg();
        Thread zz=new Thread(ClassFighting);
        zz.start();
        Thread rr=new Thread(ClassRunning);
        rr.start();
        Platform.runLater(()->{
            PBhealth.maxHeight(5);
            PBhealth.maxWidth(30);
            enemyMap.getChildren().add(PBhealth);
            PBhealth.setLayoutX(hero.getBoundsInParent().getCenterX()-20);
            PBhealth.setLayoutY(hero.getBoundsInParent().getCenterY()-55);
        });


        while (heroIsAlive()) {
           goNearBuild();
            Platform.runLater(() -> {
                PBhealth.setProgress(hero.getHealth()/heroHealth);});
           makeDelay(100);
           damageBuilding();

        }
        System.out.println(hero.getHeroName()+"is dead");
//        Thread dd=new Thread(ClassDead);
//        dd.start();
        Platform.runLater(() -> {
            PBhealth.setVisible(false);
            enemyMap.getChildren().remove(hero);
        });
    }



}
