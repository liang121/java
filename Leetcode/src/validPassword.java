/*
 * In 1-9 keypad one key is not working. If someone enters a password 
 * then not working key will not be entered. You have given expected 
 * password and entered password. Check that entered password is valid 
 * or not. Ex: entered 164, expected 18684 (you need to take care as 
 * when u enter 18684 and 164 only both will be taken as 164 input)
 */

public class validPassword{

	public static void main(String[] agrs){
		System.out.println(check("8186884","1464",'8'));
	}
	public static boolean check(String str1,String str2,Character key){
		int p1 = 0;
		int p2 = 0;
		while(p1<str1.length()&&p2<str2.length()){
			if(str1.charAt(p1)==str2.charAt(p2)){
				p1++;
				p2++;
			//	continue;
			}
			else{
				if(str1.charAt(p1)==key) p1++;
				else return false;
			}
		}
		
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		///////////////////////////////////////////////////////////////////////
		return p1==str1.length()&&p2==str2.length();//////////////////////////
		///////////////////////////////////////////////////////////////////////
			
		}
	}

