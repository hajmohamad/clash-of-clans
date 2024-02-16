package Model.Building;

import com.example.clash.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ArcherDB extends DefensiveBuilding{
public static ArcherDB archerDB;
    public ArcherDB() {
        super(20,"ArcherDB", 600, new ImageView(new Image(Main.class.getResource("img/archerTower.png").toString())),
                new ImageView(new Image(Main.class.getResource("img/arArrow.png").toString())));
    }
    public static ArcherDB getArcherDb(){
        if(archerDB==null){
            archerDB = new ArcherDB();
            return archerDB;}
return archerDB;}


}
