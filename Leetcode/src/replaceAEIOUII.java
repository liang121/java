
public class replaceAEIOUII {
	public static void main(String[] args){
		System.out.println(replace("aEisdfUwoe"));
		
	}
	public static String replace(String str){
		if(str.length()<=3) return str;
		int count=0;
		StringBuilder sb = new StringBuilder();
		//char[] str_arr = str.toCharArray();
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			String s = c+"";
			if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U'){
				count++;
				if(count<=3) {
					sb.append(s);
					continue;
				}
				else{
					s = s+"^"; 
					sb.append(s);
				}
			}
	/////////////////////////////////////////////////////////
			else sb.append(c);//////////////////////////////
	///////////////////////////////////////////////////////
		}
		return sb.toString();
	}

}
