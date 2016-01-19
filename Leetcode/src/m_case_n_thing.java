package bloomberg;

public class m_case_n_thing {
	public static void main(String[] args){
		int m=3;
		int n=7;
		get(m+1, n+1);
		
	}
	public static void get(int m, int n){
		int[][] dp = new int[m][n];
		dp[0][0] = 0;
		for(int i=1;i<m;i++){
			dp[i][1] = 1;
		}
		for(int i=1;i<n;i++){
			dp[1][i] = 1;
		}
		for(int i=2;i<m;i++){
			for(int j=2;j<n;j++){
				dp[i][j] =1;
				int temp = j;
				int lim = 0;
				if(j-i==2) lim=2;
				else lim = (j+1)/2;
				while(temp>=lim){
					dp[i][j] += dp[i-1][j-temp];
					temp--;
				}
				if(i==j) dp[i][j]=dp[i][j-1]+1;
				//System.out.print(dp[i][j]+" ");
			}
			//System.out.println();
		}
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
		System.out.println("result   "+dp[m-1][n-1]);
		//System.out.println(dp[1][1]);
	}

}
