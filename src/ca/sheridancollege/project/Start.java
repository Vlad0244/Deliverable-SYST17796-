package ca.sheridancollege.project;

/**
 * The class that starts the blackjack game.
 *
 * @author Volodymyr Suprun April 2022
 * @author Adarshpreet Singh April 2022
 * @author Maryam Khatibzadeh Azad April 2022
 */
public class Start {
    public static void main(String[] args) {
        Blackjack blackjack = new Blackjack("blackjack");
        blackjack.play();
    }

    
}
