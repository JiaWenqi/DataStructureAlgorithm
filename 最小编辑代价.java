/*对于两个字符串A和B，我们需要进行插入、删除和修改操作将A串变为B串，定义ic，dc，rc分别为三种操作的代价，请设计一个高效算法，求出将A串变为B串所需要的最少代价。

给定两个字符串A和B，及它们的长度和三种操作代价，请返回将A串变为B串所需要的最小代价。保证两串长度均小于等于300，且三种代价值均小于等于100。

测试样例：
"abc",3,"adc",3,5,3,100
返回：8
*/
public int minCost1(String str1,String str2, int ic, int dc, int rc){
	if(str1 == null || str2 == null){
		return 0;
	}
	char[] chs1 = str1.toCharArray();
	char[] chs2 = str2.toCharArray();
	int row = chs1.length + 1;
	int col = chs2.length + 1;
	int[][] dp = new int[row][col];
	for(int i = 0; i < chs1.length; i++){
		dp[i][0] += dc; 
	}
	for(int j = 0; j < chs2.length; j++){
		dp[0][j] += ic;
	}
	for(int i = 1; i < row; i++){
		for(int j = 1; j < col; j++){
			if(chs1[i - 1] ==  chs2[j - 1]){
				dp[i][j] = dp[i-1][j-1];
			}else{
				dp[i][j] = dp[i-1][j-1]+rc;
			}
			dp[i][j] = Math.min(dp[i][j],dp[i-1][j] + dc);
			dp[i][j] = Math.min(dp[i][j],dp[i][j-1] + ic);
			
		}
	}
	return dp[row-1][col-1];
}

public int minCost2(String str1,String str2, int ic, int dc, int rc){
	if(str1 == null || str2 == null){
		return 0;
	}
	char[] chs1 = str1.toCharArray();
	char[] chs2 = str2.toCharArray();
	char[] longs = chs1.length >= chs2.length ? chs1 : chs2;
	char[] shorts = chs1.length < chs2.length ? chs1 : chs2;
	if(chs1 > chs2){
		int tmp = ic;
		ic = dc;
		dc = tmp;
	}
	int[] dp = new int[shorts.length + 1];
	for(int i = 1; i <= shorts.length; i++){
		dp[i] = ic * i;
	}
	for(int i = 1; i < longs.length; i++){
		int pre = dp[0];
		dp[0] = dc * i;
		for(int j = 1; j<shorts.length;j++){
			int tmp =dp[j];
			if(longs[i-1] == shorts.length){
				dp[j] = pre;
			} else {
				dp[j] = pre + rc;
			}
			dp[j] = Math.min(dp[j], dp[j-1] + ic);
			dp[j] = Math.min(dp[j], tmp + dc);
			pre = tmp;
		}
	}
	return dp[shorts.length];
}	
	
	
	
	
	