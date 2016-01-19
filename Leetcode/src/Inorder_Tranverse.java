package bloomberg;

public class Inorder_Tranverse {
	
	// tranverse method
//	 public List<Integer> inorderTraversal(TreeNode root) {
//	        List<Integer> res = new ArrayList<Integer>();
//	        if(root==null) return res;
//	        tranverse(res,root);
//	        return res;
//	    }
//	    public void tranverse(List<Integer> res, TreeNode root){
//	        if(root.left!=null) tranverse(res,root.left);
//	        res.add(root.val);
//	        if(root.right!=null) tranverse(res,root.right);
//	    }
	//Iterate method
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null) return res;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
