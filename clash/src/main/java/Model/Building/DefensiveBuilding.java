package Model.Building;

import javafx.scene.image.ImageView;

public abstract class DefensiveBuilding extends Building{
    private int attackValue;
    private ImageView arrowBuildingImg;

    public DefensiveBuilding(int attackValue, String className, int health, ImageView buildingImage, ImageView arrowBuildingImg) {
        super(health, className, buildingImage);
        this.attackValue = attackValue;
        this.arrowBuildingImg = arrowBuildingImg;
    }


    public ImageView getArrowBuildingImg() {
        return arrowBuildingImg;
    }

    public void setArrowBuildingImg(ImageView arrowBuildingImg) {
        this.arrowBuildingImg = arrowBuildingImg;
    }

    public int getAttackValue() {
        return attackValue;
    }

    public void setAttackValue(int attackValue) {
        this.attackValue = attackValue;
    }
}
