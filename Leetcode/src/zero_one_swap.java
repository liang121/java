package bloomberg;

public class zero_one_swap {
	public static void main(String[] args){
		int[] a = {1,0,0,1,1,0,1,1,0,0,1,1};
		//int l = 0;
		int r = a.length-1;
//		while(l<r){
//			while(r>=0&&a[r]==1) r--;
//			if(a[l]==0) l++;
//			else{
//				a[l] = 0;
//				a[r] = 1;
//				l++;
//				r--;
//			}
//		}
//		for(int i=0;i<a.length;i++){
//			System.out.print(a[i]);
//		}
		for(int l=0;l<a.length;l++){
			if(l==r) break;
			if(a[l]==0) continue;
			
			else{
				int temp = a[r];
				a[r] = a[l];
				a[l] = temp;
				l--;
				r--;
			}
			
		}
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]);
		}
		
	}

}
