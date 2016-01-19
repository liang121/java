
public class Roman {
	public static void main(String[] args){
		System.out.println(romanToInt("IIIIIIV"));
	}
	public static int romanToInt(String s) {
	       if(s.length()==0) return 0;
	       int cur = getRomanValue(s.charAt(0));
	       int last = cur;
	       int sub = getRomanValue(s.charAt(0));
	       int total = 0;
	       for(int i=1; i<s.length();i++){
	           last = cur;
	           cur = getRomanValue(s.charAt(i));
	           if(cur>last){
	               sub = cur-sub;
	           }
	           else if(cur==last){
	               sub += cur;
	           }
	           else{
	               total += sub;
	               sub = cur;
	           }
	       }
	       total += sub;
	       return total;
	    }
	        	    public static int getRomanValue(char c) {
	    	        switch(c) {
	    	            case 'I': return 1; 
	    	            case 'V': return 5;
	    	            case 'X': return 10;
	    	            case 'L': return 50;
	    	            case 'C': return 100;
	    	            case 'D': return 500;
	    	            case 'M': return 1000;
	    	            default: return 0;
	    	        }
	    	    }

}
