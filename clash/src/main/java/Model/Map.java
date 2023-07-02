package Model;

import Model.Building.Building;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Map {
    private String playerId;
    private ArrayList<Building> MapBuilding=new ArrayList<>();
    private ImageView MapBackGround;
    private String linkBackGround;
    private ArrayList<Double> xPosition=new ArrayList<>();
    private ArrayList<Double> yPosition=new ArrayList<>();


    public Map(String playerId, ArrayList<Building> mapBuilding, ImageView mapBackGround, ArrayList<Double> xPosition, ArrayList<Double> yPosition) {
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

    public ArrayList<Double> getxPosition() {
        return xPosition;
    }

    public void setxPosition(double xPosition) {
        this.xPosition.add(xPosition);
    }

    public ArrayList<Double> getyPosition() {
        return yPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition.add(yPosition);
    }

    public ImageView getMapBackGround() {
        return MapBackGround;
    }

    public void setMapBackGround(ImageView mapBackGround) {
        MapBackGround = mapBackGround;
    }

    public String getLinkBackGround() {
        return linkBackGround;
    }

    public void setLinkBackGround(String linkBackGround) {
        this.linkBackGround = linkBackGround;
    }
    public void delteRow1(){if(this.MapBuilding.get(0).getClassName().equals("none")){
        this.xPosition.remove(0);
        this.yPosition.remove(0);
        this.MapBuilding.remove(0);}
    }
    public void setYByIndexPosition(double yPosition,int i) {
        this.yPosition.remove(i);
        this.yPosition.add(i,yPosition);
    }
    public void setXByIndexPosition(double yPosition,int i) {
        this.xPosition.remove(i);
        this.xPosition.add(i,yPosition);
    }
}
