import java.util.*;
/*
 * The decimal and octal values of some numbers are both palindromes sometimes.
 *  Find such numbers within a given range.
 */

public class octalAndDecimalPalindrome{
	public static void main(String[] args){
		System.out.println(find(1,1000).toString());
		System.out.println(Integer.toString(16,8));
		//check(1,1000);
	}
	
	public static ArrayList<String> find(int left,int right){
		ArrayList<String> result = new ArrayList<String>();
		for(int i=left;i<=right;i++){
			String dec = i+"";
			String oct = Integer.toString(i,8);
			if(isp(dec)&&isp(oct)) result.add(dec);
		}
		return result;
	}
	public static boolean isp(String str){
		int left = 0;
		int right = str.length()-1;
		while(left<=right){
			if(str.charAt(left)==str.charAt(right)){
				left++;
				right--;
			}
			else return false;
		}
		return true;
	}

//	public static void check(int start, int end){
//		List<Integer> res = new ArrayList<Integer>();
//		for(int i=start;i<=end;i++){
//			String oct = Integer.toString(i,8);
//			if(isPalindrome(oct) && isPalindrome(String.valueOf(i))){
//				res.add(i);
//			}
//		}
//		System.out.println(res);
//	}
//
//	public static boolean isPalindrome(String input){
//		int left = 0, right = input.length()-1;
//		while(left < right){
//			if(input.charAt(left) != input.charAt(right)){
//				return false;
//			}
//			left++;
//			right--;
//		}
//		return true;
//	}
}