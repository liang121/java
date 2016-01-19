import java.util.ArrayList;
import java.util.concurrent.Delayed;

/*
 * Write, efficient code for extracting unique elements from a sorted 
 * list of array. e.g. (1, 1, 3, 3, 3, 5, 5, 5, 9, 9, 9, 9)-> (1, 3, 5, 9).
 */

public class uniqueNumber{
//	public static void main(String[] args){
//		int[] a = {
//			1, 1, 3, 3, 3, 5, 5, 5, 9, 9, 9, 9
//		};
//		find(a);
//	}
//
//	public static void find(int[] list){
//		int pos = 0;
//		for(int i=1;i<list.length;i++){
//			if(list[i] == list[pos]){
//				continue;
//			}else{
//				pos++;
//				list[pos] = list[i];
//			}
//		}
//		for(int i=0;i<pos;i++){
//			System.out.print(list[i]+",");
//		}
//		System.out.println(list[pos]);
//	}
	public static void main(String[] args){
		int[] a = {1, 1, 3, 3, 3, 5,6};
		//System.out.println(findUnique(a).toString());
		int[] b = {1,1,2,3,4,4,6,7,7,9};
		int[] c = {2,2,3,4,5,6,6,7,8,9};
		System.out.println(del(b,c).toString());
	}
	public static ArrayList<Integer> del(int[] a, int[] b){
		int p1=0;
		int p2=0;
		int val1=0;
		int val2=0;
		ArrayList<Integer> res = new ArrayList<Integer>();
		while(p1<a.length||p2<b.length){
			if(p1<a.length) {
				val1 = a[p1];
			}
			else{
				while(p2<b.length){
					///////////////////////////////////////////////////////////////////
					if(res.size()==0||b[p2]!=res.get(res.size()-1)) res.add(b[p2]);////////
					////////////////////////////////////////////////////////////////////
					p2++;
				}
				return res;
			}
			if(p2<b.length){
				val2=b[p2];
			}
			else{
				while(p1<a.length){
					if(res.size()==0||b[p1]!=res.get(res.size()-1)) res.add(b[p1]);
					p1++;
				}
				return res;
			}
			if(val1<val2){
				if(res.size()==0||val1!=res.get(res.size()-1)){
					res.add(val1);
				}
				p1++;
			}
			else{
				if(res.size()==0||val2!=res.get(res.size()-1)){
					res.add(val2);
				}
				p2++;
				
			}

		}
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static ArrayList<Integer> findUnique(int[] a){
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(a.length==0) return res;
		int last = a[0];
		int cur = last;
		res.add(cur);
		for(int i=1;i<a.length;i++){
			last = cur;
			cur = a[i];
			if(last==cur) continue;
			else{
				res.add(cur);
			}
		}
		return res;
	}
}