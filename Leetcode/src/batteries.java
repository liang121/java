import java.util.*;
/*
 * http://blog.csdn.net/lsdtc1225/article/details/39949367
 * 问题14：
 * 电池有6节包装，9节包装，20节包装三种，input需要多少节电池，
 * 如果可以刚好用3种包装的凑到这个数，就输出这个解， 忘了是不是要输出所有的解。
 * e.g 输入20， 答{20} 输入17 答没有 输入18，那可能是{6,6,6}也可能是{9,9}。 
 * 有点像找钱的问题，似乎是从集合中找到所有集合值等于一个target这个题的简化版，因为集合只有6 9 20。
 * 如果是要求输出所有可能：DFS
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