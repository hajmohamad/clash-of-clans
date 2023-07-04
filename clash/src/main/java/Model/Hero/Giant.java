package Model.Hero;

import com.example.clash.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Giant extends Hero{
    public static Giant ar;
    public static Giant getHero(){
        if(ar==null){
            ar = new Giant();
            return ar;}
        return ar;}
    public Giant() {
        super( new ImageView(new Image(Main.class.getResource("img/giant.png").toString())), 0, 60, 30
                ,new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
    }
}
