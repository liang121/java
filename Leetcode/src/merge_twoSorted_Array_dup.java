package bloomberg;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class merge_twoSorted_Array_dup {
	// two pointer
//	public static void main(String[] args){
//		int[] a = {1,2,4};
//		int[] b = {2,3};
//		ArrayList<Integer> result = new ArrayList<Integer>();
//		int p1 = 0;
//		int p2 = 0;
//		while(p1<a.length||p2<b.length){
//			System.out.println(p1+"  "+p2);
//			if(p1==a.length&&p2<b.length){
//				while(p2<b.length){
//					result.add(b[p2]);
//					p2++;
//				}
//				break;
//			}
//			else if(p1<a.length&&p2==b.length){
//				while(p1<a.length){
//					result.add(a[p1]);
//					p1++;
//				}
//				break;
//			}
//			else{
//				if(a[p1]<b[p2]){
//					result.add(a[p1]);
//				    p1++;
//				}
//				else if(a[p1]>b[p2]){
//					result.add(b[p2]);
//					p2++;
//				}
//				else{
//					result.add(b[p2]);
//					p1++;
//					p2++;
//				}
//			}
//		}
//		System.out.println(result.toString());
//	}
	///////////////////////////////////////////////////////
	public static void main(String[] args){
		int[] a = {1,2,4};
		int[] b = {2,3};
		ArrayList<Integer> result = new ArrayList<Integer>();
		int[] c = new int[a.length+b.length];
		for(int i=0;i<a.length;i++){
			c[i] = a[i];
		}
		int j=a.length;
		for(int i=0;i<b.length;i++){
			c[j] = b[i];
			j++;
		}
		Arrays.sort(c);
		j=0;
		for(int i=0;i<c.length-1;i++){
			if(c[i]!=c[i+1]){
				c[j] = c[i];
				j++;
			}
			else continue;
		}
		c[j] = c[c.length-1];
		for(int i=0;i<=j;i++){
			System.out.println(c[i]);
		}
	}

}
