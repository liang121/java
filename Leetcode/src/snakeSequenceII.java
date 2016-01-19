import java.net.PasswordAuthentication;
import java.util.ArrayList;

public class snakeSequenceII{
	public static int max;
	public static ArrayList<ArrayList<Integer>> res;
	public static void main(String[] args){
        int[][] arr1 = {
                { 1, 2, 3,  6, 8},
                { 2, 5, 4, 11, 10},
                { 1, 6, 7,  8, 9}
        };
        int[][] arr2 = {
                {1, 1, 2, 3, 1},
                {1, 1, 3, 4, 5},
                {1, 1, 4, 3, 3 }
        };
        getSequence(arr1);
       
	}
	public static void getSequence(int[][] matrix){
		res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path;
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				path = new ArrayList<Integer>();
				dfs(i,j,matrix,0,path);
			}
		}
		System.out.println(res.toString()+" "+(max+1));
	}
	public static void dfs(int row,int col,int[][] matrix,int lmax,ArrayList<Integer> path){
		path.add(matrix[row][col]);
		if(lmax>=max){
			if(lmax>max){
				res.clear();
				max = lmax;
			}
			res.add(new ArrayList<Integer>(path));
		}
		int temp = matrix[row][col];
		matrix[row][col] = Integer.MAX_VALUE;
                                                                         //////////////////////////////////
		if(row+1<matrix.length&&matrix[row+1][col]!=Integer.MAX_VALUE&&matrix[row+1][col]==temp+1){////////
			                                                               ////////////////////////////////
			dfs(row+1, col, matrix, lmax+1, path);
		}
		if(row-1>=0&&matrix[row-1][col]!=Integer.MAX_VALUE&&matrix[row-1][col]==temp+1){
			dfs(row-1, col, matrix, lmax+1, path);
		}
		if(col+1<matrix[0].length&&matrix[row][col+1]!=Integer.MAX_VALUE&&matrix[row][col+1]==temp+1){
			dfs(row, col+1, matrix, lmax+1, path);
		}
		if(col-1>=0&&matrix[row][col-1]!=Integer.MAX_VALUE&&matrix[row][col-1]==temp+1){
			dfs(row, col-1, matrix, lmax+1, path);
		}
	    matrix[row][col]=temp;
		path.remove(path.size()-1);
	}

	
}