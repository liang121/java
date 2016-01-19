import java.util.List;

import javax.sql.rowset.CachedRowSet;

import java.util.ArrayList;

/*
 * Phone has letters on the number keys. For example, 
 * number 2 has ABC on it, number 3 has DEF, 4 number has GHI,..., 
 * and number 9 has WXYZ. Write a program that will print out 
 * all of the possible combination of those letters depending 
 * on the input. 
 */

public class keypadPermutation {
	private static String[] map = {
		"", "", "abc", "def", "ghi", "jkl", 
		"mno", "pqrs", "tuv", "wxyz"
	};
	
	public static void main(String[] args) {
		//doTests();
		String str = "235";
		//ArrayList<String> result = new ArrayList<String>();
		System.out.println(getLetterSet(str).toString());
	}
	public static ArrayList<String> getLetterSet(String str){
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String> letterSet = getset(str);
		dfs(letterSet, result, "", 0);
		return result;
		
	}
	public static void dfs(ArrayList<String> letterSet, ArrayList<String> result,String level,int index){
		if(level.length()==letterSet.size()) {
			result.add(level);
			return;
		}
		for(int i=0;i<letterSet.get(index).length();i++){
			dfs(letterSet, result, level+letterSet.get(index).charAt(i), index+1);
		}
	}
	public static ArrayList<String> getset(String str){
		ArrayList<String> res = new ArrayList<String>();
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			res.add(findstr(c));
		}
		return res;
	}
	public static String findstr(char c){
		switch(c){
		case '0': return "";
		case '1': return "";
		case '2': return "abc";
		case '3': return "def";
		case '4': return "ghi";
		case '5': return "jkl";
		case '6': return "mno";
		case '7': return "pqrs";
		case '8': return "tuv";
		case '9': return "wxyz";
		default: return "";
		}
	}
	
//	public static void helper(String digits, List<String> res, StringBuilder item, int pos) {
//		if (pos == digits.length()) {
//			res.add(item.toString());
//			return;
//		}
//		String select = map[digits.charAt(pos) - '0'];
//		for (int i = 0; i < select.length(); i++) {
//			item.append(select.charAt(i));
//			helper(digits, res, item, pos + 1);
//			item.deleteCharAt(item.length() - 1);
//		}
//	}
//	
//	public static void doTests() {
//		String digits = "235";
//		List<String> res = new ArrayList<String>();
//		helper(digits, res, new StringBuilder(), 0);
//		System.out.println(res);
//	}
}
