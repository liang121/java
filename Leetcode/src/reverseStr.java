import java.util.Stack;

public class reverseStr {
	public static void main(String[] args){
		int[] a = {3,4,2,1};
		System.out.println(revStr("1234567890",a));
	}
	public static String revStr(String str, int[] a){
		StringBuilder sb = new StringBuilder();
		///////////////////////////////////////////////
		Stack<String> stack = new Stack<String>();/////
		////////////////////////////////////////////////
		int left=0;
		int right = 0;
		for(int i=a.length-1;i>=0;i--){
			left = right;
			////////////////////////////
			right = left+a[i];/////////
			//////////////////////////////
			stack.push(str.substring(left,right));
			System.out.println(sb.toString());
		}
		sb.append(stack.pop());
		while(!stack.isEmpty()) sb.append("-"+stack.pop());

		return sb.toString();
	}
	

}
