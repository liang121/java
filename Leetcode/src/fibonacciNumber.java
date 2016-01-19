import java.util.*;
/*
 * There is one kind of numbers call FibbonaciNumber, which satisfy 
 * the following situation:
 * A. can be split into several numbers;
 * B. The first two number are the same, the next number is equal to 
 * the sum of previous two
 * eg. 112 (2 = 1 + 1), 12,122,436(12 + 12 = 24,12 + 24 = 36)
 * If you are given a range by the user, find all numbers that are 
 * Fibonacci numbers.
 */
import java.util.*;


	public class fibonacciNumber {
		public static void main(String[] args){
			System.out.println(generate(1,12122437).toString());
		}
		public static ArrayList<Integer> generate(int l,int r){
			ArrayList<Integer> res = new ArrayList<Integer>();
			for(int i=l;i<=r;i++){
				if(is(i)) res.add(i);
			}
			return res;
		}
		public static boolean is(int num){
			String str = num+"";
			for(int i=1;i<str.length();i++){
				int j=i*2;
				if(j>=str.length()) break;
				int part1 = Integer.parseInt(str.substring(0, i));
				int part2 = Integer.parseInt(str.substring(i, j));
				if(part1!=part2) continue;
				int rest = Integer.parseInt(str.substring(j,str.length()));
				int index = j;
				while(part1+part2<=rest){
					int part3 = part1+part2;
					String s = part3+"";
					int len = s.length();
					if(index+len>str.length()) break;
					if(s.equals(str.substring(index,index+len))){
						if(index+len==str.length()) return true;
						part1=part2;
						part2=part3;
						index = index+len;
						rest = Integer.parseInt(str.substring(index,str.length()));
					}
					else break;
				}
			}
			return false;
		}
	}
