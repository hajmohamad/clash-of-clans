package Controller;

import Model.Admin;
import Model.Map;
import Model.Player;
import com.example.clash.Main;
import javafx.scene.image.ImageView;

import java.sql.*;
import java.util.ArrayList;

import static Controller.AdminController.reedMapFromDatabase;

public  class PlayerController {
    public static String addPlayer(String id, String passWord){
        try {
        if(playerIsInInDataBase(id)){
            return "id you chose is available in database ";
        }else{
            addPlayerToDatabase(id, passWord);
            Player player=new Player(id, passWord,0,0,0,new Map(id,new ArrayList<>(),new ImageView(Main.class.getResource("img/fireDB.png").toString()),new ArrayList<>(),new ArrayList<>()));

            AdminController.addPlayerToAdminArrayList(player);
            Player.setPlayer(player);
            return "your sighUp is successfully";
        }
        }catch (Exception ec){
            return ec.getMessage();
        }

    }
    public static void addLoginPlayerToStaticPlayer(String id){


    }
    public static Boolean loginPlayer(String id,String password)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/clashgame", "mohamadrahi", "MM647131mm");
            String sqlCom="select playerId,password FROM player";
            Statement s=connection.prepareStatement(sqlCom);
            ResultSet rs=s.executeQuery(sqlCom);
            while(rs.next())
            {
                if(rs.getString("playerId").equals(id)&&rs.getString("password").equals(password)){
                    return true;
                }
            }
            connection.close();
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }




    }
    public static void addPlayerToDatabase(String id,String passWord) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/clashgame", "mohamadrahi", "MM647131mm");
        String sqlCom="INSERT INTO player (playerId, password, level, winPlay, losePlay) VALUES ('"+id+"','"+passWord+"','"+0+"','"+0+"','"+0+"')";
        Statement statement=connection.prepareStatement(sqlCom);
        statement.execute(sqlCom);
        connection.close();
    }
    public static Player reedPlayerLogin(String id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/clashgame", "mohamadrahi", "MM647131mm");
            String sqlCom="SELECT `playerId`, `password`, `level`, `winPlay`, `losePlay` FROM `player` ";
            Statement s=connection.prepareStatement(sqlCom);
            ResultSet rs=s.executeQuery(sqlCom);
            while(rs.next())
            {if(rs.getString("playerId").equals(id)){
                return new Player(rs.getString("playerId"),rs.getString("password"),rs.getInt("level"),rs.getInt("winPlay"),rs.getInt("losePlay"),reedMapFromDatabase(rs.getString("playerId")));
            }}
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;


    }
    public static boolean playerIsInInDataBase(String id) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/clashgame", "mohamadrahi", "MM647131mm");
        String sqlCom="select playerId FROM player";
        Statement s=connection.prepareStatement(sqlCom);
        ResultSet rs=s.executeQuery(sqlCom);
        while(rs.next())
        {
            if(rs.getString("playerId").equals(id)){
                return true;
            }
        }
        connection.close();
        return false;

    }
}
