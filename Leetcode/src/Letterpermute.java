import java.util.ArrayList;
import java.util.List;

public class Letterpermute {
	public static void main(String[] args){
		String str="tree";
		System.out.println(permute(str).toString());
	}
	public static List<String> permute(String str) {

        List<String> re = new ArrayList<String>();
        if(str.length()==0) return re;
        char[] num = str.toCharArray();
        boolean[] visit=new boolean[num.length];
        helper(visit,num,"",re,num.length);
        return re;
	}
	public static void helper(boolean[] visit,char[] num,String res,List<String> re,int n ){
	    if(n==0) {
	    	re.add(res);
	    	return;
	    }
	    
	    for(int i=0; i<num.length; i++){
	    	if(visit[i]==false){
	    		if(i-1>=0&&visit[i-1]==true&&num[i-1]==num[i]) continue;
	    		visit[i]=true;
	    		helper(visit, num, res+num[i], re, n-1);
	    		visit[i]=false;
	    	}
//	       if(visit[i]==false){ 
//	       // visit[i]=true;
//	        re.add(num[i]);
//	        helper(visit,num,res,re,n-1);
//	        re.remove(re.size()-1);
//	        //visit[i]=false;
//	        //}
	    }
	}

}
