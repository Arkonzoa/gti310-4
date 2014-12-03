package gti310.tp4;

public class YCbCrToRGB {
	
	public static float[][][] convertir(int[][][] imageAConverir) {
		
		float[][][] newImage = new float[Main.COLOR_SPACE_SIZE][PPMReaderWriter.getM_height()][PPMReaderWriter.getM_width()];

		for(int i = 0; i < PPMReaderWriter.getM_height(); i++) {
			for(int j = 0; j < PPMReaderWriter.getM_width() ; j++) {
				newImage[Main.R][i][j] = (float) (1*imageAConverir[Main.Y][i][j])+(float) (0*imageAConverir[Main.R][i][j])+(float) (1.140*imageAConverir[Main.B][i][j]);
				newImage[Main.G][i][j] = (float) ((float) (1*imageAConverir[Main.Cb][i][j])+(float) (-0.395*imageAConverir[Main.R][i][j])+(float) (-0.581*imageAConverir[Main.B][i][j]));
				newImage[Main.B][i][j] = (float) ((float) (1*imageAConverir[Main.Cr][i][j])+(float) (2.032*imageAConverir[Main.R][i][j])+(float) (0*imageAConverir[Main.B][i][j]));
			}
		}
		
		return newImage;
		
		
	}

}
