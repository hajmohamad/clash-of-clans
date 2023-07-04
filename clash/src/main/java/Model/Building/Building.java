package Model.Building;

import com.example.clash.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public  class Building extends ImageView {
    private int health;
    private String className;
    public int getHealth() {    
        return health;
    }
    public Building copy(){
        return new Building(this.health,this.className,this.BuildingImage);
    }
    public void decreaseHealth(int hel){
        this.health-=hel;
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
        this.BuildingImage = buildingImage;
        this.setImage(BuildingImage.getImage());
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
