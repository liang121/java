package bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class sameItem_twoArray {
	
	public static void main(String[] args){
		int[] a = {1,4,3,56,34,7,6,2,4,766,23,8,2,5};
		int[] b = {2,45,3,6,45,23,4,76,2,23};
//		int[] a = {1,1,2,3,3,4,5,7,7};
//		int[] b = {1,2,2,4,4,4,6};
		Arrays.sort(b);
		Arrays.sort(a);
		ArrayList<Integer> res = new ArrayList<Integer>();
		System.out.println(find(a, b, res).toString());
	}
	
	//排好序的
	public static ArrayList<Integer> find(int[] a, int[] b,ArrayList<Integer> res){
		//int len = Math.max(a.length, b.length);
		int p1 = 0;
		int p2 = 0;
		while(p1<a.length&&p2<b.length){
			//System.out.println(p1+" "+p2);
			if(a[p1]==b[p2]){
				res.add(a[p1]);
				while(p1+1<a.length&&a[p1]==a[p1+1]) {
					p1++;
					System.out.println(p1+" sdfsdfsdf");
				}
				p1++;
				while(p2+1<b.length&&a[p2]==a[p2+1]) p2++;
				p2++;
				continue;
			}
			else{
				if(a[p1]<b[p2]) p1++;
				else p2++;
			}
		}
		return res;
		//System.out.println(res.toString());
	}
	
	
	
	//method one O(a+b)
//	public static ArrayList<Integer> find(int[] a, int[] b,ArrayList<Integer> res){
//		HashSet<Integer> set = new HashSet<Integer>();
//		for(int i=0;i<a.length;i++){
//			if(!set.contains(a[i])){
//				set.add(a[i]);
//			}
//			else continue;
//		}
//		for(int i=0;i<b.length;i++){
//			if(set.contains(b[i])&&!res.contains(b[i])){
//				res.add(b[i]);
//			}
//		}
//		return res;
//	}
	
	// method two O(alog(b)+blog(b))
//	public static ArrayList<Integer> find(int[] a, int[] b,ArrayList<Integer> res){
//		for(int i=0;i<a.length;i++){
//			if(bs(a[i], b)&&!res.contains(a[i])) res.add(a[i]);
//			
//		}
//		return res;
//		
//	}
//	public static boolean bs(int a,int[] b){
//		int l = 0;
//		int r=b.length-1;
//		while(l<r){
//			int m=(l+r)/2;
//			if(a<=b[m]) r=m; //注意顺序不要颠倒
//			else l=m+1;
//		}
//		return b[l]==a;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
