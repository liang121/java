package bloomberg;

public class roman_integer {
	public static void main(String[] args){
		System.out.println(romanToInt("IIVV"));
		
	}
	public static int romanToInt(String s) {
	       if(s.length()==0) return 0;
	       int cur = getRomanValue(s.charAt(0));
	       int sub = cur;
	       int sum = 0;
	       for(int i=1;i<s.length();i++){
	           int last = cur;
	           cur = getRomanValue(s.charAt(i));
	           if(last == cur) sub += cur;
	           else if(last<cur) sub = cur-sub;
	           else{
	               sum += sub;
	               sub = cur;
	           }
	       }
	       sum += sub;
	       return sum;
	    }
	    public static int getRomanValue(char c){
	        switch (c){
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
