package com.example.clash;

import Controller.PlayerController;
import Model.Admin;
import Model.Building.Building;
import Model.Player;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class fxml_PlayerMap implements Initializable {

    @FXML
    private AnchorPane ap;
    @FXML
    private VBox hbox_adminBuilding;

    @FXML
    private ImageView img_BackGroung=new ImageView();
    @FXML
    void mth_finalization(MouseEvent event) throws IOException {
        PlayerController.setBuildingToDataBase();
        allPageshow.show_playerFirsPAGE();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            img_BackGroung.setImage(Player.getPlayer().getPlayerMap().getMapBackGround().getImage());
        for(Building building: Admin.getAdmin().getBuildings()){
            ImageView builing=building.getBuildingImage();
            if(Player.getPlayer().getPlayerMap().getMapBuilding().contains(building)){
                builing.setLayoutY(Player.getPlayer().getPlayerMap().getyPosition().get(Player.getPlayer().getPlayerMap().getMapBuilding().indexOf(building)));
                builing.setLayoutX(Player.getPlayer().getPlayerMap().getxPosition().get(Player.getPlayer().getPlayerMap().getMapBuilding().indexOf(building)));
                ap.getChildren().add(builing);
            }else {
                hbox_adminBuilding.getChildren().add(builing);

            }
            builing.setOnMouseClicked(event->{
                    builing.setTranslateX(event.getSceneX());
                    builing.setTranslateY(event.getSceneY());
                    if(!ap.getChildren().contains(builing)){
                    ap.getChildren().add(builing);

                    }

            });

            builing.setOnMouseDragged(event->{

                    builing.setTranslateX(event.getSceneX());
                    builing.setTranslateY(event.getSceneY());}

            );
            builing.setOnMouseReleased(event->{
                    if(!Player.getPlayer().getPlayerMap().getMapBuilding().contains(building)){
                    Player.getPlayer().getPlayerMap().setMapBuilding(building);
                    Player.getPlayer().getPlayerMap().setxPosition(event.getSceneX());
                    Player.getPlayer().getPlayerMap().setyPosition(event.getSceneY());}
                    else if(Player.getPlayer().getPlayerMap().getMapBuilding().contains(building)){
                        Player.getPlayer().getPlayerMap().setXByIndexPosition(event.getSceneX(),
                                Player.getPlayer().getPlayerMap().getMapBuilding().indexOf(building));
                        Player.getPlayer().getPlayerMap().setYByIndexPosition(event.getSceneY(),
                                Player.getPlayer().getPlayerMap().getMapBuilding().indexOf(building));
                    }
            });





}}
}
