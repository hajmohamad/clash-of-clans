package Model.Hero;

import Model.Building.ArcherDB;
import com.example.clash.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class archer extends Hero{
    public static archer ar;
    public static archer getHero(){
        if(ar==null){
            ar = new archer();
            return ar;}
        return ar;}
    public archer() {
        super( new ImageView(new Image(Main.class.getResource("img/archer.png").toString())), 0, 35, 20
        ,new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
    }



}
