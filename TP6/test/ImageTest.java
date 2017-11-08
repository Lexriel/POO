import org.junit.*;
import static org.junit.Assert.*;

import image.*;
import image.color.GrayColor;

public class ImageTest
{
    @Test
    public void testChangeColorPixel()
    {
        Image i = new Image(100, 100);
        GrayColor g = new GrayColor(20);
        
        i.changeColorPixel(10, 13, g);
        i.changeColorPixel(20, 23, 20);
        
        assertEquals(i.getPixel(10, 13).getColor().getLevel(), 20);
        assertEquals(i.getPixel(20,23).getColor().getLevel(), 20);
        assertEquals(i.getPixel(20,23).getColor().getLevel(), i.getPixel(10, 13).getColor().getLevel());
    }
    
    @Test
    public void testGetHeight_testGetWidth()
    {
        Image i1 = new Image(22,25);
        Image i2 = new Image(50,25);
        
        assertTrue(i1.getHeight() == i2.getHeight());
        assertFalse(i1.getHeight() == i2.getWidth());
        assertEquals(i1.getWidth(), 22);
        assertEquals(i2.getWidth(), 50);
        
    }
    
    @Test
    public void testGetPixel_testSetPixel()
    {
        Image i = new Image(120, 100);
        Pixel p = new Pixel(20);
        
        i.setPixel(2, 5, p);
        
        assertSame(i.getPixel(2, 5), p);
    }
    
    @Test
    public void testEdge()
    {
        Image i = new Image(100, 200);
        
        for(int y = 30 ; y < 61 ; y++){
            for(int x = 10 ; x < 31 ; x++){
                i.changeColorPixel(x, y, GrayColor.NOIR);
            }
        }
        
        Image i2 = i.edge(10);
        
        assertTrue(i2.getPixel(12, 29).getColor().getLevel() == GrayColor.NOIR.getLevel());
        assertFalse(i2.getPixel(1, 1).getColor().getLevel() == GrayColor.NOIR.getLevel());
        

        
    }
    
    @Test
    public void testDescreaseLevel()
    {
        Image i = new Image(100, 200);
        
        for(int y = 30 ; y < 61 ; y++){
            for(int x = 10 ; x < 31 ; x++){
                i.changeColorPixel(x, y, GrayColor.NOIR);
            }
        }
        for(int y = 50 ; y < 101 ; y++){
            for(int x = 50 ; x < 71 ; x++){
                i.changeColorPixel(x, y, new GrayColor(64));
            }
        }        
        for(int y = 110 ; y < 161 ; y++){
            for(int x = 20 ; x < 41 ; x++){
                i.changeColorPixel(x, y, new GrayColor(230));
            }
        }    
        
        Image i2 = i.decreaseGrayLevels(1);
        
        assertTrue(i2.getPixel(12, 31).getColor().getLevel() == GrayColor.NOIR.getLevel());
        assertTrue(i2.getPixel(52, 52).getColor().getLevel() == GrayColor.NOIR.getLevel());
        assertTrue(i2.getPixel(23, 113).getColor().getLevel() == GrayColor.NOIR.getLevel());
        // assertFalse(i2.getPixel(3, 3).getColor().getLevel() == GrayColor.NOIR.getLevel());

    }
    
    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(ImageTest.class);
    }    
}
