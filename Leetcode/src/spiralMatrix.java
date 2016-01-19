import java.util.ArrayList;

/*
 * Given aNXN matrix, starting from the upper right corner of the 
 * matrix start printing values in a counter-clockwise fashion. 
 * E.g.: Consider N = 4 
 * Matrix= {
 * 			a, b, c, d, 
 * 			e, f, g, h, 
 * 			i, j, k, l, 
 * 			m, n, o, p} 
 * Your function should output: dcbaeimnoplhgfjk
 */
 
 public class spiralMatrix{
 	
 	public static void main(String[] args){
 		char[][] matrix = {
			{'a', 'b', 'c', 'd','1'},
		    {'e', 'f', 'g', 'h','2'}, 
		    {'i', 'j', 'k', 'l','3'}, 
		    {'m', 'n', 'o', 'p','4'},
		    {'5', '6', '7', '8','9'}
		};
		Spiral(matrix);
 	}
 	public static void Spiral(char[][] matrix){
 		ArrayList<Character> res = new ArrayList<Character>();
 		int N = matrix.length;
 		int x = 0;
 		int y = N-1;
 		while(N>0){
 			if(N==1){
 				res.add(matrix[x][y]);
 				break;
 			}
 			for(int i=0;i<N-1;i++){
				res.add(matrix[x][y]);
				y--;
			}
 			for(int i=0;i<N-1;i++){
				res.add(matrix[x][y]);
				x++;
			}
 			for(int i=0;i<N-1;i++){
				res.add(matrix[x][y]);
				y++;
			}
 			for(int i=0;i<N-1;i++){
				res.add(matrix[x][y]);
				x--;
			}
 			N=N-2;
 			x=x+1;
 			y=y-1;
 		}
 		System.out.println(res);
 		
 		
// 		int N = matrix.length;
// 		int x=0,y=N-1;
// 		while(N>0){
// 			if(N==1){
// 				res.add(matrix[x][y]);
// 				break;
// 			}
// 			for(int i=0;i<N-1;i++){
// 				res.add(matrix[x][y]);
// 				y--;
// 			}
// 			for(int i=0;i<N-1;i++){
// 				res.add(matrix[x][y]);
// 				x++;
// 			}
// 			for(int i=0;i<N-1;i++){
// 				res.add(matrix[x][y]);
// 				y++;
// 			}
// 			for(int i=0;i<N-1;i++){
// 				res.add(matrix[x][y]);
// 				x--;
// 			}
// 			N=N-2;
// 			x=x+1;
// 			y=y-1;
// 		}
 		System.out.println(res.toString());
 		
 	}
// 	public static void spiral(char[][] matrix){
// 		//easy, do not make silly mistake
// 		int row = matrix.length;
// 		int col = matrix[0].length;
// 		int x = 0, y=col;
// 		StringBuilder sb = new StringBuilder();
// 		while(true){
// 			for(int i=0;i<col;i++){
// 				sb.append(matrix[x][--y]);
// 			}
// 			row--;
// 			if(row==0) break;
// 			for(int i=0;i<row;i++){
// 				sb.append(matrix[++x][y]);
// 			}
// 			col--;
// 			if(col==0) break;
// 			for(int i=0;i<col;i++){
// 				sb.append(matrix[x][++y]);
// 			}
// 			row--;
// 			if(row==0)break;
// 			for(int i=0;i<row;i++){
// 				sb.append(matrix[--x][y]);
// 			}
// 			col--;
// 			if(col==0) break;
// 		}
// 		System.out.println(sb.toString());
// 	}
 	
 	
}