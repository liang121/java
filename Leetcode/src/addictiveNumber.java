import java.util.Arrays;

/*
 * Addictive Number
 * 
 * Problem:Additive numbers are defined to be a positive 
 * integer whose digits form an additive sequence. 
 * E.g. 11235 (1+1=2, 1+2=3, 2+3=5). What makes it difficult
 * is that 12,122,436 is also one (12+12=24, 12+24=36). 
 * Given a range of integers, find all the additive 
 * numbers in that range.
 */


public class addictiveNumber {
	public static void main(String[] args) {
		doTests();
		//addictiveNumberInRange(1,1000000);
	}
	
	public static void addictiveNumberInRange(int l, int r) {
		for (int i = l; l <= r; i++) {
			if (isAddictiveNumber(String.valueOf(i))) {
				System.out.println(i);
			}
		}
	}

	
	public static boolean isAddictiveNumber(String s) {		
		for (int i = 1; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				String s1 = s.substring(0, i);
				if(s1.length()>1&&s1.charAt(0)=='0') continue;
				String s2 = s.substring(i,j);
				if(s2.length()>1&&s2.charAt(0)=='0') continue;
				int part1 = Integer.parseInt(s1);
				int part2 = Integer.parseInt(s2);
				int index = j;
				int rest = Integer.parseInt(s.substring(j, s.length()));
				while (part1 + part2 <= rest) {
					int part3 = part1 + part2;
					String str = String.valueOf(part3);
					int length = str.length();
					if (index + length > s.length()) {
						break;
					}
					if (s.substring(index, index + length).equals(str)) {
						index = index + length;
						if (index == s.length()) {
							System.out.println(part1+" "+part2);
							return true;
						}
						part1 = part2;
						part2 = part3;
						rest = Integer.parseInt(s.substring(index, s.length()));
					} else {
						break;
					}
				}
			}
		}
		return false;
	}
	
	public static void doTests() {
		if (isAddictiveNumber("1012")) {
			System.out.println("Good!");
		} else {
			System.out.println("Failed!");
		}
	}
}
