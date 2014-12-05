package gti310.tp4;

/**
 * Convertie une image ppm RGB en YCbCr
 * 
 * @author David
 *
 */
public class RGBToYCbCr {

	public static int[][][] convertir(int[][][] imageAConverir) {

		int[][][] newImage = new int[Main.COLOR_SPACE_SIZE][PPMReaderWriter
				.getM_height()][PPMReaderWriter.getM_width()];

		for (int i = 0; i < PPMReaderWriter.getM_height(); i++) {
			for (int j = 0; j < PPMReaderWriter.getM_width(); j++) {
				newImage[Main.Y][i][j] =  (int) ( (0.299 * imageAConverir[Main.R][i][j])
						+  (0.587 * imageAConverir[Main.R][i][j])
						+  (0.114 * imageAConverir[Main.B][i][j]) + 0);
				newImage[Main.Cb][i][j] =   (int) ((-0.168736 * imageAConverir[Main.R][i][j])
						+  (-0.331264 * imageAConverir[Main.R][i][j])
						+ (0.5 * imageAConverir[Main.B][i][j]) + 0.5);
				newImage[Main.Cr][i][j] =  (int) ((0.5 * imageAConverir[Main.R][i][j])
						+  (-0.418688 * imageAConverir[Main.R][i][j])
						+ (-0.081312 * imageAConverir[Main.B][i][j]) + 0.5);
			}
		}

		return newImage;

	}

}
