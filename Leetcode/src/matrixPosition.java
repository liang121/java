import java.util.*;
/*
 * Given an NxN matrix with unique integers : Find and print positions 
 * of all numbers such that it is the biggest in its row and also the 
 * smallest in its column . e.g. : In 3 x 3 with elements 
 * 1 2 3 
 * 4 5 6 
 * 7 8 9 
 * the number is 3 and position (1,3)
 */

public class matrixPosition{
	// only need to traverse the map twice 
	public static void main(String[] args){
		int[][] matrix = {
			{1, 2, 3}, 
			{4, 5, 6},
			{7, 8, 9} 	
		};
		find(matrix);
	}

	public static List<Integer> find(int[][] board){
		List<Integer> res = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<board.length;i++){
			int max = board[i][0];
			int x=i;
			int y=0;
			for(int j=0;j<board[0].length;j++){
				if(board[i][j]  > max){
					max = board[i][j];
					x=i;y=j;
				}
			}
			map.put(x,y);
		}
		for(int j=0;j<board[0].length;j++){
			int min = board[0][j];
			int x=0;
			int y=j;
			for(int i=0;i<board.length;i++){
				if(board[i][j]<min){
					min = board[i][j];
					x=i;y=j;
				}
			}
			if(map.containsKey(x)){
				if(map.get(x)==y){
					res.add(board[x][y]);
				}
			}
		}
		System.out.println(res);
		return res;
	}
}
