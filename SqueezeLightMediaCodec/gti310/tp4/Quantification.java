package gti310.tp4;

/**
 * Applique la quantification selon un facteur de qualité
 *
 */
public class Quantification {

	//Table de quantification Qy de la luminance
	private static final int[][] Qy = { { 16, 40, 40, 40, 40, 40, 51, 61 },
			{ 40, 40, 40, 40, 40, 58, 60, 55 },
			{ 40, 40, 40, 40, 40, 57, 69, 56 },
			{ 40, 40, 40, 40, 51, 87, 80, 62 },
			{ 40, 40, 40, 56, 68, 109, 103, 77 },
			{ 40, 40, 55, 64, 81, 104, 113, 92 },
			{ 49, 64, 78, 87, 103, 121, 120, 101 },
			{ 72, 92, 95, 98, 112, 100, 103, 95 }

	};

	//Table de quantification Qy de la chrominance Cb
	private static final int[][] QCb = { { 17, 40, 40, 95, 95, 95, 95, 95 },
			{ 40, 40, 40, 95, 95, 95, 95, 95 },
			{ 40, 40, 40, 95, 95, 95, 95, 95 },
			{ 40, 40, 95, 95, 95, 95, 95, 95 },
			{ 95, 95, 95, 95, 95, 95, 95, 95 },
			{ 95, 95, 95, 95, 95, 95, 95, 95 },
			{ 95, 95, 95, 95, 95, 95, 95, 95 },
			{ 95, 95, 95, 95, 95, 95, 95, 95 }

	};

	//Table de quantification Qy de la chrominance Cr
	private static final int[][] QCr = { { 17, 40, 40, 95, 95, 95, 95, 95 },
			{ 40, 40, 40, 95, 95, 95, 95, 95 },
			{ 40, 40, 40, 95, 95, 95, 95, 95 },
			{ 40, 40, 95, 95, 95, 95, 95, 95 },
			{ 95, 95, 95, 95, 95, 95, 95, 95 },
			{ 95, 95, 95, 95, 95, 95, 95, 95 },
			{ 95, 95, 95, 95, 95, 95, 95, 95 },
			{ 95, 95, 95, 95, 95, 95, 95, 95 }

	};

	/**
	 * Fonction qui applique la quantification
	 * @param blocEntree bloc 8*8 d'entrer a convertir
	 * @param matrice Matrice Y,Cb ou Cr
	 * @param fq Facteur de qualite
	 * @return
	 */
	public static int[][] appliquerQuantification(int[][] blocEntree,
			int matrice, int fq) {
		
		//On récupere la calcul d'alpha
		int alpha = calculAlpha(fq);

		// Nouvelle matrice
		int[][] newMatrice = new int[8][8];
		int u, v;

		// On parcours la nouvelle matrice
		for (u = 0; u < 8; u++) {
			for (v = 0; v < 8; v++) {

				if (matrice == Main.Y) {
					newMatrice[u][v] = (blocEntree[u][v])/(alpha*Qy[u][v]);
				}

				if (matrice == Main.Cb) {
					newMatrice[u][v] = (blocEntree[u][v])/(alpha*QCb[u][v]);
				}

				if (matrice == Main.Cr) {
					newMatrice[u][v] = (blocEntree[u][v])/(alpha*QCr[u][v]);
				}

			}

		}

		return newMatrice;

	}
	
	/**
	 * Calcul de alpha en fonction du facteur de qualite
	 * @param fq : Facteur de qualité
	 * @return
	 */
	private static int calculAlpha(int fq){
		
		if(1<fq){
			return 0;
		}
		
		else if(fq<51){
			return(50/fq);
		}
		
		else if(fq<100){
			return((200-2*fq)/100);
		}
		
		return 0;
		
	}
	
}
