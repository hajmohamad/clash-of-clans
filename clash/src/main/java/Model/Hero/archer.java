package Model.Hero;

import com.example.clash.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class archer extends Hero{
    public archer() {
        super( new ImageView(new Image(Main.class.getResource("img/archer.png").toString())), 0, 35, 20);
    }
}
