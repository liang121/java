//import java.util.ArrayList;
import java.util.*;
/*
 * Given a number find whether the digits in the number can be used to form 
 * an equation with + and '='. That is if the number is 123, we can have a 
 * equation of 1+2=3. But even the number 17512 also forms the equation 12+5=17.
 */

public class plusEqualNumber{
	public static void main(String[] args){
		int l=12358;
		int r = 321511;
		System.out.println(getNumber(l,r));
		//System.out.println(isAddictive(1012));
		
	}
	public static ArrayList<Integer> getNumber(int l, int r){
		ArrayList<Integer> res = new ArrayList<Integer>();
	    for(int i=l;i<=r;i++){
	    	if(isAddictive(i)&&isReductive(i)) res.add(i);
	    }
	    return res;
	}
	public static boolean isReductive(int num){
		String str = num+"";
		for(int i=1;i<str.length();i++){
			for(int j=i+1;j<str.length();j++){
				String s1 = str.substring(0, i);
				if(s1.length()>1&&s1.charAt(0)=='0') continue;
				String s2 = str.substring(i,j);
				if(s2.length()>1&&s2.charAt(0)=='0') continue;
				int part1 = Integer.parseInt(s1);
				int part2 = Integer.parseInt(s2);
				if(part1<part2) continue;
				int rest = Integer.parseInt(str.substring(j,str.length()));
				int index = j;
				while(part1-part2<=rest){
					int part3 = part1-part2;
					String s = part3+"";
					int len = s.length();
					if(index+len>str.length()) break;
					if(s.equals(str.substring(index,index+len))){
						if(index+len==str.length()) return true;
						part1 = part2;
						part2 = part3;
						if(part1<part2) break;
						index = index+len;
						rest = Integer.parseInt(str.substring(index,str.length()));
					}
					else break;
				}
			}
		}
		return false;
	}

	public static boolean isAddictive(int num){
		String str = num+"";
		for(int i=1;i<str.length();i++){
			for(int j=i+1;j<str.length();j++){
				String s1 = str.substring(0, i);
				if(s1.length()>1&&s1.charAt(0)=='0') continue;
				String s2 = str.substring(i,j);
				if(s2.length()>1&&s2.charAt(0)=='0') continue;
				int part1 = Integer.parseInt(s1);
				int part2 = Integer.parseInt(s2);
				int rest = Integer.parseInt(str.substring(j,str.length()));
				int index = j;
				while(part1+part2<=rest){
					int part3 = part1+part2;
					String s = part3+"";
					int len = s.length();
					if(index+len>str.length()) break;
					if(s.equals(str.substring(index,index+len))){
						if(index+len==str.length()) return true;
						part1 = part2;
						part2 = part3;
						index = index+len;
						rest = Integer.parseInt(str.substring(index,str.length()));
					}
					else break;
				}
			}
		}
		return false;
	}
}