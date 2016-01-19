/*
 * Let the user enter a decimal number. The range allowed is 0.0001 to 0.9999.
 * Only four decimal places are allowed. The output should be an irreducible 
 * fraction. E.g.: If the user enters 0.35,the irreducible fraction will be 7/20.
 */

public class decimalNumber {
	public static void main(String[] args) {
		//doTests();
		double input = 0.015;
		System.out.println(getDN(input));
	}
	public static String getDN(double input){
		int a = (int)(input*10000);
		int b = 10000;
		int GCD = getGCD(a,b);
		StringBuilder sb = new StringBuilder();
		sb.append(a/GCD+"");
		sb.append("/");
		sb.append(b/GCD+"");
		return sb.toString();
	}
	public static int getGCD(int a,int b){
		int max_gcd = 1;
		for(int i=2;i<Math.min(a, b);i++){
			if(a%i==0&&b%i==0) max_gcd = Math.max(max_gcd, i);
		}
		return max_gcd;
	}
//	
//	public static void fraction(double input) {
//		int x = (int) (input * 10000);
//		int div = GCD(x, 10000);
//		System.out.println(x / div + "/" + 10000 / div);
//	}
//	
//	public static int GCD(int m, int n) {
//		if (m < n) {
//			int t = m;
//			m = n;
//			n = t;
//		}
//		if (m % n == 0) {
//			return n;
//		} else {
//			return GCD(n, m % n);
//		}
//	}
//	
//	public static void doTests() {
//		double input = 0.0505;
//		fraction(input);
//	}
}
