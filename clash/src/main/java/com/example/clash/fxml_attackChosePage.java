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

public class fxml_attackChosePage implements Initializable {
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



    @FXML
    void mt_backEnemy(MouseEvent event) {
        ap_enemyMap.getChildren().clear();
        ap_enemyMap.getChildren().add(img_enemyMap);
        i--;
        makeEnemy();


    }

    @FXML
    void mt_nextenemy(MouseEvent event) {
        ap_enemyMap.getChildren().clear();
        ap_enemyMap.getChildren().add(img_enemyMap);
        i+=1;
        makeEnemy();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        makeEnemy();
    }
    public  void makeEnemy() {
        if(Admin.getAdmin().getPlayers().size()==i){
            i=0;
        }
        if(Admin.getAdmin().getPlayers().get(i).getId().equals(Player.getPlayer().getId())){
            i+=1;
        }
//        System.out.println(("username :"+Admin.getAdmin().getPlayers().get(i).getId()));
//        System.out.println(Admin.getAdmin().getPlayers().get(i).getPlayerMap().getMapBuilding().toString());
//        System.out.println(Admin.getAdmin().getPlayers().get(i).getPlayerMap().getyPosition().toString());
//        System.out.println(Admin.getAdmin().getPlayers().get(i).getPlayerMap().getxPosition().toString());


        lbl_enemyUserName.setText("username :"+Admin.getAdmin().getPlayers().get(i).getId());
        lbl_enemyloseCount.setText("lose count :"+Admin.getAdmin().getPlayers().get(i).getLosePlay());
        lbl_enemywinCount.setText("win count :"+Admin.getAdmin().getPlayers().get(i).getWinPlay());
        lbl_enemylevel.setText("level :"+Admin.getAdmin().getPlayers().get(i).getLevel());
        img_enemyMap.setImage(Admin.getAdmin().getPlayers().get(i).getPlayerMap().getMapBackGround().getImage());
        lbl_money.setText("جایزه دریافتی :"+Admin.getAdmin().getPlayers().get(i).getLevel()*100);
        for (Building building : Admin.getAdmin().getPlayers().get(i).getPlayerMap().getMapBuilding()) {

                ImageView builing = building.getBuildingImage();
                builing.setFitWidth(builing.getImage().getWidth() / 2);
                builing.setFitHeight(builing.getImage().getHeight() / 2);
                {
                    builing.setLayoutY(Admin.getAdmin().getPlayers().get(i).getPlayerMap().getyPosition().get(Admin.getAdmin().getPlayers().get(i).getPlayerMap().getMapBuilding().indexOf(building)) / 2);
                    builing.setLayoutX(Admin.getAdmin().getPlayers().get(i).getPlayerMap().getxPosition().get(Admin.getAdmin().getPlayers().get(i).getPlayerMap().getMapBuilding().indexOf(building)) / 2);
                    ap_enemyMap.getChildren().add(builing);
                }

        }
       lbl_letsWar.setOnMouseClicked(e->{
           Player.setWarPlayer( Admin.getAdmin().getPlayers().get(i));
           try {
               allPageshow.show_warPage();
           } catch (IOException ex) {
               throw new RuntimeException(ex);
           }
       });
    }

}