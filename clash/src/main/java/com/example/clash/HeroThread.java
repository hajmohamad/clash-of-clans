package com.example.clash;

import Controller.PlayerController;
import Model.Building.Building;
import Model.Building.DefensiveBuilding;
import Model.Building.HouseOfKing;
import Model.Hero.Hero;
import Model.Hero.archer;
import Model.Player;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
    private ArrayList<BuildingThread> buildingThreadArrayList;

    private boolean blFighting =false;
    public HeroThread(ImageView hero, AnchorPane enemyMap, ArrayList<Building> enemyBuildingMap,ArrayList<Hero> heroes, ArrayList<BuildingThread> buildingThreads) {
        this.hero =(Hero) hero;
        this.enemyMap = enemyMap;
        this.JustBuilding = enemyBuildingMap;
        JustHero=heroes;
        HeroImg =(ImageView) hero;
        buildingThreadArrayList=buildingThreads;
    }
    ////////image changing  thread
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
        System.out.println(hero.getHeroName());
        System.out.println(firsHouseOfKing);
        if(!firsHouseOfKing){
        if(hero.getHeroName().contains("wizard")){
            for (Building bn:JustBuilding){
                if(bn.getClassName().equals(HouseOfKing.getArcherDb().getClassName())){
            nearBuild=bn;
            firsHouseOfKing=true;
            System.out.println("his");
                    break;}}
        }}
        else{
        double Distance=999.9;
        for(Building n:JustBuilding){
            double tempDistance=  Math.sqrt(Math.pow(n.getBoundsInParent().getCenterY()- HeroImg.getBoundsInParent().getCenterY()-5,2)+
                    Math.pow(n.getBoundsInParent().getCenterX()- HeroImg.getBoundsInParent().getCenterX()-5,2));
            if(tempDistance<Distance){
                Distance=tempDistance;
                nearBuild= n;
            }
        }}

    }

    public  void goNearBuild(){
        nearBuilding();
        TranslateTransition tt=new TranslateTransition(Duration.millis(7000),HeroImg);
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
            HeroImg.setFitWidth(150);
            HeroImg.setFitHeight(150);
            transitionIsStop=true;
        tt.play();
        ClassRunning.makeNotify();
        tt.setOnFinished(e->{
                //notifyNearBuilding();
                transitionIsStop=false;
                blFighting=true;
        });

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
        nearBuild.decreaseHealth(hero.getDamagePower());}
        if(nearBuild.getHealth()<=0){

                Platform.runLater(() -> {
                            enemyMap.getChildren().remove(nearBuild);
                            JustBuilding.remove(nearBuild);
                        });
            makeDelay(200);
            break;
        }
        }
    }
    @Override
    public void run() {
        firsHouseOfKing=false;

        ClassRunning=new RunningImg();
        ClassFighting=new fightingImg();
        ClassDead=new DeadImg();
        Thread zz=new Thread(ClassFighting);
        zz.start();
        Thread rr=new Thread(ClassRunning);
        rr.start();

        while (heroIsAlive()) {
           goNearBuild();
           makeDelay(100);
           damageBuilding();
 }
        Thread dd=new Thread(ClassDead);
        dd.start();
        Platform.runLater(() -> {
            enemyMap.getChildren().remove(hero);
        });
    }



}
