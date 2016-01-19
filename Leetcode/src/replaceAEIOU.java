import java.util.*;
/*
 * Replace a,e,i,o,u with A,E,I,O,U.
 * At most four eligible letters from the rear of the string are replaced.
 * The first three eligible letters in the string are always exempted 
 * from replacement.
 */

public class replaceAEIOU{
	public static void main(String[] args){
		String test = "ouaap";
		System.out.println(replace_aeiou(test));
	}
	public static String replace_aeiou(String str){
		if(str.length()<=3) return str;
		char list[] = str.toCharArray();
		int count = 0;
		int p = 0;
		for(int i=0;i<list.length;i++){
			char c = list[i];
			if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
				if(count<3) count++;
				if(count==3){				
					p=i;
					
					break;
				}
			}
		}
		count=0;
		for(int i=list.length-1;i>=0;i--){
			
			if(i<=p||count==4) break;
			char c = list[i];
			if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
				list[i] = (char)(c-32);
				count++;
			}
		}
		return new String(list);
	}

	
}