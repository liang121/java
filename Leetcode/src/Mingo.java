import java.util.*;
/*
A random generator (like a speaker standing in a group housie game calls out a number) 
generates out any numberfrom 1 to 1000. 
There is a 10X10 matrix. 
A random generator assigns valuesto each block of this matrix(within 1 to 1000 obviously). 
Whenever, a row or a column or a diagonal is fully filled in this 10x10 from the numbers 
called out by the speaker, its called a 'Mingo'. 
Write a program that will find first Mingo, then second Mingo, then thirds Mingo...and so forth.
*/

//public class Mingo{
//	public static void main(String[] args){
//		mingo();
//	}
//
//	public static void mingo(){
//		Random rand = new Random();
//		Random pos = new Random();
//		int count = 0;
//		int[][] map = new int[10][10];
//		for(int i=0;i<10;i++){
//			for(int j=0;j<10;j++){
//				map[i][j] = -1;
//			}
//		}
//		List<Integer> res = new ArrayList<Integer>();
//		while(count<100){
//			int random = rand.nextInt(1000);
//			int row = pos.nextInt(10);
//			int col = pos.nextInt(10);
//			if(map[row][col] != -1){
//				continue;
//			}
//			if(map[row][col] == -1){
//				map[row][col] = random;
//				count++;
//			}
//			//check if mingo
//			boolean ifMingo = true;
//			for(int i=0;i<10;i++){
//				if(map[row][i]==-1 || map[i][col] == -1){
//					ifMingo = false;
//				}
//			}
//			int x=row, y=col;
//			boolean ifMingoD1 = true;
//			while(x>=0 && y>=0 && x<10 && y<10){
//				if(map[x][y] == -1){
//					ifMingoD1 = false;
//				}
//				x++;
//				y++;
//			}
//			x=row;
//			y=col;
//			boolean ifMingoD2 = true;
//			while(x>=0 && y>=0 && x<10 && y<10){
//				if(map[x][y] == -1){
//					ifMingoD2 = false;
//				}
//				x--;
//				y--;
//			}
//			if(ifMingo||ifMingoD1||ifMingoD2){
//				res.add(random);
//			}
//		}
//		System.out.println("Total :"+res.size()+" Mingos!");
//		System.out.println("Mingos: ");
//		System.out.println(res);
//		System.out.println("Map: ");
//		for(int i=0;i<10;i++){
//			for(int j=0;j<10;j++){
//				System.out.print(map[i][j]+",");
//			}
//			System.out.println();
//		}
//	}
//}


///////////////////////////////////
public class Mingo {

//    public void findMingo(int arr[][], int[] called) {
//        ArrayList<ArrayList<Integer>> sequencedLists = new ArrayList<ArrayList<Integer>>();
//        for (int i = 0; i < 10; i++) {
//            ArrayList<Integer> row = getRow(arr, i);
//            ArrayList<Integer> column = getColumn(arr, i);
//            sequencedLists.add(row);
//            sequencedLists.add(column);
//        }
//        sequencedLists.add(getFirstDiagonal(arr));
//        sequencedLists.add(getSecondDiagonal(arr));
//
//        for (int i = 0; i < called.length; i++) {
//            //Now loop throgh each sequence and remove the called number.
//            //Exit if Bingo!
//            for (ArrayList<Integer> sequence : sequencedLists) {
//                if (sequence.contains(called[i])) {
//                    sequence.remove(new Integer(called[i]));
//                    if (sequence.isEmpty()) {
//                        System.out.println("Mingo after " + (i + 1) + " calls!");
//                        return;
//                    }
//                }
//            }
//        }
//        System.out.println("No Mingo for you :'(");
//    }
//
//
//    private ArrayList<Integer> getFirstDiagonal(int arr[][]) {
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        for (int i = 0; i < 10; i++) {
//            list.add(arr[i][i]);
//        }
//        return list;
//    }
//
//    private ArrayList<Integer> getSecondDiagonal(int arr[][]) {
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        for (int i = 0; i < 10; i++) {
//            list.add(arr[i][9 - i]);
//        }
//        return list;
//    }
//
//    private ArrayList<Integer> getRow(int arr[][], int index) {
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        for (int i = 0; i < 10; i++) {
//            list.add(arr[index][i]);
//        }
//        return list;
//    }
//
//    private ArrayList<Integer> getColumn(int arr[][], int index) {
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        for (int i = 0; i < 10; i++) {
//            list.add(arr[i][index]);
//        }
//        return list;
//    }

    public static void main(String[] args) {
        int matrix[][] = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
                {41, 42, 43, 44, 45, 46, 47, 48, 49, 50},
                {51, 52, 53, 54, 55, 56, 57, 58, 59, 60},
                {61, 62, 63, 64, 65, 66, 67, 68, 69, 70},
                {71, 72, 73, 74, 75, 76, 77, 78, 79, 80},
                {81, 82, 83, 84, 85, 86, 87, 88, 89, 90},
                {91, 92, 93, 94, 95, 96, 97, 98, 99, 100}
        };
        int called[] = {1, 2, 3, 4, 73, 82, 91, 5, 6, 7, 8, 9, 10};
       // Mingo mingo = new Mingo();
       // mingo.findMingo(matrix, called);
        ArrayList<ArrayList<Integer>> list = getTotalSequence(matrix);
        getcall(called,list);
    }
    public static int getcall(int[] called,ArrayList<ArrayList<Integer>> list ){
    	for(int i=0;i<called.length;i++){
    		for(ArrayList<Integer> seq:list){
    			if(seq.contains(called[i])){
    				seq.remove(new Integer(called[i]));
    				if(seq.isEmpty()){
    					System.out.println((i+1)+" calls makes mingo");
    					return i;
    				}
    				break;
    			}
    		}
    	}
    	System.out.println("there is no mingo");
    	return -1;
    }
    
    public static ArrayList<ArrayList<Integer>> getTotalSequence(int[][] matrix){
    	ArrayList<Integer> seq = new ArrayList<Integer>();
    	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>() ;
    	for(int i=0;i<matrix.length;i++){
    		seq = getRow(matrix,i);
    		list.add(seq);
    		seq=getCol(matrix, i);
    		list.add(seq);
    	}
    	list.add(getDia(matrix));
    	list.add(getRevDia(matrix));
    	return list;
    	
    }
    public static ArrayList<Integer> getDia(int[][] matrix){
    	int j=0;
    	ArrayList<Integer> seq = new ArrayList<Integer>();
    	for(int i=0;i<matrix.length;i++){
    		seq.add(matrix[i][j]);
    		j++;
    	}
    	return seq;
    }
    public static ArrayList<Integer> getRevDia(int[][] matrix){
    	ArrayList<Integer> seq = new ArrayList<Integer>();
    	int j=matrix[0].length-1;
    	for(int i=0;i<matrix.length;i++){
    		seq.add(matrix[i][j]);
    		j--;
    	}
    	return seq;
    	
    }
    public static ArrayList<Integer> getRow(int[][] matrix,int j){
    	ArrayList<Integer> seq = new ArrayList<Integer>();
    	for(int i=0;i<matrix[j].length;i++){
    		seq.add(matrix[j][i]);
    	}
    	return seq;
    }
    public static ArrayList<Integer> getCol(int[][] matrix,int j){
    	ArrayList<Integer> seq = new ArrayList<Integer>();
    	for(int i=0;i<matrix.length;i++){
    		seq.add(matrix[i][j]);
    	}
    	return seq;
    }
    
    
}