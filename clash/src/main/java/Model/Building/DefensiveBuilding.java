package Model.Building;

import javafx.scene.image.ImageView;

public abstract class DefensiveBuilding extends Building{
    private int attackValue;

    public DefensiveBuilding(int attackValue,int health, ImageView buildingImage) {
        super(health, buildingImage);
        this.attackValue = attackValue;
    }


}
