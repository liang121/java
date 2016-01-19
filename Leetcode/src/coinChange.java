import java.util.*;

/*
 * Something cost $10.25 and the customer pays with a $20 bill, the 
 * program will print out the most efficient "change-breakdown" which 
 * is 1 five, 4 ones, and 3quarters. Find the minimum number of coins 
 * required to make change for a given sum (given unlimited number of N 
 * different denominations coin)
 */

public class coinChange{
	public static int r = Integer.MAX_VALUE;
	public static void main(String[] args){
		System.out.println(change(20,10.25));
		
	}

	public static int change(double pay,double cost){
		double[] notes = {20,10,5,1,0.25,0.1,0.05,0.01};
		double change = pay-cost;
		List<Double> result = new ArrayList<Double>();
		List<List<Double>> results = new ArrayList<List<Double>>();
		int num = 0;
		dfs(result,results,change,notes,0,num);
		System.out.println(results.toString());
		return r;
	}
	public static void dfs(List<Double> result,List<List<Double>> results,double change,double[] notes,int index,int num){
		if(change<0) return;
		
		if(change==0){
			results.add(new ArrayList<Double>(result));
			r=Math.min(r, num);
			num++;
		}
		for(int i=index;i<notes.length;i++){
			result.add(notes[i]);
			dfs(result, results, change-notes[i], notes, i, num+1);
			result.remove(result.size()-1);
		}
	}
}

//import java.util.List;
//import java.util.ArrayList;
//
///*
// * Something cost $10.25 and the customer pays with a $20 bill, the 
// * program will print out the most efficient "change-breakdown" which 
// * is 1 five, 4 ones, and 3quarters. Find the minimum number of coins 
// * required to make change for a given sum (given unlimited number of N 
// * different denominations coin)
// */
//
//public class coinChange {
//	public static void main(String[] args) {
//		doTests();
//	}
//	
//	public static List<Double> helper(double[] coins, double target, int pos, List<Double> way) {
//		if (target == 0) {
//			return way;
//		} else if (target < 0) {
//			way.remove(way.size() - 1);
//			way.add(coins[pos + 1]);
//			return helper(coins, target + coins[pos] - coins[pos+1], pos + 1, way);
//		} else {
//			way.add(coins[pos]);
//			return helper(coins, target - coins[pos], pos, way);
//		}
//	}
//	
//	public static void doTests() {
//		double[] coins = {5.0, 1.0, 0.25, 0.1, 0.05, 0.01};
//		double target = 20;
//		double cost = 10.25;
//		List<Double> res = new ArrayList<Double>();
//		helper(coins, target - cost, 0, res);
//		System.out.println(res);
//	}
//}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
