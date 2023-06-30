package Model.Building;

import javafx.scene.image.ImageView;

public abstract class Building  {
    private int health;

    public int getHealth() {    
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public ImageView getBuildingImage() {
        return BuildingImage;
    }

    public void setBuildingImage(ImageView buildingImage) {
        BuildingImage = buildingImage;
    }

    private ImageView BuildingImage;

    protected Building(int health, ImageView buildingImage) {
        this.health = health;
        BuildingImage = buildingImage;
    }
}
