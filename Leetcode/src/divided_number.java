import java.util.ArrayList;

public class divided_number {
	public static void main(String[] args){
		int a = 1967863;
		int threshold = 9000;
		System.out.println(dividednum(a,threshold).toString());
	}
	public static ArrayList<Integer> dividednum(int a,int threshold){
		String str = a+"";
		ArrayList<Integer> res = new ArrayList<Integer>();
		int max = Integer.MIN_VALUE;
		for(int i=1;i<str.length();i++){
			int v1 = Integer.parseInt(str.substring(0, i));
			int v2 = Integer.parseInt(str.substring(i, str.length()));
			System.out.println(v1 + " "+ v2);
			if(v1+v2<= threshold){
				if(v1+v2>max){
					res.add(v1);
					res.add(v2);
					//////////////////////////////
					max = v1+v2;//////////////////
					//////////////////////////////
				}
				else continue;
			}
			else continue;
		}
		return res;
	}

}
