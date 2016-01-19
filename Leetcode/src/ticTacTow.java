/*
 * N*N matrix is given with input red or black.You can move horizontally, 
 * vertically or diagonally. If 3 consecutive same color found, that color 
 * will get 1 point. So if 4 red are vertically then point is 2. Find the winner.
 */

public class ticTacTow{


		public static int max;
		public static void main(String[] args){
			char[][] matrix = { 
				{'r', 'r', 'r', 'b' }, 
				{'b', 'r', 'b', 'r' },
				{'b', 'r', 'r', 'b' }, 
				{'b', 'r', 'b', 'b' } 
			};
			game(matrix);
		}
		public static void game(char[][] map){
			int r=0;
			int b=0;
			for(int i=0;i<map.length;i++){
				for(int j=0;j<map[0].length;j++){
					if(map[i][j]=='b'){
						max=0;
	                          
						getScore(i,j,map,0);
		                 ////////////////////
						if(max+1>=3) b++;////
						/////////////////////
					}
					if(map[i][j]=='r'){
						max=0;
						getScore(i,j,map,0);					
						if(max+1>=3) r++;
					}
				}
			}
			System.out.println(r+" "+b);
		}
		public static void getScore(int row,int col,char[][] map,int lmax ){
	        if(lmax>max) max=lmax;
			char temp = map[row][col];
			/////////////////////////////////////
			map[row][col] = '*';////////////////
			/////////////////////////////////////////////////
			if(row+1<map.length&&map[row+1][col]==temp){/////
				                         ////////////////////
				getScore(row+1, col, map,lmax+1);
			}
			if(col+1<map[0].length&&map[row][col+1]==temp){
				getScore(row, col+1, map,lmax+1);
			}
			if(row-1>=0&&map[row-1][col]==temp){
				getScore(row-1, col, map,lmax+1);
			}
			if(col-1>=0&&map[row][col-1]==temp){
				getScore(row, col-1, map,lmax+1);
			}
			map[row][col] = temp;
		}
		
	

}