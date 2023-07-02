package Controller;

import Model.Admin;
import Model.Building.*;
import Model.Map;
import Model.Player;
import com.example.clash.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminController {
    public static void reedFromDataBase(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/clashgame", "mohamadrahi", "MM647131mm");
            String sqlCom="SELECT `playerId`, `password`, `level`, `winPlay`, `losePlay` FROM `player` ";
            Statement s=connection.prepareStatement(sqlCom);
            ResultSet rs=s.executeQuery(sqlCom);
            while(rs.next()) {
                if (!Admin.getAdmin().getPlayersUserName().contains(rs.getString("playerId"))){
                    AdminController.addPlayerToAdminArrayList(new Player(rs.getString("playerId"), rs.getString("password"), rs.getInt("level"), rs.getInt("winPlay"), rs.getInt("losePlay"), reedMapFromDatabase(rs.getString("playerId"))));
                    Admin.getAdmin().setPlayersUserName(rs.getString("playerId"));
                }
            }
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static void addPlayerToAdminArrayList(Player player){
        Admin.getAdmin().setPlayers(player);
    }
    public static Map reedMapFromDatabase(String playerId){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/clashgame", "mohamadrahi", "MM647131mm");
            String sqlCom="SELECT `playerId`, `MapBackGround`, `MapBuilding`, `xPosition`, `yPosition` FROM `map` ";
            Statement s=connection.prepareStatement(sqlCom);
            ResultSet rs=s.executeQuery(sqlCom);
            String backGround = new String();
            backGround=Main.class.getResource("img/noneMap.jpg").toString();
            ArrayList<Building> buildings=new ArrayList<>();
            ArrayList<Double> x=new ArrayList<>();
            ArrayList<Double> y=new ArrayList<>();
            while(rs.next()) {
                if (rs.getString("playerId").equals(playerId)) {
                    backGround = rs.getString("MapBackGround");
                    if ("ArcherDB".equals(rs.getString("MapBuilding"))) {
                        buildings.add(ArcherDB.getArcherDb());
                    }
                 else if ("FireDB".equals(rs.getString("MapBuilding"))) {
                    buildings.add(FireDB.getArcherDb());
                } else if ("HouseOfKing".equals(rs.getString("MapBuilding"))) {
                    buildings.add(HouseOfKing.getArcherDb());
                }
                else if ("MortarDB".equals(rs.getString("MapBuilding"))) {
                    buildings.add(MortarDB.getArcherDb());
                }
                else if ("WallNb".equals(rs.getString("MapBuilding"))) {
                    buildings.add(new WallNb());
                }else{
                        buildings.add(none.getArcherDb());
                    }
                    x.add(rs.getDouble("xPosition"));
                y.add(rs.getDouble("yPosition"));

                }
            }
            Map map=new Map(playerId,buildings, new ImageView(new Image(Main.class.getResource(backGround).toString())),x,y);
            map.setLinkBackGround(backGround);
            return map;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

}

}
