import java.util.*;
/*
 * Given a M * N matrix, if the element in the matrix is larger than other 8 elements who stay around it,
 *  then named thatelement be mountain point. Print all the mountain points.
 */
public class mountainPoint{
	public static void main(String[] args){
		int[][] matrix2 = {
		{1, 1, 2, 3, 1}, 
		{1, 9, 8, 9, 5},
		{1, 1, 4, 1, 6}
        };
		System.out.println(find(matrix2).toString());
		
	}
	public static ArrayList<Integer> find(int[][] matrix2){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(matrix2.length<=1||matrix2[0].length<=1) return result;
		for(int i=1;i<matrix2.length-1;i++){
			for(int j=1;j<matrix2[0].length-1;j++){
				if(matrix2[i][j]>matrix2[i-1][j]&&matrix2[i][j]>matrix2[i+1][j]&&matrix2[i][j]>matrix2[i][j-1]&&matrix2[i][j]>matrix2[i][j+1]&&matrix2[i][j]>matrix2[i-1][j+1]&&matrix2[i][j]>matrix2[i-1][j-1]&&matrix2[i][j]>matrix2[i+1][j-1]&&matrix2[i][j]>matrix2[i+1][j+1]){
					result.add(matrix2[i][j]);
				}
			}
		}
		return result;
	}
//	public static void main(String[] args){
//		int[][] matrix2 = {
//				{1, 1, 2, 3, 1}, 
//				{1, 9, 8, 9, 5},
//				{1, 1, 4, 1, 6}
//		};
//		find(matrix2);
//	}
//
//	public static void find(int[][] board){
//		int m = board.length, n = board[0].length;
//		List<Integer> res = new ArrayList<Integer>();
//		if(m<3 || n<3){
//			return;
//		}
//		for(int i=1;i<board.length-1;i++){
//			for(int j=1;j<board[0].length-1;j++){
//				if(isMountain(board,i,j)){
//					res.add(board[i][j]);
//				}
//			}
//		}
//		System.out.println(res);
//	}
//
//	public static boolean isMountain(int[][] board, int i, int j){
//		int curr = board[i][j];
//		if(curr > board[i-1][j] && curr > board[i-1][j-1] && curr > board[i-1][j+1]
//			&& curr > board[i][j-1] && curr > board[i][j+1] && curr > board[i+1][j-1]
//			&& curr > board[i+1][j] && curr > board[i+1][j+1]){
//			return true;
//		}
//		return false;
//	}
}