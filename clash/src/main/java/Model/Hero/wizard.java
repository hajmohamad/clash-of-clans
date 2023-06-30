package Model.Hero;

import com.example.clash.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class wizard extends Hero{
    public wizard() {
        super( new ImageView(new Image(Main.class.getResource("img/wizard.png").toString())), 0, 80, 40);
    }
}
