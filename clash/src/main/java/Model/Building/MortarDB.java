package Model.Building;

import com.example.clash.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MortarDB extends DefensiveBuilding {
    public static MortarDB mortarDB;
    public MortarDB() {
        super(30,"MortarDB", 700, new ImageView(new Image(Main.class.getResource("img/mortar.png").toString())),
                new ImageView(new Image(Main.class.getResource("img/moArrow.png").toString())));
    }
    public static MortarDB getArcherDb(){
        if(mortarDB==null){
            mortarDB = new MortarDB();
            return mortarDB;}
        return mortarDB;}
}
