package Model.Building;

import com.example.clash.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MortarDB extends DefensiveBuilding {
    public MortarDB() {
        super(35, 70, new ImageView(new Image(Main.class.getResource("img/mortar.png").toString())));
    }
}
