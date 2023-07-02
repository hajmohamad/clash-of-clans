package Model.Building;

import Model.Admin;
import com.example.clash.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ArcherDB extends DefensiveBuilding{
public static ArcherDB archerDB;
    public ArcherDB() {
        super(20,"ArcherDB", 60, new ImageView(new Image(Main.class.getResource("img/archerTower.png").toString())));
    }
    public static ArcherDB getArcherDb(){
        if(archerDB==null){
            archerDB = new ArcherDB();
            return archerDB;}
return archerDB;}

}
