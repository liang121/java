package bloomberg;

import java.util.ArrayList;

public class random_song {
	public static void main(String[] args){
		int[] a = {1,2,3,4,5,6,7,8};
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<a.length;i++){
			list.add(a[i]);
		}
		int temp = a.length;
		for(int i=0;i<a.length;i++){
			int r = (int)(Math.random()*temp);
			System.out.println(list.get(r));
			list.remove(r);
			temp--;
			
		}
	}

}
