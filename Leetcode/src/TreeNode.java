
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int v){
		this.val = v;
	}
	public int getData()
	{
		return val;
	}
	public TreeNode getleft()
	{
		return left;
	}
	public TreeNode getright()
	{
		return right;
	}

	public void setNode(int data,TreeNode lc,TreeNode rc){
		this.val = data;
		left = lc;
		right = rc;
	}
	
	public TreeNode(){
		
	}

}
