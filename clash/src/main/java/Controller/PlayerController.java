package Controller;

import Model.Building.Building;
import Model.Map;
import Model.Player;
import com.example.clash.Main;
import javafx.scene.image.ImageView;

import java.sql.*;
import java.util.ArrayList;

import static Controller.AdminController.reedMapFromDatabase;

public  class PlayerController {
    public static void addLoserToDataBase(Player loser)  {
        try{
        loser.setLosePlay(loser.getLosePlay()+1);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/clashgame", "mohamadrahi", "MM647131mm");
        String sqlCom="UPDATE `player` SET `losePlay`='"+ loser.getLosePlay()+"' WHERE `playerId`='"+loser.getId()+"';";
        Statement statement=connection.prepareStatement(sqlCom);
        statement.execute(sqlCom);
        connection.close();}catch (Exception Z){}

    }
    public static void addWinerToDataBase(Player Winer){
        try{
            Winer.setWinPlay(Winer.getWinPlay()+1);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/clashgame", "mohamadrahi", "MM647131mm");
        String sqlCom="UPDATE `player` SET  `money`='"+ ((Player.getWarPlayer().getLevel()*100)+Winer.getMoney())+"' , `winPlay`='"+ Winer.getWinPlay()+"' WHERE `playerId`='"+Winer.getId()+"';";
        Statement statement=connection.prepareStatement(sqlCom);
        statement.execute(sqlCom);
        connection.close();}catch (Exception Z){}


    }
    public static String addPlayer(String id, String passWord){
        try {
        if(playerIsInInDataBase(id)){
            return "id you chose is available in database ";
        }else{
            addPlayerToDatabase(id, passWord);
            Player player=new Player(id, passWord,0, 0,0,new Map(id,new ArrayList<>(),new ImageView(Main.class.getResource("img/fireDB.png").toString()),new ArrayList<>(),new ArrayList<>()));
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

        String sqlCom2="INSERT INTO `map`(`playerId`, `MapBackGround`, `MapBuilding`, `xPosition`, `yPosition`) VALUES ('"+id+"','"+"img/map2.jpg"+"','none','0','0')";
        Statement statement2=connection.prepareStatement(sqlCom2);
        statement.execute(sqlCom2);
        connection.close();

    }
    public static Player reedPlayerLogin(String id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/clashgame", "mohamadrahi", "MM647131mm");
            String sqlCom="SELECT `playerId`, `password`, `level`,`money`, `winPlay`, `losePlay` FROM `player` ";
            Statement s=connection.prepareStatement(sqlCom);
            ResultSet rs=s.executeQuery(sqlCom);
            while(rs.next())
            {if(rs.getString("playerId").equals(id)){
                Player player= new Player(rs.getString("playerId"),rs.getString("password"),rs.getInt("level"), rs.getInt("winPlay"),rs.getInt("losePlay"),reedMapFromDatabase(rs.getString("playerId")));
                player.setMoney(rs.getInt("money"));
                return player;
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
    public static void deleteBuildingOnDataBase(){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/clashgame", "mohamadrahi", "MM647131mm");

                String sqlCom=String.format("DELETE FROM `map` WHERE `playerId`='%s'",Player.getPlayer().getId());
            System.out.println(sqlCom);
                Statement statement=connection.prepareStatement(sqlCom);
                statement.execute(sqlCom);
            connection.close();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static void setBuildingToDataBase() {
        try {
            deleteBuildingOnDataBase();
            Player.getPlayer().getPlayerMap().delteRow1();
            Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/clashgame", "mohamadrahi", "MM647131mm");

        for(Building building:Player.getPlayer().getPlayerMap().getMapBuilding()){
        String sqlCom=String.format("INSERT INTO `map`(`playerId`, `MapBackGround`, `MapBuilding`, `xPosition`, `yPosition`) VALUES ('%s','%s','%s','%s','%s')",
                Player.getPlayer().getId(),Player.getPlayer().getPlayerMap().getLinkBackGround(),
                building.getClassName(),
                Player.getPlayer().getPlayerMap().getxPosition().get(Player.getPlayer().getPlayerMap().getMapBuilding().indexOf(building)),
                Player.getPlayer().getPlayerMap().getyPosition().get(Player.getPlayer().getPlayerMap().getMapBuilding().indexOf(building)));
        Statement statement=connection.prepareStatement(sqlCom);
            System.out.println(sqlCom);
        statement.execute(sqlCom);}
        connection.close();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
