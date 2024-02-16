package com.example.clash;

import Model.Admin;
import Model.Hero.Hero;
import Model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class fxml_BuyHero implements Initializable {

    @FXML
    private HBox hbox_playerHero;

    @FXML
    private HBox vbox_adminHero;
    @FXML
    void mth_back(MouseEvent event) throws IOException {
        allPageshow.show_playerFirsPAGE();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(Player.getPlayer().getLevel());
        System.out.println(Admin.getAdmin().getHeroes().size());
        for (Hero hero : Admin.getAdmin().getHeroes()) {
            if(Player.getPlayer().getLevel()>=hero.getMinLevel()){
                System.out.println("12");
                VBox plyVbox=new VBox();
                plyVbox.setStyle("-fx-background-color: #5f4747");
                plyVbox.setOpacity(0.8);
                Label heroCount=new Label();
                int count=0;
                for (String str:Player.getPlayer().getHeroName()){
                    if(str.equals(hero.getHeroName())){
                        ++count;
                    }
                }
                heroCount.setText(String.valueOf(count));
                ImageView PlayerImg =new ImageView(hero.getHeroImg().getImage());
                plyVbox.getChildren().add(PlayerImg);
                plyVbox.getChildren().add(heroCount);
                PlayerImg.setFitWidth(300);
                PlayerImg.setFitHeight(300);
                hbox_playerHero.getChildren().add(plyVbox);
            ImageView adminImgHero = new ImageView(hero.getHeroImg().getImage());
            adminImgHero.setFitWidth(150);
            adminImgHero.setFitHeight(150);
            vbox_adminHero.getChildren().add(adminImgHero);
                adminImgHero.setOnMousePressed(e -> {
                if(Player.getPlayer().getMoney()>hero.getMinLevel()*10) {
                    Player.getPlayer().decreasMoney(hero.getMinLevel() * 10);
                    Player.getPlayer().setHeroName(hero.getHeroName());
                    heroCount.setText(String.valueOf(Integer.valueOf(heroCount.getText()) + 1));

                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("عدم موجودی");
                    alert.setHeaderText(null);
                    alert.setContentText("موحودی حساب شما کافی نمی باشد  ");
                    alert.showAndWait();
                }



            });


    }}}
}
