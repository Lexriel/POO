package image;

/**
 * Basic interface for images based on a rectangular area of pixels
 */
public interface ImageInterface {

	/** returns width of the image
	 * @return width of the image
	 */
	public int getWidth();

	/** returns height of the image
	 * @return height of the image
	 */
	public int getHeight();

	/** gets pixel at coord (i,j) of this image. (0,0) is top left corner pixel.
	 * @param i the horizontal coordinate
	 * @param j the vertical coordinate
	 * @return pixel at coord i,j of this image. (0,0) is top left corner pixel.
	 * @exception UnknownPixelException if pixel of coord (i,j) does not exist
	 */
	public Pixel getPixel(int i, int j) throws UnknownPixelException;

    /** sets pixel at coord (i,j) of this image. (0,0) is top left corner pixel.
	 * @param i the horizontal coordinate
	 * @param j the vertical coordinate
     * @param pixel the new pixel
 	 * @exception UnknownPixelException if pixel of coord (i,j) does not exist
     */
    public void setPixel(int i, int j, Pixel pixel) throws UnknownPixelException;
}
