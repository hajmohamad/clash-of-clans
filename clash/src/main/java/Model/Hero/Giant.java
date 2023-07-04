package Model.Hero;

import com.example.clash.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Giant extends Hero{
    public static Giant ar;
    public static Giant getHero(){
        if(ar==null){
            ar = new Giant();
            return ar;}
        return ar;}
    public Giant() {
        super( new ImageView(new Image(Main.class.getResource("img/gi/fi/Troll_02_1_ATTACK_000.png").toString())), 3, 60, 30
                ,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),"Giant");
        super.setHeroName("Giant");
        buildingAllImg();

    }
    public void buildingAllImg(){
        for(int i=0;i<8;i++){
            super.setRunningImg(new ImageView(new Image(Main.class.getResource("img/gi/rn/Troll_02_1_RUN_00"+i+".png").toString())));
            super.setFightingImg(new ImageView(new Image(Main.class.getResource("img/gi/fi/Troll_02_1_ATTACK_00"+i+".png").toString())));
//            super.setDeadImg(new ImageView(new Image(Main.class.getResource("img/kn/de/Knight"+i+".png").toString())));
        }
}}
