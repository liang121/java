import java.util.ArrayList;

/*
 * Print continuous alphabets from a sequence of arbitrary alphabets 
 * For example: 
 * Input: abcdefljdflsjflmnopflsjflasjftuvwxyz 
 * Output: abcdef; lmnop; tuvwxyz
 * Input: AbcDefljdflsjflmnopflsjflasjftuvWxYz 
 * Output: abcdef; lmnop; tuvwxyz
 */

public class continuousAlphabets {
	public static void main(String[] args) {
		String str1 = "abcdefljdflsjflmnopflsjflasjftuvwxyz";
		String str2 = "AbcDefljdflsjflmnopflsjflasjftuvWxYz";
	    str1 = regulate(str1);
		str2 = regulate(str2);
		System.out.println(continuousAlpha(str1).toString());
		System.out.println(continuousAlpha(str2).toString());
	}
	
	public static String regulate(String str){
		if(str.length()==0) System.out.println("opps, input str is not valid");
		String reg_str = str.toLowerCase();
		StringBuilder res = new StringBuilder();
		for(int i=0;i<reg_str.length();i++){
			char c = reg_str.charAt(i);
			if(Character.isLetter(c)) res.append(c);
			else continue;
		}
		return res.toString();
	}
	
	public static ArrayList<String> continuousAlpha(String s) {
		ArrayList<String> result = new ArrayList<String>();
		if(s.length()==0) System.out.println("opps, input str is not valid");
		char last = '\0';
		char cur = '\0';
		StringBuilder sb = new StringBuilder();
		sb.append(s.charAt(0));
		cur = s.charAt(0);
		for(int i=1;i<s.length();i++){
			last = cur;
			cur=s.charAt(i);		
			if(last+1==cur) {
				sb.append(cur);
			}
			else{
				if(sb.length()>=2) result.add(sb.toString());
				sb = new StringBuilder();
				sb.append(cur);
			}
		}
		if(sb.length()>=2) result.add(sb.toString());
		return result;
		
	}
	

}
