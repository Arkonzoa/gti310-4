package gti310.tp4;

/**
 * The Main class is where the different functions are called to either encode a
 * PPM file to the Squeeze-Light format or to decode a Squeeze-Ligth image into
 * PPM format. It is the implementation of the simplified JPEG block diagrams.
 * 
 * @author Fran�ois Caron
 */
public class Main {

	/*
	 * The entire application assumes that the blocks are 8x8 squares.
	 */
	public static final int BLOCK_SIZE = 8;

	/*
	 * The number of dimensions in the color spaces.
	 */
	public static final int COLOR_SPACE_SIZE = 3;

	/*
	 * The RGB color space.
	 */
	public static final int R = 0;
	public static final int G = 1;
	public static final int B = 2;

	/*
	 * The YCbCr color space.
	 */
	public static final int Y = 0;
	public static final int Cb = 1;
	public static final int Cr = 2;

	/*
	 * The YUV color space.
	 */
	public static final int Yb = 0;
	public static final int U = 1;
	public static final int V = 2;

	/**
	 * The application's entry point.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Compteur pour la DCT
		int i, j, u, v;

		PPMReaderWriter ppm = new PPMReaderWriter();
		int[][][] newImage = ppm.readPPMFile(args[0]);
		newImage = RGBToYCbCr.convertir(newImage);
		int[][] arrY = new int[8][8];
		int[][] arrCb = new int[8][8];
		int[][] arrCr = new int[8][8];
		for (int spaceX = 0; spaceX < PPMReaderWriter.getM_height(); spaceX += 8) {
			for (int spaceY = 0; spaceY < PPMReaderWriter.getM_width(); spaceY += 8) {
				for (int x = spaceX; x < x + 8; x++) {
					for (int y = spaceY; y < y + 8; y++) {
						arrY[x][y] = newImage[Main.Y][x][y];

						arrCb[x][y] = newImage[Main.Cb][x][y];

						arrCr[x][y] = newImage[Main.Cr][x][y];
					}
				}
				arrY = DCT.convertirDCT(arrY);
				arrCb = DCT.convertirDCT(arrCb);
				arrCr = DCT.convertirDCT(arrCb);
			}

		}

		System.out.println("Squeeze Light Media Codec !");
	}
}
