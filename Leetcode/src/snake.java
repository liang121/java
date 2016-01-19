import java.util.ArrayList;

public class snake {
	static ArrayList<ArrayList<Integer>> res;
	static int ROW;
	static int COL;
	static int max;
	static boolean[][] visited;
	public static void find(int[][] arr)
	{
		ROW =arr.length;
		if(ROW==0) return;
		COL = arr[0].length;
	 	res = new ArrayList<ArrayList<Integer>>();
	 	max = 0;
	 	visited = new boolean[ROW][COL];
	 	for(int row= 0;row<ROW;row++)
	 	{
	 		for(int col=0;col<COL;col++)
	 			//if(!visited[row][col])
	 				DFS(arr,row,col,0,new ArrayList<Integer>());
	 	}

	 	for(ArrayList<Integer> ls : res)
	 		System.out.println(ls);
	}
	public static void DFS(int[][] arr, int row, int col,int l_max,ArrayList<Integer> t_arr){
		t_arr.add(arr[row][col]);
		if(l_max>=max)
		{
			if(l_max>max)
			{
				res.clear();
				max = l_max;
			}
			res.add(new ArrayList<Integer>(t_arr));
		}
		if(col<arr[0].length-1 && Math.abs(arr[row][col]-arr[row][col+1]) ==1 )
		DFS(arr,row,col+1,l_max+1,t_arr);

	if(row<arr.length-1 && Math.abs(arr[row][col]-arr[row+1][col]) ==1 )
		DFS(arr,row+1,col,l_max+1,t_arr);

	t_arr.remove(t_arr.size()-1);	
    }
	public static void main(String[] args)
	{
		int[][] arr = {
						{ 1,3,2, 3,4},
						{-9,7,1,-1,3},
						{ 1,0,0, 1,9}
					  };

 		find(arr);
	}

}
