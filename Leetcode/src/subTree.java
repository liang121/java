package bloomberg;

public class subTree {
//	public static boolean isSubTree(TreeNode root,TreeNode root2){ 
//		if(root==null) return true; 
//		if(root2==null) return false; 
//		if(isIdentical(root,root2)) return true; 
//		else { 
//			return isIdentical(root,root2.left)||isIdentical(root,root2.right); 
//			} 
//		} 
//	public static boolean isIdentical(TreeNode root,TreeNode root2){ 
//		if(root==null&&root2==null) return true; 
//		if(root==null||root2==null) return false; 
//		if(root.val==root2.val) { 
//			return isSubTree(root.left,root2.left)&&isSubTree(root.right,root2.right); 
//			} 
//		else return false; 
//		} 
	public class TreeNode { 
		int val; 
		TreeNode left; 
		TreeNode right; 
		TreeNode(int x){ 
			val=x; 
			} 
		} 
}
