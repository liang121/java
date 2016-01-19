
import java.io.ObjectInputStream.GetField;
import java.security.DigestInputStream;
import java.util.*;
/*
 * Print all valid phone numbers of length n subject to following constraints: 
 * 1.If a number contains a 4, it should start with 4 
 * 2.No two consecutive digits can be same 
 * 3.Three digits (e.g. 7,2,9) will be entirely disallowed, take as input
 */

public class telephoneNumber{
	public static void main(String[] args){
		String disallow = "729";
		String validDigit = getDigits(disallow);
		int digitsNum=4;
		System.out.println(getTelNum(validDigit,digitsNum).toString());
	}
	public static ArrayList<String> getTelNum(String digits, int num){
		ArrayList<String> res = new ArrayList<String>();
		dfs(digits,res,"",num);
		return res;
	}
	public static void dfs(String digits,ArrayList<String> res,String str,int num){
		if(num==0){
			res.add(str);
			return;
		 
		}
		for(int i=0;i<digits.length();i++){
			char c = digits.charAt(i);
			if(str.length()>0){
				if(c=='4'&&str.charAt(0)!='4') continue;
				if(str.charAt(str.length()-1)==c) continue;
			}
			dfs(digits, res, str+c, num-1);
		}
	}
	public static String getDigits(String disallow){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<=9;i++){
			if(disallow.indexOf(i+"")==-1) sb.append(i+"");
		}
		return sb.toString();
	}
	

	
	//////////////////////////////////////////////////////////////////////////////
	
	
	public static void generate(int num){
		List<String> res = new ArrayList<String>();
		String digits = "0134568";
		//String digits = "01342";
		generate(res,num,"",digits);
		for(String s:res){
			System.out.print(s+",");
		}
	}

	public static void generate(List<String> res, int num, String pre,String digits){
		if(num==0){
			res.add(pre);
			return;
		}
		for(int i=0;i<digits.length();i++){
			if(pre.length()>0){
				if(pre.charAt(pre.length()-1) == digits.charAt(i)){
					continue;
				}
				if(digits.charAt(i) == '4' && pre.charAt(0) != '4'){
					continue;
				}
			}
			generate(res, num-1, pre + digits.charAt(i), digits);
		}
	}
}