import java.util.LinkedList;
import java.util.Stack;

/*
 * Given a string that has{},[],() and characters.Check if the string is 
 * balanced. E.g. {a[(b)]} is balanced. {a[(b])} is unbalanced.
 */

public class balancedString {
	public static void main(String[] args) {
		String input1 = "a[(b)]";
		String input2 = "a[(b])";
		String input3 = "a";
		String input4 = "";
		System.out.println(input1+" is a balanced string? "+judge(input1));
		System.out.println(input2+" is a balanced string? "+judge(input2));
		System.out.println(input3+" is a balanced string? "+judge(input3));
		System.out.println(input4+" is a balanced string? "+judge(input4));
	}
	public static boolean judge(String str){
		if(str.length()==0){
			System.out.println("oops!!The in put string is invalid!!!");
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(c=='('||c=='['||c=='{') stack.push(c);
			else if(c==')'){
				if(stack.isEmpty()||stack.pop()!='(') return false;
			}
			else if(c==']'){
				if(stack.isEmpty()||stack.pop()!='[') return false;
			}
			else if(c=='}'){
				if(stack.isEmpty()||stack.pop()!='{') return false;
			}
			else continue;
		}
		return stack.isEmpty();
	}
	
	
}
