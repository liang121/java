
import java.util.List;
import java.util.ArrayList;

/*
 * A number is called as a stepping number if the adjacent 
 * digits are having a difference of 1. For eg. 8,343,545 are 
 * stepping numbers. While 890, 098 are not. The difference 
 * between a ¡®9¡¯ and ¡®0¡¯ should not be considered as1. 
 * Given start number(s) and an end number (e) your function 
 * should list out all the stepping numbers in the range including 
 * both the numbers s & e.
 */

public class steppingNumber {
	public static void main(String[] args){
		String str = "8343545";
		System.out.println(divided(str));
	}
	public static ArrayList<String> divided(String str){
		ArrayList<String> r = new ArrayList<String>();
		if(str.length()<=3){
			r.add(str);
			return r;
		}
		int index=0;
		StringBuilder sb = new StringBuilder();
		for(int i=str.length();i>=0;i=i-3){
			r.add(str.substring(i-3,i));
			if(i-3-3<0){
				index=i-3;
				break;
			}
		}
		r.add(str.substring(0,index));
		System.out.println(r.toString());
		return r;

	}
	
}


