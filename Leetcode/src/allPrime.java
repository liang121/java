import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

public class allPrime{
	public static void main(String[] args){
		//find(100);
		System.out.println(isprime(103));
	}

//	public static ArrayList<Integer> find(int input){
//		ArrayList<Integer> result = new ArrayList<Integer>();
//		boolean[] judge = new boolean[input];
//		for(int i=2;i<input;i++){
//			if(judge[i]==false) {
//				result.add(i);
//				for(int j=1;j<input;j++){
//					if(i*j>=judge.length) break;
//					else judge[i*j]=true;
//				}
//
//			}
//		}
//		return result;
//	}

	public static boolean isprime(int a){
		if(a==2) return true;
		if(a%2==0) return false;
		for(int i=3;i*i<=a;i=i+2){
			if(a%i==0) return false;
		}
		return true;
	}
}