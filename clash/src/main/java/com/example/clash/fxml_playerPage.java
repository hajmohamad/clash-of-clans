package com.example.clash;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class fxml_playerPage {
    @FXML
    void mth_showAttackPage(MouseEvent event) throws IOException {
        allPageshow.show_attackChosePAGE();

    }

    @FXML
    void mth_showYourHeroes(MouseEvent event) throws IOException {
        Scene scene = new Scene(new FXMLLoader(Main.class.getResource("BuyHero.fxml")).load(), 1366,763 );
        allPageshow.mainStage.setTitle("loginPage");
        allPageshow.mainStage.setScene(scene);
        allPageshow.mainStage.show();

    }

    @FXML
    void mth_showYourMap(MouseEvent event) throws IOException {
        Scene scene = new Scene(new FXMLLoader(Main.class.getResource("playerMap.fxml")).load(), 1366,763 );
        allPageshow.mainStage.setTitle("loginPage");
        allPageshow.mainStage.setScene(scene);
        allPageshow.mainStage.show();
    }

    @FXML
    void mth_showYourProfile(MouseEvent event) throws IOException {
        Scene scene = new Scene(new FXMLLoader(Main.class.getResource("playerProfile.fxml")).load(), 1366,763 );
        allPageshow.mainStage.setTitle("loginPage");
        allPageshow.mainStage.setScene(scene);
        allPageshow.mainStage.show();

    }
}
