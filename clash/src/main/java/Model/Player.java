package Model;

import Model.Hero.*;

import java.util.ArrayList;

public class Player {
    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", passWord='" + passWord + '\'' +
                ", level=" + level +
                ", winPlay=" + winPlay +
                ", playerHero=" + playerHero +
                ", losePlay=" + losePlay +
                ", playerMap=" + playerMap +
                '}';
    }

    private static Player player;
    private static Player warPlayer;
    public static int buildingInMap;
    private String id;
    private String passWord;
    private int level;
    private int winPlay;
    private int money;

    private ArrayList<Hero> playerHero;
    private int losePlay;
    private Map playerMap;
    private ArrayList<String> heroName;
    public void decreaseHeroName(String STR){
        heroName.remove(STR);
    }

    public ArrayList<String> getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName.add(heroName);
    }

    public Player(String id, String passWord, int level, int winPlay, int losePlay, Map playerMap) {
        this.id = id;
        this.passWord = passWord;
        this.level = level;
        this.winPlay = winPlay;
        this.losePlay = losePlay;
        this.playerMap=playerMap;
        this.playerHero=new ArrayList<>();
        heroName=new ArrayList<>();
        if(level>=archer.getHero().getMinLevel()){
            this.playerHero.add(archer.getHero());
//            this.playerHero.add(archer.getHero());
//            this.playerHero.add(archer.getHero());
//            this.playerHero.add(archer.getHero());
//
//            heroName.add(archer.getHero().getHeroName());
//            heroName.add(archer.getHero().getHeroName());
//            heroName.add(archer.getHero().getHeroName());
            heroName.add(archer.getHero().getHeroName());

        }
        if(level>=barbarian.getHero().getMinLevel()){
            this.playerHero.add(barbarian.getHero());
            heroName.add(barbarian.getHero().getHeroName());

        }if(level>=Giant.getHero().getMinLevel()){
            this.playerHero.add(Giant.getHero());
//            this.playerHero.add(Giant.getHero());
//            this.playerHero.add(Giant.getHero());
//            this.playerHero.add(Giant.getHero());
//
//            heroName.add(Giant.getHero().getHeroName());
//            heroName.add(Giant.getHero().getHeroName());
//            heroName.add(Giant.getHero().getHeroName());
            heroName.add(Giant.getHero().getHeroName());


        }if(level>=wizard.getHero().getMinLevel()){

            this.playerHero.add(wizard.getHero());
//            this.playerHero.add(wizard.getHero());
//            this.playerHero.add(wizard.getHero());
//            this.playerHero.add(wizard.getHero());
//
//            heroName.add(wizard.getHero().getHeroName());
//            heroName.add(wizard.getHero().getHeroName());
//            heroName.add(wizard.getHero().getHeroName());
            heroName.add(wizard.getHero().getHeroName());


        }





    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Player.player = player;
    }

    public static Player getWarPlayer() {
        return warPlayer;
    }

    public static void setWarPlayer(Player warPlayer) {
        Player.warPlayer = warPlayer;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getWinPlay() {
        return winPlay;
    }

    public void setWinPlay(int winPlay) {
        this.winPlay = winPlay;
    }

    public int getLosePlay() {
        return losePlay;
    }

    public void setLosePlay(int losePlay) {
        this.losePlay = losePlay;
    }

    public Map getPlayerMap() {
        return playerMap;
    }

    public void setPlayerMap(Map playerMap) {
        this.playerMap = playerMap;
    }

    public ArrayList<Hero> getPlayerHero() {
        return playerHero;
    }

    public void setPlayerHero(Hero playerHero) {
        this.playerHero.add(playerHero);
    }

    public int getMoney() {
        return money;
    }
    public void decreasMoney(int money) {
        this.money -= money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
