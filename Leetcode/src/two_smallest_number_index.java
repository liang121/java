package bloomberg;

import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class two_smallest_number_index {
	public static void main(String[] args){
		int[] a = {4,2,8,6,2,6,4,12,5,9};
		int[] b = {4,3,8,6,2,6,4,12,5,9};
		int max = 0;
		int lagest = find_max(b).get(0);
		int sec_lagest = find_max(b).get(1);
		int min = find_min(a).get(0);
		int sec_min = find_min(a).get(1);
		if(find_min(a).get(3)==find_max(b).get(3)) max = Math.min(sec_lagest-min,lagest-sec_min);
		else max = lagest-min;
		System.out.println(find_min(a).toString());
		System.out.println(find_max(b).toString());
		System.out.println(max);
	}
	public static ArrayList<Integer> find_min(int[] a){
		ArrayList<Integer> min = new ArrayList<Integer>();
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		int index1 = 0;
		int index2 = 0;
		for(int i=0;i<a.length;i++){
			if(a[i]<first){
				second = first;
				index2 = index1;
				index1 = i;
				first = a[i];
			}
			else{
				if(a[i]<second) {
					second=a[i];
					index2 = i;
				}
				else continue;
			}

		}
		min.add(first);
		min.add(second);
		min.add(index1);
		min.add(index2);
		
		return min;
		
	}
	
	public static ArrayList<Integer> find_max(int[] a){
		int max1=Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int index1 = 0;
		int index2 = 0;
		for(int i=0;i<a.length;i++){
			if(a[i]>max1){
				max2 = max1;
				index2 = index1;
				index1 = i;
				max1 = a[i];
			}
			else if(a[i]>max2) {
				max2 = a[i];
				index2 = i;
			}
			
		}
		ArrayList<Integer> max = new ArrayList<Integer>();
		max.add(max1);
		max.add(max2);
		max.add(index1);
		max.add(index2);
		return max;
	}
	

}
