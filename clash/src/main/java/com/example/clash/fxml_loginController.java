package com.example.clash;
import Controller.AdminController;
import Controller.PlayerController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;
public class fxml_loginController implements Initializable {

    @FXML
    private AnchorPane Hbox;

    @FXML
    private AnchorPane anchor_Login;

    @FXML
    private Button btn_login1;

    @FXML
    private Button btn_signup1;

    @FXML
    private Label lbl_login11;

    @FXML
    private Label lbl_login111;

    @FXML
    private Label lbl_login21;

    @FXML
    private Label lbl_login211;

    @FXML
    private Slider slider_login1;

    @FXML
    private TextField txt_password;

    @FXML
    private TextField txt_username;


        @FXML
        void mth_loging(ActionEvent event) {
            if(PlayerController.loginPlayer(txt_username.getText(),txt_password.getText())){


            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("خطا در ورود");
                alert.setHeaderText(null);
                alert.setContentText("نام کاربری و پسورد  شما اشنباه است " );
                alert.showAndWait();
            }



        }
        @FXML
        void mth_signup(ActionEvent event) {
            String str= PlayerController.addPlayer(txt_username.getText(),txt_password.getText());
            try {
                if (str.equals("your sighUp is successfully")) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("ثبت موفق");
                    alert.setHeaderText(null);
                    alert.setContentText("اطلاعات شما با موفقیت ثبت شد.");
                    alert.showAndWait();}else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("خطا در ثبت اطلاعات");
                    alert.setHeaderText(null);
                    alert.setContentText("خطا: " + str);
                    alert.showAndWait();
                }

            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("خطا در ثبت اطلاعات");
                alert.setHeaderText(null);
                alert.setContentText("خطا: " + str);
                alert.showAndWait();
            }
        }
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            lbl_login211.setVisible(false);

            slider_login1.valueProperty().addListener(new ChangeListener<Number>() {
                public void changed(ObservableValue<? extends Number> ov,
                                    Number old_val, Number new_val) {
                    if(new_val.doubleValue()==slider_login1.getMax()){
                        lbl_login211.setVisible(true);


                    }else if(new_val.doubleValue()==slider_login1.getMin()){
                        lbl_login211.setVisible(false);


                    }

                }
            });
        }

    }


