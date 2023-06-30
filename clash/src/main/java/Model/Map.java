package Model;

import Model.Building.Building;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Map {
    private String playerId;
    private ArrayList<Building> MapBuilding=new ArrayList<>();
    private ImageView MapBackGround;
    private ArrayList<Integer> xPosition=new ArrayList<>();
    private ArrayList<Integer> yPosition=new ArrayList<>();


    public Map(String playerId, ArrayList<Building> mapBuilding, ImageView mapBackGround, ArrayList<Integer> xPosition, ArrayList<Integer> yPosition) {
        this.playerId = playerId;
        MapBuilding = mapBuilding;
        MapBackGround = mapBackGround;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public ArrayList<Building> getMapBuilding() {
        return MapBuilding;
    }

    public void setMapBuilding(Building mapBuilding) {
        MapBuilding.add(mapBuilding);
    }

    public ArrayList<Integer> getxPosition() {
        return xPosition;
    }

    public void setxPosition(ArrayList<Integer> xPosition) {
        this.xPosition = xPosition;
    }

    public ArrayList<Integer> getyPosition() {
        return yPosition;
    }

    public void setyPosition(ArrayList<Integer> yPosition) {
        this.yPosition = yPosition;
    }

    public ImageView getMapBackGround() {
        return MapBackGround;
    }

    public void setMapBackGround(ImageView mapBackGround) {
        MapBackGround = mapBackGround;
    }
}
