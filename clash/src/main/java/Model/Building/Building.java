package Model.Building;

import javafx.scene.image.ImageView;

public abstract class Building  {
    private int health;
    private String className;

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

    protected Building(int health, String className, ImageView buildingImage) {
        this.health = health;
        this.className = className;
        BuildingImage = buildingImage;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
