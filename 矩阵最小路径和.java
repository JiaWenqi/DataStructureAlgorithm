/*有一个矩阵map，它每个格子有一个权值。从左上角的格子开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。

给定一个矩阵map及它的行数n和列数m，请返回最小路径和。保证行列数均小于等于100.

测试样例：
[[1,2,3],[1,1,1]],2,3
返回：4
*/
public int minPathSum(int[][] m){
	if(m == null || m.length == 0 || m[0] == null || m[0].length == 0){
		return 0;
	}
	int row = m.length;
	int col = m[0].length;
	int[][] dp = new int[row][col];
	dp[0][0] = m[0][0];
	for(int i = 1; i < dp.length; i++){
		dp[i][0] = dp[i-1][0] + m[i][0];
	}
	for(int j = 1; j < dp[0].length; j++){
		dp[0][j] = dp[0][j-1] + m[0][j];
	}
	for(int i = 1; i < dp.length; i++){
		for(int j = 1; j < dp[0].length; j++){
			dp[i][j] = m[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
		}
	}
	return dp[row - 1][col - 1];
}

//空间压缩方法
public int minPathSum2(int[][] m){
	if(m == null || m.length == 0 || m[0].length == 0 || m[0] == null){
		return 0;
	}
	int more = Math.max(m.length, m[0].length);
	int less = Math.min(m.length, m[0].length);
	rowmore = more == m.length; //行数是不是大于等于列数
	int[] arr = new int[less]; //辅助数组的长度是行数和列数中的最小值
	arr[0] = m[0][0];
	for(int i = 1; i<less; i++){
		arr[i] = arr[i - 1] + rowmore ? m[0][i] : m[i][0];
	}
	for(int i = 1; i < more; i++){
		arr[0] = arr[0] + (rowmore ? m[i][0] : m[0][i]);
		for(int j = 1; j < less; j++){
			arr[j] = Math.min(arr[j-1], arr[j]) + (rowmore ? m[i][j] : m[j][i]);
		}
	}
}
