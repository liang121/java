
public class StringMultiply {
	public static void main(String[] args){
		String s1 = "999";
		String s2 = "99";
		String res = multiply(s1,s2);
		System.out.println(res);
		
	}
	//String res = "";
	public static String multiply(String s1, String s2){
		if(s1.length()==0||s2.length()==0) return null;
		int[] c = new int[s1.length()+s2.length()];
		int carry = 0;
		String res = "";
		for(int p1 = s1.length()-1;p1>=0;p1--){
			char c1 = s1.charAt(p1);
			int v1 = c1-'0';
			for(int p2 = s2.length()-1;p2>=0;p2--){
				char c2 = s2.charAt(p2);
				int v2 = c2-'0';
				c[p1+p2+1] += (v1*v2)%10;
				carry = (v1*v2)/10;
				if(c[p1+p2+1]>=10){
					carry++;
					c[p1+p2+1] = c[p1+p2+1]%10;
				}
				c[p1+p2] += carry;
				if(c[p1+p2]>=10){
					c[p1+p2-1] += 1;
					c[p1+p2] = c[p1+p2]%10;
				}
			}
		}
		int flag = 0;
		for(int i=0;i<c.length;i++){
			if(c[i]!=0) flag=1;
			if(flag==1) res += c[i];
		}
		return res;
	}

}
