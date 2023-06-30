package Model.Hero;

import com.example.clash.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Giant extends Hero{
    public Giant() {
        super( new ImageView(new Image(Main.class.getResource("img/giant.png").toString())), 0, 60, 30);
    }
}
