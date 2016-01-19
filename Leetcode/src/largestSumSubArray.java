import java.util.List;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

/*
 * Find thelargest sum contiguous sub array. The length of 
 * the returned sub array must beat least of length 2.
 * 
 * Similar to https://oj.leetcode.com/problems/maximum-subarray/
 */

public class largestSumSubArray {
	public static void main(String[] args) {
		//doTests();
		int[] array = {-2,1,4,-3,4,-5};
		ArrayList<Integer> res  = get(array);
		if(res.size()>=2)System.out.println(res.toString());
		
	}
	public static ArrayList<Integer> get(int[] A){
		int max = Integer.MIN_VALUE;
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int i=0;i<A.length;i++){
			for(int j=2;i+j<=A.length;j++){
				int val = getSum(A,i,i+j);
				if(val>max){
					max=val;
					res.clear();
					for(int index=i;index<=j;index++){
						res.add(A[index]);
					}
				}
				else continue;
			}
		}
		return res;
	}
	public static int getSum(int[] A, int left, int right){
		int sum=0;
		for(int i=left;i<right;i++){
			sum += A[i];
		}
		return sum;
	}
	
}
