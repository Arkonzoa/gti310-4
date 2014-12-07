package gti310.tp4;

/**
 * Class to convert a 2D array into a 1D array with zigzaging
 *
 */
public class Zigzag {
	public int[] getZigZag(int[][] bloc){
		int[] zigZagBloc = new int[64];
		int i = 1,j = 1;
		
		//iterate until end of array reached (64 times in a bloc of 8x8)
		for (int e= 0; e < 64; e++){
			zigZagBloc[e] = bloc[i-1][j-1];
			//Check the remainder of the sum of the current cursor location
			if ((i + j) % 2 == 0)
			{
				if (j < 8)
					//Move the cursor to the right
					j++;
	
				if (i > 1)
					//Move the cursor up
					i--;
			  	}
			else
			{
		  		if (i < 8)
		  		//Move cursor down if not at border
		  			i++;
	
		  		if (j > 1)
		  		//Move cursor right if it is not at the border of the array
		  			j--;
		  	}
		}
		return zigZagBloc;
	}
}
