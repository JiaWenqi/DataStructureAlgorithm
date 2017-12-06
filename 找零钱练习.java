/*有数组penny，penny中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。

给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
测试样例：
[1,2,4],3,3
返回：2
*/
//这道题非常经典，可以体现暴力递归，记忆化搜索，以及动态规划之间的关系，并且可以在动态规划的基础上进一步进行优化
//首先是暴力递归
public int coins1(int[]arr, int aim){
	if(arr == null || arr.length == 0 || aim < 0){
		return 0;
	}
	return process1(arr, 0, aim);
}
public int process1(int[] arr, int index, int aim){
	int res = 0;
	if(index == arr.length){
		res = aim == 0 ? 1 : 0;
	}else{
		for(int i = 0; arr[index] * i < aim;i++){
			res += process1(arr, index + 1, aim - arr[index] * i);
		}
	}
	return res;
}
//暴力递归+记忆化搜索
public int coins2(int[]arr, int aim){
	if(arr == null || arr.length == 0 || aim < 0){
		return 0;
	}
	int[][] map = new int[arr.length + 1][aim + 1];
	return process2(arr, 0, aim, map);
}

public int process2(int[]arr, int index, int aim, int[][] map){
	int res = 0;
	if(index == arr.length){
		res = aim == 0 ? 1 : 0;
	}else{
		int mapValue = 0;
		for(int i = 0; arr[index] * i < aim; i++){
			mapValue = map[index + 1][aim - arr[index] * i];
			if(mapValue != 0){
				res += mapValue == -1 ? 0 : mapValue;
			}else{
				res += process2(arr, index + 1, aim - arr[index] * i, map);
			}
		}
	}
	map[index][aim] = res == 0? -1 : res;
	return res;
}
//动态规划
public int coins3(int[] arr, int aim){
	if(arr == null || arr.length == 0 || aim < 0){
		return 0;
	}
	int[][] dp = new int[arr.length][aim + 1];
	for(int i = 0; i < arr.length; i++){
		dp[i][0] = 1;
	}
	for(int j = 0; arr[0] * j < aim; j++){
		dp[0][arr[0]*j] = 1;
	}
	int num = 0;
	for(int i = 1; i < arr.length; i++){
		for(int j = 1; j <= aim; j++){
			num = 0;
			for(int k = 0; j - arr[i]*k >= 0; k++){
				num += dp[i-1][j - arr[i] * k];
			}
			dp[i][j] = num;
		}
	}
	return dp[arr.length - 1][aim];
}
//优化的动态规划方法
public int coins4(int[] arr, int aim){
	if(arr == null || arr.length == 0 || aim < 0){
		return 0;
	}
	int[][] dp = new int[arr.length][aim + 1];
	for(int j = 0; arr[0] * j < aim; j++){
		dp[0][arr[0] * j] = 1;
	}
	for(int i = 0; i < arr.length; i++){
		dp[i][0] = 1;
	}
	int num = 0;
	for(int i = 1; i < arr.length; i++){
		for(int j = 1; j <= aim; j++){
			dp[i][j] = dp[i-1][j];
			dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
		}
	}
	return dp[arr.length - 1][aim];
}
//动态规划+空间压缩方法
public int coins5(int[] arr, int aim){
	if(arr == null || arr.length == 0 || aim < 0){
		return 0;
	}
	int[] dp = new int[aim + 1]; 
	for(int j = 0; arr[0] * j < aim; j++){
		dp[j*arr[0]] = 1;
	}
	for(int i = 1; i<arr.length; i++){
		for(int j = 1; j<=aim; j++){
			dp[j] += j - arr[i] >= 0 ? dp[j - arr[i]] : 0;
		}
	}
	return dp[aim];
}

