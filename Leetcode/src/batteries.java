import java.util.*;
/*
 * http://blog.csdn.net/lsdtc1225/article/details/39949367
 * ����14��
 * �����6�ڰ�װ��9�ڰ�װ��20�ڰ�װ���֣�input��Ҫ���ٽڵ�أ�
 * ������Ըպ���3�ְ�װ�Ĵյ�����������������⣬ �����ǲ���Ҫ������еĽ⡣
 * e.g ����20�� ��{20} ����17 ��û�� ����18���ǿ�����{6,6,6}Ҳ������{9,9}�� 
 * �е�����Ǯ�����⣬�ƺ��ǴӼ������ҵ����м���ֵ����һ��target�����ļ򻯰棬��Ϊ����ֻ��6 9 20��
 * �����Ҫ��������п��ܣ�DFS
 */

public class batteries{
    public static void main(String[] args){
         int[] box = {2,6,9,20};
         int sum = 8;
         System.out.println(pack(box,sum).toString());
    }
    public static ArrayList<ArrayList<Integer>> pack(int[] box, int sum){
         ArrayList<Integer> r = new ArrayList<Integer>();
         ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
         dfs(box,sum,r,res,0); 
         return res;
    }
    public static void dfs(int[] box, int sum,ArrayList<Integer> r ,ArrayList<ArrayList<Integer>> res,int index){
         if(sum==0) {
             res.add(new ArrayList<Integer>(r));
             return;
         }
         if(sum<0) return;
         for(int i=index;i<box.length;i++){
             r.add(box[i]);
             dfs(box,sum-box[i],r,res,i);
             r.remove(r.size()-1);
         }
    }
}