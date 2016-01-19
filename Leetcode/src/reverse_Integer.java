package bloomberg;

public class reverse_Integer {
	public int reverse(int x) {
        boolean sign = true;
        if(x<0) sign=false;
        if(x==0) return 0;
        x = Math.abs(x);
        long result = 0;
        while(x>0){
            int mod = x%10;
            result = result*10 + mod;
            x = x/10;
        }
        if(sign){
            if(result>Integer.MAX_VALUE) return 0;
            else return (int)(result);
        }
        else{
            result = -1*result;
            if(result<Integer.MIN_VALUE) return 0;
            else return (int)(result);
        }
        
    }

}
