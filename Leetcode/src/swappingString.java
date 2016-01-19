import java.awt.Point;
import java.util.*;
/*
 * Given two strings, you need to transpose the first string to 
 * the second string by means of only swaps between 2 consecutive 
 * characters in the first string. This must be performed by doing a 
 * series of these swaps in order to get the second string.
 */

public class swappingString{
	public static void main(String[] args){
		String s1 = "abcd";
		String s2 = "cabd";
		Transpose(s1,s2);
		transpose(s1.toCharArray(),s2.toCharArray());
	}
	
	//////////////////////zhu yi str1[] de yun yong/////////////////////////////////////////////////////////////////
	public static void Transpose(String s1, String s2){    ////////////////////////////////////////////////////////////////
		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		ArrayList<String> path = new ArrayList<String>();
		for(int i=0;i<s2.length();i++){
			char c = s2.charAt(i);
			
			if(c!=str1[i]){
				//System.out.println(c);
				int index = -1;
				for(int j=i;j<str1.length;j++){
					if(str1[j]==c) index=j;
				}
				if(index ==-1) {
					System.out.println("The tow input string are not correct");
				    return;
				}
				else{
						while(index!=i){
							char temp = str1[index];
							str1[index]=str1[index-1];
							str1[index-1] = temp;
							index--;
							path.add(new String(str1));
						}
						continue;
				}
			}
		}
		System.out.println(path.toString());
	}
	public static void transpose(char[] s1, char[] s2) {
		ArrayList<String> path = new ArrayList<String>();
		for(int i=0;i<s2.length;i++){
			if(s1[i]==s2[i]) continue;
			else{
				int index=0;
				for(int j=i;j<s1.length;j++){
					if(s1[j]==s2[i]) index=j;  
				}
				while(index>0&&index!=i){
					char temp = s1[index];
					s1[index] = s1[index-1];
					s1[index-1]=temp;
					index--;
					path.add(new String(s1));
				}
				continue;
			}
		}
		System.out.println(path.toString());
		
	}

	
	
}
