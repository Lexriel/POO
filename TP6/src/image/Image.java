package image;

import image.color.GrayColor;

import java.util.Scanner;

public class Image implements ImageInterface {

    // NB:not necessary because of array of pixels
    private int width;
    private int height;

    private Pixel[][] pixels;

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new Pixel[this.width][this.height];
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                this.pixels[i][j] = new Pixel(GrayColor.BLANC);
            }
        }
    }

    /** the pixel at given coordinates
     * @param i x coordinate of pixel
     * @param j y coordinate of pixel
     * @return the pixel at coordinates (i,j)
     * @throws UnknownPixelException if given coordinates are not valid for this image 
     */
    public Pixel getPixel(int i, int j) throws UnknownPixelException{
        try {
            return this.pixels[i][j];
        }
        catch(ArrayIndexOutOfBoundsException e) {
            throw new UnknownPixelException();
        }
    }

    public void setPixel(int i, int j, Pixel pixel) {
        this.pixels[i][j] = pixel;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void changeColorPixel(int i, int j, int colorCode) {
        this.pixels[i][j].setColor(new GrayColor(colorCode));
    }

    public void changeColorPixel(int i, int j, GrayColor color) {
        this.pixels[i][j].setColor(color);
    }

    public Image edge(int threshold) {
        Image result = new Image(this.width, this.height);
        Pixel px;
        Pixel px_dx;
        Pixel px_dy;
        for (int i = 0; i < this.width - 1; i++) {
            for (int j = 0; j < this.height - 1; j++) {
                px = this.getPixel(i, j);
                px_dx = this.getPixel(i + 1, j);
                px_dy = this.getPixel(i, j + 1);
                if ((px.colorDifference(px_dx) > threshold) || (px.colorDifference(px_dy) > threshold)) {
                    result.changeColorPixel(i, j, GrayColor.NOIR);
                } else {
                    result.changeColorPixel(i, j, GrayColor.BLANC);
                }
            }
        }
        return result;
    }
    
    public Image decreaseGrayLevels(int nbGrayLevels) {
        Image result = new Image(this.width, this.height);
        int factor = GrayColor.NB_GRAY_LEVELS / nbGrayLevels;
        Pixel px;
        for (int i = 0; i < this.width - 1; i++) {
            for (int j = 0; j < this.height - 1; j++) {
                px = this.getPixel(i, j);
                result.changeColorPixel(i, j, (factor) * (px.getColor().getLevel() / factor));
            }
        }
        return result;
    }

    // ======================================================================
    /** Reads
     *  a PGM image from file.
     * It is assumed that file respect the following PGM file syntax:
     *  <ul><li> first line with string "P2"</li>
     *  <li>second line : a comment</li> 
     *  <li>one int for width <code>w</code>, one int for height<code>h</code></li>
     *  <li>one int for max gray level (not used here, we consider this level to be 255 in our images)</li>
     *  <li><code>w</code> x <code>h</code> integers between 0 and max (for us =255) for each pixel</li></ul>
     *  
     *  @param fileName the name of the file with the image
     */
    public static Image initImagePGM(String fileName) {
        Scanner scan = new Scanner(Image.class.getResourceAsStream(fileName));

        scan.nextLine(); // line P2
        scan.nextLine(); // line comment
        // read width
        int width = scan.nextInt();
        // read height        
        int height = scan.nextInt();
        // read max gray level (not used)
        scan.nextInt(); 
        // create an initially white image
        Image result = new Image(width, height); 
        // rad pixels
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                result.changeColorPixel(y, x, scan.nextInt());
            }
        }
        return result;
    }

}
