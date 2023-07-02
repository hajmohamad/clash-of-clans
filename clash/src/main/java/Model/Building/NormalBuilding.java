package Model.Building;

import javafx.scene.image.ImageView;

public abstract class    NormalBuilding extends Building{
    public NormalBuilding(int health,String className, ImageView buildingImage) {
        super(health, className, buildingImage);
    }
}
