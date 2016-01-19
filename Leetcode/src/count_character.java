package bloomberg;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class count_character {
	public static void main(String[] args){
		String a = "Mr. Smith lives at 1223 Hollywood Avenue";
		char cur = a.charAt(0);
		int num =1;
		char last = cur;
		StringBuffer result = new StringBuffer();
		for(int i=1;i<a.length();i++){
			if(a.charAt(i-1)==a.charAt(i)) num++;
			else{
				result.append(a.charAt(i-1));
				result.append(num);
				num=1;
			}
		}
		result.append(a.charAt(a.length()-1));
		result.append(num);
		System.out.println(result.toString());
	}
	

}
