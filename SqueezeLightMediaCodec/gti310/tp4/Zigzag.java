package gti310.tp4;

public class Zigzag {
	public int[] getZigZag(int[][] bloc){
		int[] zigZagBloc = new int[64];
		int i = 1,j = 1;
		for (int e= 0; e < 64; e++){
			zigZagBloc[e] = bloc[i-1][j-1];
		}
		if ((i + j) % 2 == 0)
		{
			if (j < 8)
				j++;
			else
				i+= 2;
			if (i > 1)
				i--;
		  	}
		else
		{
	  		if (i < 8)
	  			i++;
	  		else
	  			j+= 2;
	  		if (j > 1)
	  			j--;
	  	}
		return zigZagBloc;
	}
}
