package bloomberg;

import java.security.Signature;

public class String_to_Integer {
	public static void main(String[] args){
		String str = "-235457";
		int result = 0;
		boolean sign = true;
		int len = str.length();
		for(int i=0;i<=len-1;i++){
			char c = str.charAt(i);
			if(c=='-') {
				sign = false;
				continue;
			}
			if(c=='+') continue;
			result = 10*result + (c-'0');
		}
		if(!sign) result = -result;
		System.out.println( result);
	}

}
