package bloomberg;

public class merge_two_sortArray {
	public static void main(String[] args){
		int[] nums1 = new int[2];
		nums1[0] = 1;
		nums1[1] = 0;
		int[] nums2 = {2};
		merge(nums1,1,nums2,1);
		
	}
	 public void merge(int[] nums1, int m, int[] nums2, int n) {
	        int p1 = m-1;
	        int p2 = n-1;
	        int p = m+n-1;
	        int val1 = 0;
	        int val2 = 0;
	        while((p1>=0||p2>=0)&&p>=0){
	            if(p1>=0){
	                val1 = nums1[p1];
	            }
	            else val1 = Integer.MIN_VALUE;
	            if(p2>=0){
	                val2 = nums2[p2];
	            }
	            else val2 = Integer.MIN_VALUE;
	            if(val1>val2){
	                nums1[p] = val1;
	                p--;
	                p1--;
	            }
	            else{
	                nums1[p] = val2;
	                p--;
	                p2--;
	            }
	        }
	    }

}
