package Model.Hero;

import com.example.clash.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class barbarian extends Hero{
    public static barbarian ar;
    public static barbarian getHero(){
        if(ar==null){
            ar = new barbarian();
            return ar;}
        return ar;}
    public barbarian() {
        super( new ImageView(new Image(Main.class.getResource("img/kn/rn/Knight0.png").toString())), 0, 40, 10
                ,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),"barbarian");
        buildingAllImg();
        super.setHeroName("barbarian");


    }
    public void buildingAllImg(){
        for(int i=0;i<8;i++){
            super.setRunningImg(new ImageView(new Image(Main.class.getResource("img/kn/rn/Knight"+i+".png").toString())));
            super.setFightingImg(new ImageView(new Image(Main.class.getResource("img/kn/fi/Knight"+i+".png").toString())));
//            super.setDeadImg(new ImageView(new Image(Main.class.getResource("img/kn/de/Knight"+i+".png").toString())));
        }
    }
}
