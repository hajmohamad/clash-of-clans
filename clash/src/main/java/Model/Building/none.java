package Model.Building;

import com.example.clash.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class none extends NormalBuilding{
    public static none non;
    public none() {
        super(0, "none", new ImageView(new Image(Main.class.getResource("img/barbarian.png").toString())));
    }
    public static none getArcherDb(){
        if(non==null){
            non = new none();
            return non;}
        return non;}


}
