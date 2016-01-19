package bloomberg;
//Ȼ�����reverse words, ��python���о͸㶨�ˡ� ���ܾ���д��̫�����ˣ����Ұ�python��reverse�����Լ�дһ�飬
//Ȼ�������Ұ�split����дһ�顣֮�����������Ҫtest �����������ʲôcaseҪ�Եġ���֮�����д��д һ���ж���ո�Ҫ������ô��ո���ô�졣
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
