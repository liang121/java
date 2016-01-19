import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

/*
 * Write a program for a word search. If there is an NxN grid 
 * with one letter in each cell. Let the user enter a word and 
 * the letters of the word are said to be found in the grid either 
 * the letters match vertically, horizontally or diagonally in the grid.
 * If the word is found, print the coordinates of the letters as output.
 */

public class findingWords {
//	public static void main(String[] args) {
//		doTests();
//	}	
//	public static boolean wordSearch(String word, char[][] board){  
//        if (board == null || board.length == 0 || board[0].length == 0){  
//            return false;  
//        }  
//        if (word.length() == 0){  
//            return true;  
//        }
//        ArrayList<ArrayList<Integer>> rcor = new ArrayList<ArrayList<Integer>>();
//        for (int i = 0; i < board.length; i++){  
//            for (int j = 0; j < board[0].length; j++){  
//                if (board[i][j] == word.charAt(0)){  
//                	ArrayList<Integer> vcor = new ArrayList<Integer>();
//                	ArrayList<Integer> hcor = new ArrayList<Integer>();
//                	ArrayList<Integer> dcor = new ArrayList<Integer>();
//                	rcor = new ArrayList<ArrayList<Integer>>();
//                    boolean res = helperVertical(word, board, i, j, 0,vcor,rcor) || helperHorizontal(word, board, i, j, 0,hcor,rcor)|| helperDiagnal(word, board, i, j, 0,dcor,rcor);
//                    if (res){  
//                    	System.out.println(rcor.toString());
//                        return true;  
//                    }  
//                }  
//            }  
//        }  
//        return false;  
//    }  
//    public static boolean helperVertical(String word, char[][] board, int i, int j, int index,ArrayList<Integer> vcor,ArrayList<ArrayList<Integer>> rcor){     
//    	if (index == word.length()){ 
//    		rcor.add(new ArrayList<Integer>(vcor));
//            return true;  
//        }  
//    	vcor.add(i);
//        vcor.add(j);
//        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)){  
//        	vcor.remove(vcor.size()-1);
//        	vcor.remove(vcor.size()-1);
//        	return false;  
//        }  
//        return helperVertical(word, board, i, j+1, index+1,vcor, rcor);
//    }  
//  
//    public static boolean helperHorizontal(String word, char[][] board, int i, int j, int index,ArrayList<Integer> hcor,ArrayList<ArrayList<Integer>> rcor){      	
//        if (index == word.length()){
//        	rcor.add(new ArrayList<Integer>(hcor));
//            return true;  
//        }  
//        hcor.add(i);
//        hcor.add(j);
//        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)){  
//        	hcor.remove(hcor.size()-1);
//        	hcor.remove(hcor.size()-1);
//        	return false;  
//        }  
//        return helperHorizontal(word, board, i+1, j, index+1,hcor, rcor);
//    }  
//    public static boolean helperDiagnal(String word, char[][] board, int i, int j, int index,ArrayList<Integer> dcor,ArrayList<ArrayList<Integer>> rcor){  
//        if (index == word.length()){  
//        	rcor.add(new ArrayList<Integer>(dcor));
//            return true;  
//        }  
//        dcor.add(i);
//        dcor.add(j);
//        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)){  
//            dcor.remove(dcor.size()-1);
//            dcor.remove(dcor.size()-1);
//        	return false;  
//        }  
//        return helperDiagnal(word, board, i+1, j+1, index+1,dcor, rcor);
//    }  	
	public static void main(String[] args) {
		char[][] board = {
			{ 'a', 'b', 'c', 'd' }, 
			{ 'e', 'f', 'g', 'h' },
			{ 'i', 'j', 'k', 'l' }, 
			{ 'm', 'n', 'o', 'p' } 
		};		
		if (wordSearch("afklp", board)) {
			System.out.println("Found!");
		} else {
			System.out.println("Failed!");
		}
	}
	public static boolean wordSearch (String word, char[][] board){
		if(word.length()==0) return true;
		boolean found = false;
		ArrayList<String> path;
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				path = new ArrayList<String>();
				found = find(i,j,word,board,0,path);
				if(found==true){
					System.out.println(path);
					return true;
				}
			}
		}
		return false;
	}
	public static boolean find(int row, int col, String word, char[][] board,int wordIndex,ArrayList<String> path){
		String cor = row+","+col;
		path.add(cor);
		if(wordIndex+1>=word.length()) return true;
		char temp = board[row][col];
		board[row][col]='*';
		if(row+1<board.length&&board[row+1][col]==word.charAt(wordIndex+1)){
			boolean found = find(row+1, col, word, board, wordIndex+1, path);
			if(found) return true;
		}
		if(row-1>=0&&board[row-1][col]==word.charAt(wordIndex+1)){
			boolean found = find(row-1, col, word, board, wordIndex+1, path);
			if(found) return true;
		}
		if(row+1<board.length&&col+1<board[0].length&&board[row+1][col+1]==word.charAt(wordIndex+1)){
			boolean found = find(row+1, col+1, word, board, wordIndex+1, path);
			if(found) return true;
		}
		if(row-1>=0&&col-1>=0&&board[row-1][col-1]==word.charAt(wordIndex+1)){
			boolean found = find(row-1, col-1, word, board, wordIndex+1, path);
			if(found) return true;
		}
		if(col+1<board[0].length&&board[row][col+1]==word.charAt(wordIndex+1)){
			boolean found = find(row, col+1, word, board, wordIndex+1, path);
			if(found) return true;
		}
		if(col-1>=0&&board[row][col-1]==word.charAt(wordIndex+1)){
			boolean found = find(row, col-1, word, board, wordIndex+1, path);
			if(found) return true;
		}
		if(row+1<board.length&&col-1>=0&&board[row+1][col-1]==word.charAt(wordIndex+1)){
			boolean found = find(row+1, col-1, word, board, wordIndex+1, path);
			if(found) return true;
		}
		if(row-1>=0&&col+1<board[0].length&&board[row-1][col+1]==word.charAt(wordIndex+1)){
			boolean found = find(row-1, col+1, word, board, wordIndex+1, path);
			if(found) return true;
		}
		path.remove(path.size()-1);
		board[row][col]=temp;
		return false;
	}
