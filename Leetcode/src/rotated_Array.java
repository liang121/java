package bloomberg;
//然后就是reverse words, 用python两行就搞定了。 可能觉得写得太容易了，让我把python里reverse函数自己写一遍，
//然后又让我把split函数写一遍。之后问了问如果要test 这个函数，有什么case要试的。再之后就让写了写 一次有多个空格，要保持这么多空格怎么办。
public class rotated_Array {
	 public void rotate(int[] nums, int k) {
	       if(nums.length==0) return;
	       k = k%nums.length;

	       reverse(nums, 0, nums.length - 1);
	       reverse(nums, 0, k - 1);
	       reverse(nums, k, nums.length - 1);
	}

	public void reverse(int[] nums, int start, int end) {
	    while (start < end) {
	        int temp = nums[start];
	        nums[start] = nums[end];
	        nums[end] = temp;
	        start++;
	        end--;
	    }
	}

}
