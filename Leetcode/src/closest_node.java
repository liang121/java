package bloomberg;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.RootPaneContainer;

public class closest_node {
	//static TreeNode result;
	int min_dif;
	public static void main(String[] args){
		
	}
	public static TreeNode root(TreeNode root, int target){

		TreeNode r;
		TreeNode l;

		int dif = root.val - target;
		if(dif==0){
			return root;
		}
		else if(dif<0)  {
			if(root.right==null) return root;
			r = root(root.right, target);
			if(Math.abs(target-root.val)>Math.abs(target-r.val)) return r;
		}
		else {
			if(root.left==null) return root;
			l = root(root.left, target);
			if(Math.abs(target-root.val)>Math.abs(target-l.val)) return l;
		}
		return root;
	}

	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int a){
			val = a;
		}
	}

}
