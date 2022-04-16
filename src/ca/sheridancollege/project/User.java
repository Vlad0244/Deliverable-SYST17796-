package ca.sheridancollege.project;

/**
 * The User class that contains how the user will stay or how the user's hand is shown.
 *
 * @author Volodymyr Suprun April 2022
 * @author Adarshpreet Singh April 2022
 * @author Maryam Khatibzadeh Azad April 2022
 */
public class User extends Player {

    public User(String name) {
        super(name);
    }

    @Override
    public void stay() {
        this.continueToPlayRound = false;
    }
    
    @Override
    public void showHand() {
        System.out.println("Your Hand is: ");
        String yourHand = "";
        for (Card card : this.hand) {
            yourHand += card.toString() + "\n";
        }
        System.out.println(yourHand);
    }
}
