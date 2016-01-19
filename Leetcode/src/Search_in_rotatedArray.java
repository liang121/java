package bloomberg;

public class Search_in_rotatedArray {
	public int search(int[] nums, int target) {
        if(nums.length==0) return 0;
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int m = (l+r)/2;
            if(nums[l]==target) return l;
            else if(nums[r]==target) return r;
            else if(nums[m]==target) return m;
            else if(nums[l]<target&&target<nums[m]) r=m;
            else if(nums[m]<target&&target<nums[r]) l=m+1;
            else if(nums[l]>nums[m]) r=m;
            else l=m+1;
        }
        return -1;
    }

}
