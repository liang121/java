import java.util.*;

import javax.print.attribute.standard.PrinterLocation;
/*
 * You are given a grid of numbers. A snake sequence is made up of
 * adjacent numbers such that for each number, the number on the right
 * or the number below it is +1 or -1 its value. For example,
 *  1 3 2 6 8
 * -9 7 1 -1 2
 *  1 5 0 1 9
 *  In this grid, (3, 2, 1, 0, 1) is a snake sequence.
 *  Given a grid, DFS the longest snake sequences and their lengths
 *  (so there can be multiple snake sequences with the maximum length).
 *
 */

public class snakeSequence{
	public static int max;
	public static ArrayList<ArrayList<Integer>> paths;
	public static void main(String[] args){
	       int[][] arr1 = {
	                { 1, 3, 2,  6, 8},
	                {-9, 7, 1, -1, 2},
	                { 1, 5, 0,  1, 9}    
	                       };
	       max=0;
	       paths = new ArrayList<ArrayList<Integer>>();
	       ArrayList<Integer> path;
	       for(int i=0;i<arr1.length;i++){
	            for(int j=0;j<arr1[0].length;j++){
	                path = new ArrayList<Integer>();
	                dfs(i,j,arr1,0,path);
	            }
	       }
	       System.out.println(max+1);
	       System.out.println(paths.toString());
	}
	public static void dfs(int row,int col,int[][] arr1,int l_max,ArrayList<Integer> path){
	        path.add(arr1[row][col]);
	        if(l_max>=max){
	            if(l_max>max){
	                paths.clear();
	                max = l_max;
	            }
	            paths.add(new ArrayList<Integer>(path));
	        }
	
	        if(row+1<arr1.length&&Math.abs(arr1[row+1][col]-arr1[row][col])==1){
	            dfs(row+1,col,arr1,l_max+1,path);
	        }
	        if(col+1<arr1[0].length&&Math.abs(arr1[row][col+1]-arr1[row][col])==1){
	             dfs(row,col+1,arr1,l_max+1,path);
	        }
	        path.remove(path.size()-1);
	
	
	}
//	public static int max;
//	public static ArrayList<ArrayList<Integer>> res;
//	public static void main(String[] args){
//        int[][] arr1 = {
//                { 1, 3, 2,  6, 8},
//                {-9, 7, 1, -1, 2},
//                { 1, 5, 0,  1, 9}
//        };
//        int[][] arr2 = {
//                {1, 1, 2, 3, 1},
//                {1, 1, 3, 4, 5},
//                {1, 1, 4, 3, 3 }
//        };
//        ArrayList<Integer> list;
//        res = new ArrayList<ArrayList<Integer>>();
//        for(int i=0;i<arr1.length;i++){
//        	for(int j=0;j<arr1[0].length;j++){
//        		list = new ArrayList<Integer>();
//        		dfs(i,j,list,arr1,0);
//        	}
//        }                                 //////////////////
//        System.out.println(res.toString()+" "+(max+1));/////
//                                          /////////////////
//	}
//
//	public static void dfs(int row, int col, ArrayList<Integer>list,int[][] arr1,int l_max){
//		list.add(arr1[row][col]);
//		if(l_max>=max){
//			if(l_max>max){
//				res.clear();
//				max = l_max;
//				
//			}//////////////////////////////////////////////////
//			res.add(new ArrayList<Integer>(list));/////////////
//			///////////////////////////////////////////////////
//		}
//		if(row+1<arr1.length&&Math.abs(arr1[row+1][col]-arr1[row][col])==1){
//			dfs(row+1, col, list, arr1, l_max+1);
//		}
//		if(col+1<arr1[0].length&&Math.abs(arr1[row][col+1]-arr1[row][col])==1){
//			dfs(row, col+1, list, arr1, l_max+1);
//		}
//		list.remove(list.size()-1);
//	}
	
}


//public static int max;
//public static ArrayList<ArrayList<Integer>> paths;
//public static void main(String[] args){
//       int[][] arr1 = {
//                { 1, 3, 2,  6, 8},
//                {-9, 7, 1, -1, 2},
//                { 1, 5, 0,  1, 9}    
//                       };
//       max=0;
//       paths = new ArrayList<ArrayList<Integer>>();
//       ArrayList<Integer> path;
//       for(int i=0;i<arr1.length;i++){
//            for(int j=0;j<arr1[0].length;j++){
//                path = new ArrayList<Integer>();
//                dfs(i,j,arr1,0,path);
//            }
//       }
//       System.out.println(max+1);
//       System.out.println(paths.toString());
//}
//public static void dfs(int row,int col,int[][] arr1,int l_max,ArrayList<Integer> path){
//        path.add(arr1[row][col]);
//        if(l_max>=max){
//            if(l_max>max){
//                paths.clear();
//                max = l_max;
//            }
//            paths.add(new ArrayList<Integer>(path));
//        }
//
//        if(row+1<arr1.length&&Math.abs(arr1[row+1][col]-arr1[row][col])==1){
//            dfs(row+1,col,arr1,l_max+1,path);
//        }
//        if(row+1<arr1.length&&Math.abs(arr1[row+1][col]-arr1[row][col])==1){
//             dfs(row,col+1,arr1,l_max+1,path);
//        }
//        path.remove(path.size()-1);
//
//
//}