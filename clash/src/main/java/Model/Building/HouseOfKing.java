package Model.Building;

import com.example.clash.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HouseOfKing extends NormalBuilding {
    public HouseOfKing() {
        super(150,new ImageView(new Image(Main.class.getResource("img/townhall.png").toString())));
    }
}
