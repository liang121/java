package bloomberg;

public class find_two_max_nums {
	public static void main(String[] args){
		
		//problem 1
		int[] a = {4,3,8,6,2,6,4,12,5,9};
		int max1=Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++){
			if(a[i]>max1){
				max2 = max1;
				max1 = a[i];
			}
			else if(a[i]>max2) max2 = a[i];
		}
		System.out.println(max2+" "+max1);
	}
		//problem2
//		String str1 = "abcd343";
//		String str2 = "efghertrwer";
//		String result = "";
//		int p1=0;
//		int p2=0;
//		char c1 = '\0';
//		char c2 = '\0';
//		while(p1<str1.length()||p2<str2.length()){
//			if(p1<str1.length()) c1 = str1.charAt(p1);
//			else{
//				while(p2<str2.length()){
//					result += str2.charAt(p2);
//					p2++;
//				}
//				break;
//			}
//			if(p2<str2.length()) c2 = str2.charAt(p2);
//			else {
//				while(p1<str1.length()){
//					result += str1.charAt(p1);
//					p1++;
//				}
//				break;
//			
//			}
//			result = result + c1+c2;
//			p1++;
//			p2++;
//		}
//		System.out.println(result);
//	}
	
}
