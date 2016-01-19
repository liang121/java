import java.util.List;
import java.util.ArrayList;

/*
 * First,let user input a number, say 1. Then, the function will 
 * generate the next 10 numbers which satisfy this condition: 
 * 1,11,21,1211,111221,312211... 
 * explanation: first number 1, second number is one 1, so 11. 
 * Third number is two1(previous number), so 21. next number one 
 * 2 one 1, so 1211 and so on...
 */

public class countAndSay {
	public static void main(String[] args) {
		String str = "1";
		System.out.println(getSequence("1"));
	}
	public static ArrayList<String> getSequence(String str){
		String last = "";
		String cur = str;
		ArrayList<String> result = new ArrayList<String>();
		int n=10;
		while(n>0){
			result.add(cur);
			last = cur;
			cur = getstr(cur);
			n--;
		}
		result.add(cur);
		return result;
	}
	
	
	
	public static String getstr(String str){
		if(str.length()==0) return str;
		char last = '\0';
		char cur = str.charAt(0);
		StringBuilder res = new StringBuilder();
		int count = 1;
		for(int i=1;i<str.length();i++){
			last = cur;
			cur = str.charAt(i);
			if(last==cur){
				count++;
			}
			else{
				
				res.append(count);
				res.append(last);
				count=1;
			}
		}
		res.append(count);
		res.append(cur);
		return res.toString();
	}
}
