import org.junit.*;
import static org.junit.Assert.*;

import image.color.GrayColor;

public class GrayColorTest
{
    @Test
    public void testEquals()
    {
        GrayColor g1 = new GrayColor(21);
        GrayColor g2 = new GrayColor(81);
        GrayColor g3 = new GrayColor(21);
        
        assertFalse(g1.equals(g2));
        assertFalse(g3.equals(g2));
        assertFalse(g3.equals("21"));
        assertTrue(g3.equals(g1));
    }
    
    @Test
    public void testGetLevel()
    {
        GrayColor g1 = new GrayColor(21);
        GrayColor g2 = new GrayColor(81);
        
        assertFalse(g1.getLevel() == g2.getLevel());
        assertTrue(g1.getLevel() == 21);
        assertTrue(g2.getLevel() == 81);
    }
    
    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(GrayColorTest.class);
    }    
    
}
