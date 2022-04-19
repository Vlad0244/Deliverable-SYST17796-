package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Volodymyr Suprun April 2022
 * @author Adarshpreet Singh April 2022
 * @author Maryam Khatibzadeh Azad April 2022
 */
public abstract class Game {
    
    //The game continuing is decided by userPlaying being true
    protected boolean userPlaying = true;
    private final String name;//the title of the game
    protected ArrayList<Player> players;// the players of the game

    public Game(String name) {
        this.name = name;
        players = new ArrayList();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    
    //setter for userPlaying 
    public void setUserPlaying(boolean bool) {
        this.userPlaying = bool;
    }

    //setter for userPlaying 
    public boolean getUserPlaying() {
        return this.userPlaying;
    }
    /**
     * Play the game. This might be one method or many method calls depending on your game.
     */
    public abstract void play();
        
    /**
     * When the game is over, use this method to declare and display a winning player.
     */
    public abstract void declareWinner();

}//end class
