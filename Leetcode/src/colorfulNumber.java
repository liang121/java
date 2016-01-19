import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * A number can be broken into different sub-sequence parts. 
 * Suppose a number 3245 can be broken into parts 
 * like 3 2 4 5 32 24 45 324 245. And this number is a colorfulnumber, 
 * since product of every digit of a sub-sequence are different. 
 * That is,3 2 4 5 (3*2)=6 (2*4)=8 (4*5)=20 (3*2*4)= 24 (2*4*5)= 40. 
 * But 326 is not a colorful number as it generates 3 2 6 (3*2)=6 (2*6)=12. 
 * You have to write a function that tells if the given number 
 * is a colorful number or not.
 */

public class colorfulNumber{
	public static void main(String[] args){
		int a=3245;
		int b=326;
		System.out.println(3245 + " is a colourful number? "+isColorful(a));
		//System.out.println(326 + " is a colourful number? "+isColorful(b));
	}
	public static boolean isColorful(int a){
		String str = a+"";
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<str.length();i++){
			for(int j=1;i+j<=str.length();j++){//////////////////
				int s =Integer.parseInt(str.substring(i, i+j));//
				                                 ////////////////

				int mul = getMulti(s);
				if(set.contains(mul)) return false;
				else set.add(mul);
			}
		}
		return true;
	}
	public static int getMulti(int s){
		int mul = 1;
		while(s>0){
			mul *= s%10;
			s = s/10;
		}
		return mul;
	}

}
