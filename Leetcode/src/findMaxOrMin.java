import java.util.Scanner;

/*
 * Take a series of integers as input till a zero is entered. 
 * Among these given integers, find the maximum of the odd numbers and 
 * the minimum of the even integers (not including zero) and print them.
 */

public class findMaxOrMin {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int maxOdd = Integer.MIN_VALUE;
		int minEven = Integer.MAX_VALUE;
		while(true){
			int val = in.nextInt();
			if (val==0) break;

			
			if(val%2==0){
				System.out.println("asdfsadfasdfasdf");
				minEven = Math.min(minEven,val);
			}
			else maxOdd = Math.max(maxOdd, val);
		}
		if(maxOdd==Integer.MIN_VALUE) System.out.println("there is no max odd");
		else System.out.println("maxOdd is "+maxOdd);
		if(minEven==Integer.MAX_VALUE) System.out.println("there is no min even");
		else System.out.println("minEven is "+minEven);
		
		
	}
//	public static void main(String[] args) {
//		int[] res = new int[2];
//		Scanner in = new Scanner(System.in);
//		int maxOdd = Integer.MIN_VALUE;
//		int minEven = Integer.MAX_VALUE;
//		while(true){
//			int cur = in.nextInt();
//			if (cur == 0) {
//				break;
//			}
//		   if (cur % 2 == 0) {
//			   minEven = Math.min(cur, minEven);
//		   }else{
//			   maxOdd = Math.max(cur, maxOdd);
//		   }
//		  }
//		  if(maxOdd == Integer.MIN_VALUE) {
//			  System.out.println("no odd number exists");
//		  } else {
//			  System.out.println("maximum odd number is: " + maxOdd);
//		  }
//		  if(minEven == Integer.MAX_VALUE) {
//			  System.out.println("no even number exists");
//		  } else {
//			  System.out.println("minimum even number is: "+minEven);
//		  }
//		  res[0] = maxOdd;
//		  res[1] = minEven;
//	}
}
