package bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class two_sum {
	public static void main(String[] args){
		int[] a = {1,3,2,12,4,5,23,5,6};
		int target = 7;
		Arrays.sort(a);
		ArrayList<Integer> re = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		getSum(a, target, re, res);
		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i).toString());
		}
	}
	// method one  O(n);·µ»ØÄÚÈÝ
//	public static void getSum(int[] a, int target, ArrayList<Integer> re,ArrayList<ArrayList<Integer>> res){
//		HashSet<Integer> set = new HashSet<Integer>();
//		for(int i=0;i<a.length;i++){
//			if(!set.contains(target-a[i])&&!set.contains(a[i])) set.add(a[i]);
//			else{
//				re.add(a[i]);
//				re.add(target-a[i]);
//				if(!res.contains(re))res.add(re);
//				re = new ArrayList<Integer>();
//			}
//		}
//	}
	public static void getSum(int[] a, int target, ArrayList<Integer> re,ArrayList<ArrayList<Integer>> res){
		int l = 0;
		int r = a.length-1;
		while(l<r){
			int sum = a[l]+a[r];
			if(sum<target){
				l++;
			}
			else if(sum>target){
				r--;
			}
			else{
				re = new ArrayList<Integer>();
				re.add(a[l]);
				re.add(a[r]);
				res.add(re);
				l++;
				r--;
				while(l<a.length&&a[l]==a[l-1]) l++;
				while(r>=0&&a[r]==a[r+1])r--;
			}
		}
	}
	

}
