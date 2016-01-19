package bloomberg;

public class dot_add {
	public static void main(String[] args){
		String a = "1234567891";
		int len = a.length();
		int m = len%3;
		StringBuffer res = new StringBuffer();
		for(int i=0;i<a.length();i++){
			if(i%3==1){
				res.append(',');
				res.append(a.charAt(i));
			}
			else res.append(a.charAt(i));
		}
		System.out.println(res.toString());
	}

}
