package image;

import image.color.GrayColor;

public class Pixel {  
    
    private GrayColor color;
    
    public Pixel(GrayColor color) {
        this.color = color;
    }

    public Pixel(int colorCode) {
        this.color = new GrayColor(colorCode);
    }
        
    public GrayColor getColor() {
        return this.color;
    }

    public void setColor(GrayColor color) {
        this.color = color;
    }

    public int colorDifference(Pixel pixel) {
        return Math.abs(this.color.differenceWith(pixel.color));
    }
    
    
    public boolean equals(Object o) {
        if (o instanceof Pixel) {
            Pixel lAutre = (Pixel) o;
            return this.color.equals(lAutre.color);
        } else {
            return false;
        }
    }
}
