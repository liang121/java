package bloomberg;

public class array_to_bst {
	public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        int l=0;
        int r=nums.length-1;
        return generate(l,r,nums);
    }
    public TreeNode generate(int l, int r,int[] nums){
        if(l>r) return null;
        int m=(l+r)/2;
        TreeNode root = new TreeNode(nums[m]);
        TreeNode left = generate(l,m-1,nums);
        TreeNode right = generate(m+1,r,nums);
        root.left = left;
        root.right=right;
        return root;
    }

}
