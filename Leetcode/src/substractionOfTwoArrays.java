import java.util.*;
/*
 * Suppose you want to do the subtraction of two numbers. Each digit of 
 * the numbers is divided and put in an array. Like A=[1,2, 3, 4, 5], 
 * B=[4, 5, 3, 5]. You should output an array C=[7, 8, 1, 0].Remember 
 * that your machine can¡¯t hand numbers larger than 20.
 * 
 * http://www.cnblogs.com/superbo/p/4107320.html
 */
import java.util.zip.Adler32;

public class substractionOfTwoArrays{
    public static void main(String[] args){
    	int [] arr1 = {2,5,7,5} ;
   	    int [] arr2 = {3,4,8,9} ;
   	    //System.out.println(substractArray(arr1, arr2).toString());
   	    ArrayList<Integer> res = substractArray(arr1, arr2);
   	    
   	    System.out.println(res.toString());
   	   // System.out.println(subtraction(arr1, arr2).toString());
    }
    public static ArrayList<Integer> addition(int[] a1,int[] a2){
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	int p1=a1.length-1;
    	int p2=a2.length-1;
    	int val1=0;
    	int val2=0;
    	int carry=0;
    	while(p1>=0||p2>=0||carry==1){
    		if(p1>=0){
    			val1=a1[p1];
    			p1--;
    		}
    		else val1=0;
    		if(p2>=0){
    			val2=a2[p2];
    			p2--;
    		}
    		else val2=0;
    		
    		int v = (val1+val2+carry)%10;
    		carry = (val1+val2+carry)/10;
    		res.add(0,v);
    	}
    	return res;
    }
    public static ArrayList<Integer> subtraction(int[] a1,int[] a2){
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	int p1=a1.length-1;
    	int p2=a2.length-1;
    	int val1=0;
    	int val2=0;
    	int carry=0;
    	while(p1>=0||p2>=0){
    		if(p1>=0){
    			val1=a1[p1];
    			p1--;
    		}
    		else val1=0;
    		if(p2>=0){
    			val2=a2[p2];
    			p2--;
    		}
    		else val2=0;
    		int v=0;
    		if(val1+carry>=val2) {
    			v=val1+carry-val2;
    			carry=0;
    		}
    		else{
    			carry=-1;
    			v=val1+10-val2;
    		}

    		res.add(0,v);
    	}
    	return res;
    }

    public static ArrayList<Integer> substractArray(int [] a1,int [] a2){
    	if(a1[0]>0&&a2[0]>0) return twoPositive(a1,a2);
    	if(a1[0]<0&&a2[0]<0) return twoNegative(a1,a2);
    	if(a1[0]<0&&a2[0]>0) return negMPos(a1,a2);
    	if(a1[0]>0&&a2[0]<0) return PosMNeg(a1,a2);
    	return null;
    }
    public static ArrayList<Integer> twoPositive (int [] a1,int [] a2){
    	
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	if(a1.length<a2.length){
    		res = subtraction(a2,a1);
    		int val = res.get(0);
    		res.set(0, -val);
    		return res;
    	}
    	else if(a1.length>a2.length){
    		res = subtraction(a2,a1);
    		return res;
    	}
    	else{
    		int i=0;
    		while(i<a1.length&&a1[i]==a2[i]){
    			i++;
    		}
    		if(i==a1.length){
    			res.add(0);
    			return res;
    		}
    		if(a1[i]<a2[i]){
    			res = subtraction(a2,a1);
    			while(res.get(0)==0){
           	    	res.remove(0);
           	    }
        		int val = res.get(0);
        		System.out.println("/////////////////"+val);
        		
        		res.set(0, -val);
        		return res;
    		}
    		else{
    			res = subtraction(a2,a1);
        		return res;
    		}
    		
    	}
    }
    public static ArrayList<Integer> twoNegative (int [] a1,int [] a2){
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	res = twoPositive(a2, a1);
    	return res;
    }
 
    public static ArrayList<Integer> negMPos (int [] a1,int [] a2){
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	a1[0] = -a1[0];
    	res = addition(a1,a2);
    	res.set(0, -res.get(0));
    	return res;
    }
    
    public static ArrayList<Integer> PosMNeg (int [] a1,int [] a2){
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	a2[0] = -a2[0];
    	res = addition(a1,a2);
    	return res;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//	public static List<Integer> substractArray(int[] a, int[] b) {
//	    if(a == null || b == null)    return null;
//	    List<Integer> res = new ArrayList<Integer>();
//	    
//	    int ptr1 = a.length - 1;
//	    int ptr2 = b.length - 1;
//	    int carry = 0;
//	    int diff = 0;
//	    while(ptr1>=0 || ptr2>=0) {
//	        if(ptr2 >= 0) {
//	            diff = (10 + a[ptr1] - b[ptr2] - carry);
//	            carry = diff/10 == 1 ? 0 : 1;
//	            res.add(0, diff%10);
//	            ptr2--;
//	            ptr1--;
//	        }
//	        else if(ptr1 >= 0) {
//	            if(ptr1 == 0 && carry == 1 && a[ptr1] == 1) {    //special case first digits = 1;
//	                ptr1 --;
//	                continue;
//	            }
//	            diff = (10 + a[ptr1] - carry);
//	            carry = diff/10 == 1 ? 0 : 1;    
//	            res.add(0, diff%10);
//	            ptr1--;
//	        }                    
//	    }
//	    return res;
//	}
}