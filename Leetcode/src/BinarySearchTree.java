import java.util.ArrayList;
import java.util.Stack;

public class BinarySearchTree {
	
	public TreeNode buildTree (int[] nums){
		if(nums.length==0) return null;
		int start = 0;
		int end = nums.length-1;
		return help(start,end,nums);
	}
	public TreeNode help(int start, int end, int[]nums){
		if(start>end) return null;
		int mid = (start+end)/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = help(start,mid-1,nums);
		root.right = help(mid+1,end,nums);
		return root;
	}
	public ArrayList preorder(TreeNode root){
		TreeNode cur = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(cur==null) return res;
		stack.add(cur);
		while(!stack.isEmpty()){
			cur = stack.pop();
			res.add(cur.val);
			if(cur.right!=null) stack.add(cur.right);
			if(cur.left!=null) stack.add(cur.left);
		}
		return res;
		
	}
//	public ArrayList inorder(TreeNode root){
//		
//	}

}
