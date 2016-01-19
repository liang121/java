package bloomberg;

public class snake_search {
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false; 鏉ユ簮涓€浜�.涓夊垎鍦拌鍧�. 
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        while (x < m && y >= 0) {
            if(target == matrix[x][y])-google 1point3acres
                return true;
            else if (target < matrix[x][y]) {
                y--;
            } 鏉ユ簮涓€浜�.涓夊垎鍦拌鍧�. 
            else {
                x++;
            }
        }
        return false;. 鍥磋鎴戜滑@1point 3 acres
    }

}
