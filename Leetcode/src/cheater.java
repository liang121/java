import java.util.ArrayList;
import java.util.HashSet;

public class cheater {
	public static void main(String[] args){
		HashSet<String> set = new HashSet<String>();
		String[] array1={"0123","2124","1023","0123","2446","23561"};
		String[] array2={"0122","212","0123","0123","2446","2356"};
		ArrayList<String> res = new ArrayList<String>();
		for(int i=0;i<array1.length;i++){
			if(set.contains(array1[i])) continue;
			else {
				set.add(array1[i]);
				res.add(array1[i]);
			}
		}
		for(int i=0;i<array2.length;i++){
			if(set.contains(array2[i])) continue;
			else res.add(array2[i]);
		}
		System.out.println(res.toString());
	}

}
