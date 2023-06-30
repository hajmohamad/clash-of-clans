package Model.Hero;

import javafx.scene.image.ImageView;

public abstract   class Hero {
    private ImageView heroImg;
    private int minLevel;
    private int health;
    private int damagePower;


    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamagePower() {
        return damagePower;
    }

    public void setDamagePower(int damagePower) {
        this.damagePower = damagePower;
    }

    public Hero(ImageView heroImg, int minLevel, int health, int damagePower) {
        this.heroImg = heroImg;
        this.minLevel = minLevel;
        this.health = health;
        this.damagePower = damagePower;
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

    public int getHealth() {
        return health;
    }
}
