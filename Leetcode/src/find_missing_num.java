package bloomberg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class find_missing_num {
	// missing 1 num
	//First Missing Positive!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
//	 public int firstMissingPositive(int[] nums) {
//	        if(nums.length==0) return 1;
//	        for(int i=0;i<nums.length;i++){
//	            if(nums[i]-1==i) continue;
//	            else{
//	                
//	                int temp = nums[i]-1;
//	                while(temp>=0&&temp<nums.length&&nums[temp]-1!=temp){
//	                    int a = nums[temp];
//	                    nums[temp] = nums[i];
//	                    nums[i] = a;
//	                    temp = a-1;
//	                }
//	            }
//	        }
//	        for(int i=0; i<nums.length;i++){
//	            if(nums[i]!=i+1) return i+1;
//	        }
//	        return nums.length+1;
//	        
//	    }
	
	
	
	
//	public static void main(String[] args){
//		int[] input = {2,3,4,8,5,9,6,1};
//		int sum = (1+9)*9/2;
//		for(int i=0;i<input.length;i++){
//			sum = sum-input[i];
//		}
//		System.out.println(sum);
//	}
	// method 2
//	public static void main(String[] args){
//		int[] input = {2,3,4,8,5,9,6,1};
//		int x1=1;
//	    for(int i=2;i<=input.length+1;i++){
//	    	x1 ^= i;
//	    }
//	    int x2=input[0];
//	    for(int i=1;i<input.length;i++){
//	    	x2 ^= input[i];
//	    }
//	    System.out.println(x1^x2);
//	}
	public static void main(String[] args){
		int[] input = {2,3,4,8,9,6,1};
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<input.length;i++){
			set.add(input[i]);
		}
		int a=1;
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(a<input.length+1){
			if(!set.contains(a)) result.add(a);
			a++;
		}
		System.out.println(result.toString());
	}
}
