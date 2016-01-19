/*
 * Print the sequences from the input given by the user separated by semicolon 
 * e.g.: 4678912356012356 
 * output: 4;6789;123;56;0123;56;
 */

public class separateTheNumber{
	public static void main(String[] args){
		separate("4678912356012356");
		sep("4678912356012356");
	}
	public static void sep(String str){
		char last = '\0';
		char cur = str.charAt(0);
		StringBuilder sb = new StringBuilder();
		sb.append(cur);
		for(int i=1;i<str.length();i++){
			last = cur;
			cur = str.charAt(i);
			if(last+1==cur) sb.append(cur);
			else{
				sb.append(";");
				sb.append(cur);
			}
		}
		System.out.println(sb.toString());
	}
	public static void separate(String num){
		if(num.length()<2){
			System.out.print(num);
			return;
		}
		StringBuilder sb = new StringBuilder();
		char last = num.charAt(0);
		char curr = num.charAt(1);
		sb.append(last);
		for(int i=1;i<num.length();i++){
			curr = num.charAt(i);
			if(curr - last == 1){
				sb.append(curr);
			}else{
				sb.append(";");
				sb.append(curr);
			}
			last = curr;
		}
		System.out.println(sb.toString());
	}
}