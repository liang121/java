import java.util.*;
/*
 * Goldbach's conjecture : Every even integer greater than 2 
 * can be expressed as the sum of two primes. Write a function
 * which takes a number as input, verify if is an even number 
 * greater than 2 and also print at least one pair of prime numbers.
 */
 
public class twoPrimes{
	// focus on the efficiency 
//	public static void main(String[] args){
//		generate(100);
//	}
//	
//	public static void generate(int num){
//		if(num%2==0){
//			for(int i=2;i<=num/2;i++){
//				if(isPrime(i) && isPrime(num-i)){
//					System.out.println(i+" "+(num-i));
//				}
//			}
//		}else{
//			System.out.println("Odd Number!");
//		}
//	}
//	
//	public static boolean isPrime(int num){
//		List<Integer> collect = new ArrayList<Integer>();
//		collect.add(2);
//		for(int i=2;i<=Math.sqrt(num)+1;i++){
//			for(Integer cand:collect){
//				if(num%cand == 0){
//					return false;
//				}
//			}
//			collect.add(i);
//		}
//		return true;
//	}
	public static void main(String[] args){
		System.out.println(findPairs(100).toString());
	}
	public static ArrayList<String> findPairs(int val){
		ArrayList<String> res = new ArrayList<String>();
		for(int i=0;i<val;i++){
			if(isPrime(val-i)&&isPrime(i)) res.add(i+"+"+(val-i));
		}
		return res;
		
	}
	public static boolean isPrime(int val){
		if(val<=1) return false;
		if(val==2) return true;
		if(val%2==0) return false;
		for(int i=3;i*i<val;i=i+2){
			if(val%i==0) return false; 
		}
		return true;
	}
}