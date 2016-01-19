
public class BinaryTree {


		public static TreeNode createTree(TreeNode root, int[]a, int i)
		{
			if(i < a.length)
			{
				if(a[i] == 0)
				{
					root = null;
				}
				else
				{
					TreeNode tl = new TreeNode();
					TreeNode tr = new TreeNode();
					root.setNode(a[i],createTree(tl,a,++(Counter.count)),createTree(tr,a,++(Counter.count)));
				}
				
			}
			return root;
		}
		public static void traverse(TreeNode root)
		{
			if(root != null)
			{
				System.out.print(root.getData());
				traverse(root.getleft());
				traverse(root.getright());
			}
		}

	

}
