
package ca.sheridancollege.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Maryam
 */
public class DealerTest {
    
    public DealerTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }

    /**
     * Test of stay method, of class Dealer.
     */
    @Test
    public void testStay() {
        System.out.println("stay");
        Dealer instance = null;
        instance.stay();
    }

    /**
     * Test of showHand method, of class Dealer.
     */
    @Test
    public void testShowHand() {
        System.out.println("showHand");
        Dealer instance = null;
        instance.showHand();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
