package gti310.tp4;

public class DIDCT{
	
	/**
	 * Classe qui va appliquer la IDCT 
	 * @param matriceEntree
	 * @return
	 */
	public static int[][] convertirIDCT(int[][] matriceEntree) {

		//Nouvelle matrice
		int[][] newMatrice = new int[8][8];
		int i,j,u,v;
		
		int total =0;
	
		//On parcours la nouvelle matrice
		for(u=0; u<8;u++){
			for(v=0; v<8;v++){
				
				
				for(i=0; i<8;i++){
					for(j=0; j<8;j++){
						
						//Calcul de la DCT
						total += ((checkValue(u)*checkValue(v))/4) * Math.cos(((2*i+1)*u*Math.PI)/16)*Math.cos(((2*j+1)*v*Math.PI)/16);
					}
				}
			}
			
			//Assignation dans la nouvelle matrice
			newMatrice[u][v]=total;
		}
		

		return newMatrice;

	}
	
	/**
	 * Méthode qui permet de calculer C(u) et C(v) rapidemment
	 * @param a
	 * @return
	 */
	private static int checkValue(int a){
		
		if(a==0){
			return (int) (1/(Math.sqrt(2)));
		}
		else
			return 1;
		
	}
	
	
	
	


}
