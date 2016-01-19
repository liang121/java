import java.util.ArrayList;

/*
 * There¡¯s a N*N board, two players join the jump game. The chess 
 * could go vertically and horizontally. If the adjacent chess is 
 * opponent player¡¯s and the spot beside that is empty, then the 
 * chess could jump to that spot. One chess could not been jumped twice.
 * Given the position of the spot on the board, write the program to 
 * count the longest length that chess could go.
 */

public class jumpChess{
	public static int max;
	public static ArrayList<ArrayList<String>> res;
	public static void main(String[] args){
		int[][] board = {
				         {0, 1, 2, 0, 0},
				         {0, 0, 0, 2, 0},
				         {0, 0, 0, 0, 2},
				         {0, 1, 0, 2, 0},
				         {0, 0, 1, 0, 1}
				         };
		max=0;
		res = new ArrayList<ArrayList<String>> ();
		ArrayList<String> path = new ArrayList<String>();
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				path= new ArrayList<String>();
				if(board[i][j]!=0) jump(i,j,path,0,board);
			}
		}//////////////////////////////////////////////////////
		System.out.println((max)+" "+res.toString());//////////bu jia 1 le
		///////////////////////////////////////////////////////
	}
	public static void jump(int x,int y,ArrayList<String> path,int lmax,int[][] board){
		path.add(x+","+y);
		System.out.println(lmax);
		if(lmax>=max){
			if(lmax>max){
				res.clear();
				max=lmax;
			}
			res.add(new ArrayList<String>(path));
		}                                                      //   shi 0 bushi '0'
		                                                    /////////////////////////
		if(x+2<board.length&&board[x+1][y]!=board[x][y]&&board[x+2][y]==0&&board[x+1][y]!=-1&&board[x+1][y]!=0){
			int temp = board[x+1][y];                        ////////////////////////
			board[x+1][y]=-1;
			board[x+2][y]=board[x][y];
			board[x][y]=0;
			jump(x+2, y, path, lmax+1, board);
			board[x+1][y]=temp;
			board[x][y]=board[x+2][y];
			board[x+2][y]=0;
		}
		if(x-2>=0&&board[x-1][y]!=board[x][y]&&board[x-2][y]==0&&board[x-1][y]!=-1&&board[x-1][y]!=0){
			int temp = board[x-1][y];
			board[x-1][y]=-1;
			board[x-2][y]=board[x][y];
			board[x][y]=0;
			jump(x-2, y, path, lmax+1, board);
			board[x-1][y]=temp;
			board[x][y]=board[x-2][y];
			board[x-2][y]=0;
		}
		if(y+2<board[0].length&&board[x][y+1]!=board[x][y]&&board[x][y+2]==0&&board[x][y+1]!=-1&&board[x][y+1]!=0){
			int temp = board[x][y+1];
			board[x][y+1]=-1;
			board[x][y+2]=board[x][y];
			board[x][y]=0;
			jump(x, y+2, path, lmax+1, board);
			board[x][y+1]=temp;
			board[x][y]=board[x][y+2];
			board[x][y+2]=0;
		}
		
		if(y-2>=0&&board[x][y-1]!=board[x][y]&&board[x][y-2]==0&&board[x][y-1]!=-1&&board[x][y-1]!=0){
			int temp = board[x][y-1];
			board[x][y-1]=-1;
			board[x][y-2]=board[x][y];
			board[x][y]=0;
			jump(x, y-2, path, lmax+1, board);
			board[x][y-1]=temp;
			board[x][y]=board[x][y-2];
			board[x][y-2]=0;
		}
		path.remove(path.size()-1);
	}

}

