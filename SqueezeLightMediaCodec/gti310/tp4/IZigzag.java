package gti310.tp4;

public class IZigzag {
	public int[][] getIZigZag(int[] bloc){
		int[][] zigZagBloc = new int[8][8];
		int i = 7,j = 7;
		for (int e= 63; e >= 0; e--){
			zigZagBloc[i][j] = bloc[e];
		}
		if ((i + j) % 2 == 0)
		{
			if (j >= 0)
				j--;
			else
				i-= 2;
			if (i < 7)
				i++;
		  	}
		else
		{
	  		if (i >= 0)
	  			i--;
	  		else
	  			j-= 2;
	  		if (j < 7)
	  			j++;
	  	}
		return zigZagBloc;
	}
}
