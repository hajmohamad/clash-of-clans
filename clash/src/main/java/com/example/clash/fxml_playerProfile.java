package com.example.clash;

import Model.Admin;
import Model.Building.Building;
import Model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class fxml_playerProfile implements Initializable {
    static int i=0;

    @FXML
    private AnchorPane ap_enemyMap;
    @FXML
    private Label lbl_enemyUserName;

    @FXML
    private Label lbl_enemylevel;

    @FXML
    private Label lbl_enemyloseCount;

    @FXML
    private Label lbl_enemywinCount;

    @FXML
    private ImageView img_enemyMap;
    @FXML
    private Label lbl_letsWar;
    @FXML
    private Label lbl_money;






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        lbl_enemyUserName.setText("username :"+Player.getPlayer().getId());
        lbl_enemyloseCount.setText("lose count :"+Player.getPlayer().getLosePlay());
        lbl_enemywinCount.setText("win count :"+Player.getPlayer().getWinPlay());
        lbl_enemylevel.setText("level :"+Player.getPlayer().getLevel());
        img_enemyMap.setImage(Player.getPlayer().getPlayerMap().getMapBackGround().getImage());
        lbl_money.setText("موجودی حساب :"+Player.getPlayer().getLevel()*100);
        for (Building building : Player.getPlayer().getPlayerMap().getMapBuilding()) {

                ImageView builing = building.getBuildingImage();
                builing.setFitWidth(builing.getImage().getWidth() / 2);
                builing.setFitHeight(builing.getImage().getHeight() / 2);
                {
                    builing.setLayoutY(Admin.getAdmin().getPlayers().get(i).getPlayerMap().getyPosition().get(Admin.getAdmin().getPlayers().get(i).getPlayerMap().getMapBuilding().indexOf(building)) / 2);
                    builing.setLayoutX(Admin.getAdmin().getPlayers().get(i).getPlayerMap().getxPosition().get(Admin.getAdmin().getPlayers().get(i).getPlayerMap().getMapBuilding().indexOf(building)) / 2);
                    ap_enemyMap.getChildren().add(builing);
                }

        }
        lbl_letsWar.setText("بازگشت به صحه قبل");

       lbl_letsWar.setOnMouseClicked(e->{
           try {
               allPageshow.show_playerFirsPAGE();
           } catch (IOException ex) {
               throw new RuntimeException(ex);
           }
       });
    }

}