//	public static boolean wordSearch(String str,char[][] board){
//		boolean found = false;
//		for(int i=0;i<board.length;i++){
//			for(int j=0;j<board[0].length;j++){
//				if(board[i][j]==str.charAt(0)){
//					ArrayList<String> res = new ArrayList<String>();
//					found = find(i,j,str,board,0,res);
//					if(found==true) {
//						System.out.println(res);
//						return true;
//					}
//				}
//			}
//		}
//		return false;
//	}
//	public static boolean find(int row,int col,String str,char[][] board,int charat,ArrayList<String> res){
//		boolean found = false;
//		res.add(row+","+col);
//		if(charat==str.length()-1) return true;
//		char temp = board[row][col];
//		board[row][col]='*';
//		if(row+1<board.length&&board[row+1][col]==str.charAt(charat+1)){
//			found = find(row+1, col, str, board, charat+1,res);
//			if(found) return true;
//		}
//		if(col+1<board[0].length&&board[row][col+1]==str.charAt(charat+1)){
//			found = find(row, col+1, str, board, charat+1,res);
//			if(found) return true;
//		}
//		if(row-1>=0&&board[row-1][col]==str.charAt(charat+1)){
//			found = find(row-1, col, str, board, charat+1,res);
//			if(found) return true;
//		}
//		if(col-1>=0&&board[row][col-1]==str.charAt(charat+1)){
//			found = find(row, col-1, str, board, charat+1,res);
//			if(found) return true;
//		}
//		if(col-1>=0&&row-1>=0&&board[row-1][col-1]==str.charAt(charat+1)){
//			found = find(row-1, col-1, str, board, charat+1,res);
//			if(found) return true;
//		}
//		if(col-1>=0&&row+1<board.length&&board[row+1][col-1]==str.charAt(charat+1)){
//			found = find(row+1, col-1, str, board, charat+1,res);
//			if(found) return true;
//		}
//		if(col+1<board[0].length&&row-1>=0&&board[row-1][col+1]==str.charAt(charat+1)){
//			found = find(row-1, col+1, str, board, charat+1,res);
//			if(found) return true;
//		}
//		if(col+1<board[0].length&&row+1<board.length&&board[row+1][col+1]==str.charAt(charat+1)){
//			found = find(row+1, col+1, str, board, charat+1,res);
//			if(found) return true;
//		}
//		res.remove(res.size()-1);
//		board[row][col]=temp;
//		return false;
//	}
}
