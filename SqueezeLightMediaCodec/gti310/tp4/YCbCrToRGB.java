package gti310.tp4;

/**
 * Convertie une image ppm YCbCr en RGB
 *
 */
public class YCbCrToRGB {

	public static int[][][] convertir(int[][][] imageAConverir) {

		// Création du tableau 3D qui contien les 3 matrice de couleurs
		int[][][] newImage = new int[Main.COLOR_SPACE_SIZE][PPMReaderWriter
				.getM_height()][PPMReaderWriter.getM_width()];

		// Parcours de la matrice
		for (int i = 0; i < PPMReaderWriter.getM_height(); i++) {

			for (int j = 0; j < PPMReaderWriter.getM_width(); j++) {
				//Calcul pour la matrice R
				newImage[Main.R][i][j] = (int) ((1 * imageAConverir[Main.Y][i][j])
						+ (0 * imageAConverir[Main.R][i][j]) + (1.140 * imageAConverir[Main.B][i][j]));
				//Calcul pour la matrice G
				newImage[Main.G][i][j] = (int) ((1 * imageAConverir[Main.Cb][i][j])
						+ (-0.395 * imageAConverir[Main.R][i][j]) + (-0.581 * imageAConverir[Main.B][i][j]));
				//Calcul pour la matrice B
				newImage[Main.B][i][j] = (int) ((1 * imageAConverir[Main.Cr][i][j])
						+ (2.032 * imageAConverir[Main.R][i][j]) + (0 * imageAConverir[Main.B][i][j]));
			}
		}

		return newImage;

	}

}
