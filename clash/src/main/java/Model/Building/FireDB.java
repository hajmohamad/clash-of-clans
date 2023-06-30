package Model.Building;

import com.example.clash.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FireDB extends DefensiveBuilding {
    public FireDB() {
        super(30, 90, new ImageView(new Image(Main.class.getResource("img/fireDB.png").toString())));
    }
}
