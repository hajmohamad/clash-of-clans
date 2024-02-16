package com.example.clash;

import Model.Building.*;
import Model.Hero.Hero;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BuildingThread implements Runnable{
    private Hero nearHero;

    public synchronized Hero getNearHero() {
        return nearHero;
    }

    public synchronized void setNearHero(Hero nearHero) {
        this.nearHero = nearHero;
    }

    private AnchorPane enemyMap;
    private ArrayList<Building> JustBuilding;
    private ArrayList<Hero> JustHero;
    private Building building;

    public Building getBuilding() {
        return building;
    }
    public void RemoveBuilding(){
        JustBuilding.remove(building);
        Platform.runLater(() -> {
            enemyMap.getChildren().remove(building);
        });
    }

    private ImageView arrowImg;
    private DefensiveBuilding DFBuilding;
    public BuildingThread(AnchorPane enemyMap, ArrayList<Building> justBuilding, ArrayList<Hero> justHero, Building building, ImageView zz) {
        this.enemyMap = enemyMap;
        JustBuilding = justBuilding;
        JustHero = justHero;
        this.building = building;
        if(building.getClassName().equals("ArcherDB")){
            DFBuilding= ArcherDB.archerDB;
        }
        if(building.getClassName().equals("FireDB")){
            DFBuilding= FireDB.fireDB;


        }if(building.getClassName().equals("MortarDB")){
            DFBuilding= MortarDB.mortarDB;
        }
        buildingHealth=DFBuilding.getHealth();
        PBuildingHealth=new ProgressBar(1);
//        Platform.runLater(()->{
//            enemyMap.getChildren().add(PBuildingHealth);
//            PBuildingHealth.setLayoutX(DFBuilding.getBoundsInParent().getCenterX()-20);
//            PBuildingHealth.setLayoutY(DFBuilding.getBoundsInParent().getCenterY()-55);
//            PBuildingHealth.setVisible(true);
//            System.out.println(building.getBoundsInParent().getCenterX()+"****"+building.getBoundsInParent().getCenterY());
//
//        });


    }
    public void buildingShoting(){
        Platform.runLater(()->{
            PBuildingHealth.setProgress((double) building.getHealth() /buildingHealth);
        });

        nearHero.setHealth(nearHero.getHealth()-DFBuilding.getAttackValue());
    }
    public void makeDelay(int delayTime){
        try {
            TimeUnit.MILLISECONDS.sleep(delayTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    ProgressBar PBuildingHealth;
    int buildingHealth=1;
    @Override
    public void run() {
        synchronized (this){
            try {
                System.out.println("building thread :"+building.getClassName());
                wait();
                Platform.runLater(()->{
                    PBuildingHealth.maxHeight(5);
                    PBuildingHealth.maxWidth(30);
                    PBuildingHealth.setLayoutX(building.getBoundsInParent().getCenterX()-20);
                    PBuildingHealth.setLayoutY(building.getBoundsInParent().getCenterY()-55);
                    PBuildingHealth.setProgress((double) building.getHealth() /buildingHealth);
                });
                while (building.getHealth()>0){
        if(building.getHealth()>0&&nearHero.getHealth()>0) {
            PBuildingHealth.setVisible(true);
            makeDelay(700);
            buildingShoting();
        }else
                if(building.getHealth()<=0){
                    building.setVisible(false);
                    Platform.runLater(() -> {
                        PBuildingHealth.setVisible(false);
                        enemyMap.getChildren().remove(building);
                        enemyMap.getChildren().remove(PBuildingHealth);
                        JustBuilding.remove(building);
                    });
                    break;
                }
                if(nearHero.getHealth()<=0){
        wait();}
        }

    }
            catch (Exception Z){
            }
        }}
    public synchronized void makeNotify(){
        this.notify();}

}
