package Model.Building;

import com.example.clash.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ArcherDB extends DefensiveBuilding{
    public ArcherDB() {
        super(20, 60, new ImageView(new Image(Main.class.getResource("img/archerTower.png").toString())));
    }
}
