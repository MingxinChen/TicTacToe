package Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChessWin {
	Integer[][] intArray = new Integer[][]{
		{1, 2, 3}, 
		{4, 5, 6}, 
		{7, 8, 9}, 
		{1, 4, 7}, 
		{2, 5, 8}, 
		{3, 6, 9}, 
		{1, 5, 9}, 
		{3, 5, 7}
	};
	List<List<Integer>> chesswin;
	
	public ChessWin() {
		chesswin = new ArrayList();
		for(int i = 0 ; i < 8 ; i++) {
			List<Integer> temp = Arrays.asList(intArray[i]);
			chesswin.add(temp);
		}
	}
	
	public List<List<Integer>> returnChessWin() {
		return chesswin;
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChessWin a = new ChessWin();
		List<List<Integer>> b = a.returnChessWin();
		
		List<Integer> c = Arrays.asList(8, 2, 3, 1);
		
		for(int i = 0 ; i < 8 ; i++) {
			if(c.containsAll(b.get(i))) {
				System.out.println("win");
			}
			else {
				System.out.println("fail");
			}
		}
	}*/
}
