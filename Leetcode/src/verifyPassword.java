import java.util.ArrayList;
import java.util.Collections;

/*
 * Verify if the given password is valid/invalid
 * 1. must be 5-12 characters long 
 * 2. must contain at least one number and one lower case character 
 * 3. a sequence must not be followed by the same sequence 
 * (like 123123qs is invalid, 123qs123 is valid)
 */

public class verifyPassword {

	public static void verifyPasswd(String passwd) {
		if (!checkLen(passwd))
			return;
		if (!checkChar(passwd))
			return;
		if (!checkSeq(passwd))
			return;
		System.out.println("Valid Passwd");
	}

	private static boolean checkSeq(String passwd) {
		
		
		for (int i = 0; i < passwd.length(); i++) {
			int index1 = i;
			//char c1 = passwd.charAt(index);
			int index2 = passwd.indexOf(passwd.charAt(index1), index1 + 1);
			if (index2 != -1) {
				String str1 = passwd.substring(index1, index2);
				if(2*index2-index1>=passwd.length()) break;
				String str2 = passwd.substring(index2, 2 * index2 - index1);
				System.out.println(str1+" "+str2);
				if(str1.equals(str2)){
					return false;
				}
			}
		}
		return true;
	}

	private static boolean checkChar(String passwd) {
		char[] chars = passwd.toCharArray();
		boolean num_flag = false;
		boolean lowercase_flag = false;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] >= '0' && chars[i] <= '9') {
				num_flag = true;
			}
			if (chars[i] >= 'a' && chars[i] <= 'z') {
				lowercase_flag = true;
			}
		}
		if (num_flag && lowercase_flag) {
			return true;
		}
		return false;
	}

	private static boolean checkLen(String passwd) {
		if (passwd.length() < 5 || passwd.length() > 12) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		verifyPasswd("1acabcdghabc");
	}

}