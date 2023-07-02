package Model.Building;

import javafx.scene.image.ImageView;

public abstract class DefensiveBuilding extends Building{
    private int attackValue;

    public DefensiveBuilding(int attackValue,String className,int health, ImageView buildingImage) {
        super(health, className, buildingImage);
        this.attackValue = attackValue;
    }


}
