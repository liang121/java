import java.util.*;
/*
 * You know a password is well-ordered string. 
 * Well-ordered string means that the order of the 
 * characters is in an alphabetical increasing order.
 * Like abEm is a well-ordered number. However,
 * abmE is not a well-order number. Given an input # that 
 * tells you also how many digits are in the password, 
 * print all possible passwords.
 */

public class wellOrderedString{
	//recursive method
	public static void main(String[] args){
//		char[] c = {'E','b','a'};
//		Arrays.sort(c);
//		System.out.println(new String(c));
		generate(3);
	}

	public static void generate(int num){
		List<String> res = new ArrayList<String>();
		dfs(res,"",0,num);
		System.out.println(res.toString());
	}
	public static void dfs(List<String> res, String str,int index,int num){
		if(num==0) {
			res.add(str);
			return;
		}
		for(int i=index;i<26;i++){
			//if(i==2) continue;
			dfs(res, str+(char)('a'+i), i+1, num-1);
			dfs(res, str+(char)('A'+i), i+1, num-1);
		}
	}
}