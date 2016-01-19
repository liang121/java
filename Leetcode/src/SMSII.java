
public class SMSII {
	public static String[] map ={"0","1","ABC2","DEF3","GHI4","JKL5","MNO6","PORS7","TUV8","WXYZ9"," "};
	public static void main(String[] args){
		String str = "AB1B";
		System.out.println(translate(str));
	}
	public static String translate(String str){
		StringBuilder sb = new StringBuilder();
		int[] last = getIndex(str.charAt(0));
		int[] cur = last;
		for(int i=1;i<str.length();i++){
			char c = str.charAt(i);
			if((c>='0'&&c<='9')||(c>='A'&&c<='Z')){
				last = cur;
				cur = getIndex(c);
				if(last[1]==1) sb.append(last[0]);
				else{
					int temp = last[1];
					while(temp>0){
						sb.append(last[0]);
						temp--;
					}
				}
				if(cur[0]==last[0]) sb.append("#");
			}
			else{
				System.out.println("input is not correct,please check it!!!");
				return "";
			}
		}
		if(cur[1]==1) sb.append(cur[0]);
		else{
			int temp = cur[1];
			while(temp>0){
				sb.append(cur[0]);
				temp--;
			}
		}
		return sb.toString();
		
	}
	public static int[] getIndex(char c){
		int[] n = new int[2];
		for(int i=0;i<map.length;i++){
			int index = map[i].indexOf(c);
			if(index!=-1){
				n[0] = i;
				n[1] = index+1;
			}
		}
		return n;
	}

}
