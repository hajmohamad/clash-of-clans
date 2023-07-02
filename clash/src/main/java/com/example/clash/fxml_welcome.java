package com.example.clash;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class fxml_welcome implements Initializable {


    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView img_background;

    @FXML
    private Label lbl_welcome;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new Thread() {
            @Override
            public void run() {
                int count = 5;
                while (--count > 0) {
                    img_background.setImage(new Image(Main.class.getResource("img/login.jpg").toString()));
                    try {
                        TimeUnit.MILLISECONDS.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    img_background.setImage(new Image(Main.class.getResource("img/wellcome.jpg").toString()));
                    try {
                        TimeUnit.MILLISECONDS.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }.start();




    }
    @FXML
    void hi(MouseEvent event) throws IOException {
        allPageshow.show_login();

    }

}
