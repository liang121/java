package bloomberg;

public class reverse_String {
	public static void main(String[] args){
		String result = "";
		String a = "string";
		for(int i=a.length()-1;i>=0;i--){
			result += a.charAt(i);
		}
		System.out.println(result);
	}

}
