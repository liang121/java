import java.util.*;
/*
 * Print all palindromes of size greater than or equal to 3 of a given string. 
 */

public class palindrome{
	public static void main(String[] args){
		String s = "abacolocxhooooh";
		System.out.println(generate(s).toString());
	}
	public static ArrayList<String> generate(String s){
		ArrayList<String> result = new ArrayList<String>();
		HashSet<String> set = new HashSet<String> ();
		for(int i=0;i<s.length();i++){
			getstr(i, i, s,set);
			getstr(i, i+1, s,set);
           
		}
		 for(String st:set) {
         	result.add(st);
         }
		return result;
	}

	public static void  getstr(int left,int right,String s,HashSet<String> set){
		while(left<=right&&left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
			left--;
			right++;
			if(s.substring(left+1,right).length()>=3) set.add(s.substring(left+1,right));
		}

	}


}
//import java.util.*;
///*
// * Print all palindromes of size greater than or equal to 3 of a given string. 
// */
//
//public class palindrome{
//	public static void main(String[] args){
//		String s = "abacolocxhooooh";
//		find(s);
//	}
//
//	public static void find(String input){
//		List<String> res = new ArrayList<String>();
//		Set<String> set = new HashSet<String>();
//		if(input.length() < 3){
//			System.out.println("Wrong input!");
//		}
//		int mid=1;
//		for(;mid<input.length()-1;mid++){
//			int left=mid-1, right=mid+1;
//			while(left>=0 && right<input.length()){
//				if(input.charAt(left) == input.charAt(right)){
//					set.add(input.substring(left,right+1));
//					left--;
//					right++;
//				}else{
//					break;
//				}
//			}
//
//			left = mid;
//			right = mid+1;
//			while(left>=0 && right<input.length()){
//				if(input.charAt(left)==input.charAt(right)){
//					String temp = input.substring(left,right+1);
//					if(temp.length()>=3){
//						set.add(temp);
//					}
//					left--;
//					right++;
//				}else{
//					break;
//				}
//			}
//		}
//		for(String s:set){
//			res.add(s);
//		}
//		System.out.println(res);
//	}
//
//
//}