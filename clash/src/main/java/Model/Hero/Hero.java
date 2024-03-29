package Model.Hero;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Hero extends ImageView  {
    private ImageView heroImg;
    private String HeroName;
    private ArrayList<ImageView> RunningImg;
    private ArrayList<ImageView> FightingImg;
    private ArrayList<ImageView> deadImg;

    public ArrayList<ImageView> getRunningImg() {
        return RunningImg;
    }

    public void setRunningImg(ImageView runningImg) {
        RunningImg.add(runningImg);
    }

    public ArrayList<ImageView> getFightingImg() {
        return FightingImg;
    }

    public void setFightingImg(ImageView fightingImg) {
        FightingImg.add(fightingImg);


    }

    public ArrayList<ImageView> getDeadImg() {
        return deadImg;
    }

    public void setDeadImg(ImageView deadImg) {
        this.deadImg.add(deadImg);
    }

    private int minLevel;
    private int health;
    private int damagePower;
    public Hero copy(){
        return new Hero(getHeroImg(),getMinLevel(),getHealth(),getDamagePower(),this.RunningImg,this.FightingImg,this.deadImg,HeroName);
    }


    public synchronized void setHealth(int health) {
        this.health = health;
    }
    public synchronized void decreasHealth(int health) {
        this.health -= health;
    }


    public int getDamagePower() {
        return damagePower;
    }

    public void setDamagePower(int damagePower) {
        this.damagePower = damagePower;
    }

    public Hero(ImageView heroImg, int minLevel, int health, int damagePower,ArrayList<ImageView> runningImg, ArrayList<ImageView> fightingImg, ArrayList<ImageView> deadImg1,String NAME) {
        this.heroImg = heroImg;
        this.setImage(heroImg.getImage());
        this.minLevel = minLevel;
        this.health = health;
        this.damagePower = damagePower;
        RunningImg=runningImg;
        FightingImg=fightingImg;
        deadImg=deadImg1;
        HeroName=NAME;



    }

    public ImageView getHeroImg() {
        return heroImg;
    }

    public void setHeroImg(ImageView heroImg) {
        this.heroImg = heroImg;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public synchronized int getHealth() {
        return health;
    }

    public String getHeroName() {
        return HeroName;
    }

    public void setHeroName(String heroName) {
        HeroName = heroName;
    }
}
