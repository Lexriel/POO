package image.color;

public class GrayColor {
    public static final int NB_GRAY_LEVELS = 256;
    public static final GrayColor BLANC = new GrayColor(255);
    public static final GrayColor NOIR = new GrayColor(0);
    
    private int level;
    
    public GrayColor(int color) {
        this.level = color;
    }

    public int getLevel() {
        return this.level;
    }

    
    public int[] toTabInt() {
        return new int[] {this.level, this.level, this.level };
    }
    
    public boolean equals(Object o) {
        if (o instanceof GrayColor) {
            GrayColor lAutre = (GrayColor) o;
            return this.level == lAutre.level;
        } else {
            return false;
        }
    }

    public int differenceWith(GrayColor color) {       
        return this.level - color.level ;
    }

}
