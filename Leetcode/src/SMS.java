import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;
/*
 * You are given a telephone keymap
 * 0-0, 1-1, 2-ABC2, 3-DEF3, 4-GHI4, 5-JKL5, 
 * 6-MNO6,7-PQRS7, 8-TUV8, 9-WXYZ9, *-<space>, #-char separator
 * if you type "2", you will get 'A', that is "2"-'A', 
 * "22"-'B' ,"222"-'C', "2222"-'D'
 * However, the digits can repeated many times
 * "22222"-you get 'A' again -google 1point3acres
 * You can use "#" to separate characters, for example
 * "2#22", you get "AB". However, you may also have 
 * consecutive different digits without separator:"23"-'AD'
 * If you type "*", it means space. You a given a 
 * sequence of digits, translate it into a text message
 */

public class SMS {
	public static String[] map = {"0","1","abc2","def3","ghi4","jkl5","mno6","pqrs7","tuv8","wxyz9"," "};
	                            //0    1     2     3       4     5      6       7      8       9     *
	public static void main(String[] args){
		Translate("##2#23344*4");
	}
	public static void Translate(String str){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(c=='*') sb.append(" ");
			else if(c=='#') continue;
			else if(c>='0'&&c<='9'){
				int count=0;
				while(i+1<str.length()&&str.charAt(i+1)==str.charAt(i)){
					count++;
					i++;
				}
				sb.append(map[c-'0'].charAt(count%map[c-'0'].length()));
			}
			else{
				System.out.println("wrong input");
				return;
			}
			
		}
		System.out.println(sb.toString());
	
	}	

	
}

