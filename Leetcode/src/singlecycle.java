package bloomberg;

import java.util.HashSet;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class singlecycle {
	public static void main(String[] args){
		int[] a ={2,1,-1,-3};
		System.out.println(judge(a));
	}
	public static boolean judge(int[] a){
//		HashSet<Integer> set = new HashSet<Integer>();
//		//set.add(0);
//		for(int i=0;i<a.length;i++){
//			int temp = a[i]+i;
//			if(temp<0||temp>=a.length) return false;
//			else if(!set.contains(temp)) set.add(temp);
//			else return false;
//		}
//		return true;
		int count = 0;
		int post = 0;
		int i = a[0];
		while(count<a.length){
			count++;
			post = a[i]+i;
			i = post;
			if(post==0) break;
		}
		if(count!=a.length||post!=0) return false;
		else return true;
	}
	

}
