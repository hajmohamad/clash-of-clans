package Model.Hero;

import com.example.clash.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class wizard extends Hero{
    public static wizard ar;
    public static wizard getHero(){
        if(ar==null){
            ar = new wizard();
            return ar;}
        return ar;}
    public wizard() {
        super( new ImageView(new Image(Main.class.getResource("img/wi/rn/wiz0.png").toString())), 0, 80, 40
                ,new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        buildingAllImg();
    }
    public   void buildingAllImg(){
        for(int i=0;i<8;i++){
            super.setRunningImg(new ImageView(new Image(Main.class.getResource("img/wi/rn/wiz"+i+".png").toString())));
            super.setFightingImg(new ImageView(new Image(Main.class.getResource("img/wi/fi/wiz"+i+".png").toString())));
            //super.setDeadImg(new ImageView(new Image(Main.class.getResource("img/wi/de/wiz"+i+".png").toString())));
        }}
}
