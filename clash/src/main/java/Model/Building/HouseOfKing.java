package Model.Building;

import com.example.clash.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HouseOfKing extends NormalBuilding {
    public static HouseOfKing houseOfKing;
    public HouseOfKing() {
        super(150,"HouseOfKing",new ImageView(new Image(Main.class.getResource("img/townhall.png").toString())));
    }
    public static HouseOfKing getArcherDb(){
        if(houseOfKing==null){
            houseOfKing = new HouseOfKing();
            return houseOfKing;}
        return houseOfKing;}
}
