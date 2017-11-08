import org.junit.*;
import static org.junit.Assert.*;

import image.Pixel;
import image.Image;
import image.color.GrayColor;

public class PixelTest
{
    @Test
    public void testColorDifference()
    {
        Pixel p1 = new Pixel(20);
        Pixel p2 = new Pixel(50);
        Pixel p3 = new Pixel(40);
        
        assertEquals(p1.colorDifference(p2), 30);
        assertEquals(p1.colorDifference(p3), 20);
        assertEquals(p2.colorDifference(p3), 10);
        assertEquals(p2.colorDifference(p3), p3.colorDifference(p2));
    }
    
    @Test
    public void testEquals()
    {
            Pixel p1 = new Pixel(10);
            Pixel p2 = new Pixel(20);
            Pixel p3 = new Pixel(10);
            Image i = new Image(1,1);
            
            assertFalse(p1.equals(p2));
            assertFalse(p1.equals(i));
            assertTrue(p1.equals(p3));
    }
    
    @Test
    public void testGetColor()
    {
        Pixel p1 = new Pixel(20);
        Pixel p2 = new Pixel(20);
        Pixel p3 = new Pixel(50);
        
        assertTrue(p1.getColor().equals(p2.getColor()));
        assertFalse(p1.getColor().equals(p3.getColor()));
    }
    
    @Test
    public void testSetColor()
    {
        Pixel p = new Pixel(20);
        assertTrue(p.getColor().getLevel() == 20);
        
        p.setColor(new GrayColor(30));
        
        assertTrue(p.getColor().getLevel() == 30);
    }


    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(PixelTest.class);
    }
}
