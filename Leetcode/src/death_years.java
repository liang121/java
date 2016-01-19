package bloomberg;

import java.util.HashMap;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class death_years {
	public static void main(String[] args){
		int[] a = {3,4,1,2,1,4,3,6,9,3,5,4,4,7,9};
		int max = 0;
		int result = a[0];
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<a.length;i++){
			if(map.containsKey(a[i])){
				map.put(a[i], map.get(a[i])+1);
				if(max<map.get(a[i])) {
					result = a[i];
					max = map.get(a[i]);
				}
				else{
					max = max;
					result = result;
				}
			}
			else map.put(a[i],1);
		}
		System.out.println(result);
	}

}
