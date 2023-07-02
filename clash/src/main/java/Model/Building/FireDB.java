package Model.Building;

import com.example.clash.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FireDB extends DefensiveBuilding {
    public static FireDB fireDB;
    public FireDB() {
        super(30,"FireDB", 90, new ImageView(new Image(Main.class.getResource("img/fireDB.png").toString())));
    }
    public static FireDB getArcherDb(){
        if(fireDB==null){
            fireDB = new FireDB();
            return fireDB;}
        return fireDB;}
}
