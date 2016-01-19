import java.util.*;
/*
 * A number is called 'desirable' if all the digits are strictly 
 * ascending : 159 as 1<5<9. You know that your rival has a strictly 
 * numeric password that is 'desirable'. Your close ally has given 
 * you the number of digits (N) in your rival's password.takes in 'N' as 
 * input and prints out all possible 'desirable' numbers that can be 
 * formed with N digits.
 */
public class desirableNumber{
	public static void main(String[] args){
		System.out.println(getPassword(3).toString());
	}
	public static List<String> getPassword(int n){
		List<String> result = new ArrayList<String>();
		//List<List<Integer>> results = new ArrayList<List<Integer>>();

		dfs(result,"",n,0);
		return result;
	}
	public static void dfs(List<String> result,String results,int n,int index){
		if(n==0) {
			result.add(results);
			return;
		}
		//if(n<0) return;
		for(int i=index;i<=9;i++){
			//result.add(i);
			dfs(result, results+i, n-1, i+1);
			//result.remove(result.size()-1);
		}
	}
}