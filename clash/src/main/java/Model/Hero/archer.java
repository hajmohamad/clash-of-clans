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
        super( new ImageView(new Image(Main.class.getResource("img/ar/fi/Elf_01__ATTACK_000.png").toString())), 2, 50, 20
        ,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),"archer");
        super.setHeroName("archer");
        buildingAllImg();
    }
    public void buildingAllImg(){
        for(int i=0;i<8;i++){
            super.setRunningImg(new ImageView(new Image(Main.class.getResource("img/ar/rn/Elf_01__RUN_00"+i+".png").toString())));
            super.setFightingImg(new ImageView(new Image(Main.class.getResource("img/ar/fi/Elf_01__ATTACK_00"+i+".png").toString())));
//            super.setDeadImg(new ImageView(new Image(Main.class.getResource("img/kn/de/Knight"+i+".png").toString())));
        }
    }



}
