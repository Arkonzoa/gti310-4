package gti310.tp4;
/**
 * Class to convert a 1D array into a 2D array with reverse zigzag
 * @author Phil
 *
 */
public class IZigzag {
	public int[][] getIZigZag(int[] bloc){
		int[][] zigZagBloc = new int[8][8];
		int i = 7,j = 7;
		for (int e= 63; e >= 0; e--){
			zigZagBloc[i][j] = bloc[e];
			//Check the remainder of the sum of the current cursor location
			if ((i + j) % 2 == 0)
			{
				if (j >= 0)
					//Move the cursor to the left
					j--;

				if (i < 7)
					//Move the cursor downwards
					i++;
			  	}
			else
			{
		  		if (i >= 0)
		  			//Move cursor up if not at border
		  			i--;

		  		if (j < 7)
		  			//Move cursor left if it is not at the border of the array
		  			j++;
		  	}
		}
		
		return zigZagBloc;
	}
}
