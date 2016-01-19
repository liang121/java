import java.util.*;
/*
 * Find the seed of a number
 * Eg : 1716 = 143*1*4*3 =1716 so 143 is the seed of 1716. 
 * find all possible seed for a given number.
 */

public class seedsNumber{
	public static void main(String[] args){
		//find(1716);
		System.out.println(findSeeds(1716).toString());
	}
	public static ArrayList<Integer> findSeeds(int val){
		 ArrayList<Integer> res = new  ArrayList<Integer> ();
		for(int i=0;i<=val;i++){
			int a = i;
			int multi = a;
			while(a>0){
				int v = a%10;
				multi *= v;
				a = a/10;	
			}
			if(val==multi) res.add(i);
		}
		return res;
	}

//	public static void find(int number){
//		List<Integer> res = new ArrayList<Integer>();
//		for(int i=1;i<=number;i++){
//			int sum = 1;
//			sum *= i;
//			int k = i;
//			while(k/10>0){
//				sum *= k%10;
//				k /= 10;
//			}
//			if(sum == number) res.add(i);
//		}
//		System.out.println(res);
//	}
}