import java.util.*;
/*
 * Write a program to add the substring. 
 * eg :say you have a list {1 7 6 3 5 8 9 }
 * and user is entering a sum 16. Output should display(2-4) that is {7 6 3} 
 * cause 7+6+3=16.
 */

public class substringAddition{
	public static String checkifinsubstring(int [] arr, int sum){
		String result = "";
		for(int i=0;i<arr.length;i++){
		int total = 0;	
			for(int j=i;j<arr.length;j++){
				total = total+arr[j];
				if (total == sum){
					result += i+" - "+j + "\n";
				}
			}
		}	
		if (result == "") {
			return "no such substring";
		}
		return result;
	}
	public static void main(String[] args){
		int [] arr = {1, 7, 6, 3, 5, 8, 9};
		int sum = 16;
		System.out.println(checkifinsubstring(arr, sum));
		System.out.println("/////////////////////////////////");
		System.out.println(check(arr, sum).toString());
	}
	public static ArrayList<String> check(int[] arr, int sum){
		ArrayList<String> res = new ArrayList<String>();
		for(int i=0;i<arr.length;i++){
			int s = sum;
			for(int j=i;j<arr.length;j++){
				s -= arr[j];
				if(s==0){
					String str = (i+1)+"-"+(j+1);
					res.add(str);
					break;
				}
			}
		}
		return res;
	}
}