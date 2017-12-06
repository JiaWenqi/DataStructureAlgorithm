/*这是一个经典的LIS(即最长上升子序列)问题，请设计一个尽量优的解法求出序列的最长上升子序列的长度。

给定一个序列A及它的长度n(长度小于等于500)，请返回LIS的长度。

测试样例：
[1,4,2,5,3],5
返回：3
*/
public int[] getdp1(int[] arr){
	int[] dp = new int[arr.length];
	for(int i = 0; i < arr.length; i++){
		dp[i] = 1;
		for(int j = 0; j < i; j++){
			if(dp[i] > dp[j]){
				dp[i] = Math.max(dp[j] + 1,dp[i]);
			}
		}
	}
	return dp;
}

public int[] generateLIS(int[] arr, int[] dp){
	int len = 0;
	int index = 0;
	for(int i = 0; i < dp.length; i++){
		if(dp[i] > len){
			len = dp[i];
			index = i;
		}
	}
	int[] lis = new int[len];
	lis[--len] = arr[index];
	for(int i = index;i >= 0; i--){
		if(arr[i] < arr[index] && dp[i] == dp[index] - 1){
			lis[--len] = arr[i];
			index = i;
		}
	}
}

public int[] getdp2(int[] arr){
	int[] dp = new int[arr.length];
	int[] ends = new int[arr.length];
	ends[0] = arr[0];
	dp[0] = 1;
	int l = 0;
	int r = 0;
	int right = 0;
	int m = 0;
	for(int i = 1; i < arr.length; i++){
		l = 0;
		r = right;
		while(l <= r){
			m = (l+r)/2;
			if(arr[i] > ends[m]){
				l = m+1;
			}else{
				r = m-1;
			}
		}
		right = Math.max(right,l);
		ends[l] = arr[i];
		dp[i] = l+1;
	}
	return dp;
}

public int[] lis2(int[]){
	if(arr == null || arr.length == 0){
		return null;
	}
	int[] dp = getdp2(arr);
	return generateLIS(arr,dp);
}