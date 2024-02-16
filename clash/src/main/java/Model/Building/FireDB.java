package Model.Building;

import com.example.clash.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FireDB extends DefensiveBuilding {
    public static FireDB fireDB;
    public FireDB() {
        super(20,"FireDB", 900, new ImageView(new Image(Main.class.getResource("img/fireDB.png").toString())),
                new ImageView(new Image(Main.class.getResource("img/missile.png").toString()))
                );
    }
    public static FireDB getArcherDb(){
        if(fireDB==null){
            fireDB = new FireDB();
            return fireDB;}
        return fireDB;}
}
