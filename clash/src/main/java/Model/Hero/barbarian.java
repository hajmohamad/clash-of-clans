package Model.Hero;

import com.example.clash.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class barbarian extends Hero{
    public barbarian() {
        super( new ImageView(new Image(Main.class.getResource("img/barbarian.png").toString())), 0, 35, 10);
    }
}
