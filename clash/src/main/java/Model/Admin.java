package Model;

import Model.Building.Building;
import Model.Hero.Hero;

import java.util.ArrayList;

public class Admin {
    private static Admin admin;
    private ArrayList<Player> players;
    private ArrayList<Building> buildings;
    private ArrayList<Hero> heroes;
    public Admin() {
        this.players = new ArrayList<>();
        this.buildings = new ArrayList<>();
        this.heroes = new ArrayList<>();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Player players) {
        this.players.add(players);
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }


    public static Admin addAdmin() {
        if(admin==null){
            admin = new Admin();
            return admin;}
        return admin;
    }
    public static  Admin getAdmin(){return admin;}


}
