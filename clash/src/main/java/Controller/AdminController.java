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
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/chatroomv1", "mohamadrahi98", "MM647131mm");
            String sqlCom="SELECT `playerId`, `password`, `level`, `winPlay`, `losePlay`, `playerMap` FROM `player` ";
            Statement s=connection.prepareStatement(sqlCom);
            ResultSet rs=s.executeQuery(sqlCom);
            while(rs.next())
            {
               AdminController.addPlayerToAdminArrayList(new Player(rs.getString("playerId"),rs.getString("password"),rs.getInt("level"),rs.getInt("winPlay"),rs.getInt("losePlay"),reedMapFromDatabase(rs.getString("playerId"))));
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
            ArrayList<Building> buildings=new ArrayList<>();
            ArrayList<Integer> x=new ArrayList<>();
            ArrayList<Integer> y=new ArrayList<>();
            while(rs.next()) {
                if (rs.getString("playerId").equals(playerId)) {
                    backGround = rs.getString("MapBackGround");
                    if ("ArcherDB".equals(rs.getString("MapBuilding"))) {
                        buildings.add(new ArcherDB());
                    }
                 else if ("FireDB".equals(rs.getString("MapBuilding"))) {
                    buildings.add(new FireDB());
                } else if ("HouseOfKing".equals(rs.getString("MapBuilding"))) {
                    buildings.add(new HouseOfKing());
                } else if ("HouseOfKing".equals(rs.getString("MapBuilding"))) {
                    buildings.add(new HouseOfKing());
                }
                else if ("MortarDB".equals(rs.getString("MapBuilding"))) {
                    buildings.add(new MortarDB());
                }
                else if ("WallNb".equals(rs.getString("MapBuilding"))) {
                    buildings.add(new WallNb());
                }y.add(rs.getInt("yPosition"));
                    x.add(rs.getInt("xPosition"));
                }
            }
            return new Map(playerId,buildings, new ImageView(new Image(Main.class.getResource(backGround).toString())),x,y);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

}
}
