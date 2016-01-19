package bloomberg;

public class level_order {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return results;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        TreeNode cur = root;
        que.add(cur);
        while(!que.isEmpty()){
            result = new ArrayList<Integer>();
            for(int i=que.size()-1;i>=0;i--){    //   ע�����Ҫ��ô �ɣ���Ϊque��size�Ǳ��
                cur = que.poll();
                if(cur.left!=null) que.add(cur.left);
                if(cur.right!=null) que.add(cur.right);
                result.add(cur.val);
            }
            results.add(result);
        }
        return results;
    }

}
