import java.beans.Visibility;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Anagram {
	public static void main(String[] args){
		String input = "Oh my-god!";
		ArrayList<String> list = new ArrayList<String>();
		reording(input,"",list);
		System.out.println(list.toString());
	}
	public static void reording(String test, String res, ArrayList<String> list){
	    if(!list.contains(res+test)) list.add(res+test);
		if(test.length()==1) {
			if(!list.contains(res+test)) list.add(res+test);
			return;
		}
		for(int i=0;i<test.length();i++){
			char c1 = test.charAt(i);
			if(c1>='a'&&c1<='z'){
				for(int j=i+1;j<test.length();j++){
					char c2 = test.charAt(j);
					if(c2>='a'&&c2<='z'){
						char[] arr = test.toCharArray();
						char temp = arr[j];
						arr[j] = arr[i];
						arr[i] = temp;
						String newstr = new String(arr);
						reording(newstr.substring(i+1,test.length()), res+newstr.substring(0,i+1),list);
					}
				}
			}
		}
	}

}
