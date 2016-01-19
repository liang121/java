package bloomberg;

import java.util.HashMap;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Delet_dup_inString {
	public static void main(String[] args){
		String str = "assetteshgghs";
		HashMap<Character, Integer> map = new HashMap<Character,Integer>();
	    int len = str.length();
		for(int i=0;i<str.length();i++){
	    	char c = str.charAt(i);
	    	if(!map.containsKey(c)) map.put(c,i);
	    	else len--;
	    }
		int[] array1 = new int[str.length()];
		int[] result = new int[len];
		for(Character c:map.keySet()){
			int i = map.get(c);
			array1[i] = c;
		}
		int j=0;
		for(int i=0;i<array1.length;i++){
			if(array1[i]!='\0') {
				result[j] = array1[i];
				j++;
			}
		}
		for(int i=0;i<result.length;i++){
		System.out.print((char)(result[i]));
		}
	}
	

}
