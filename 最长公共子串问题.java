/*给定两个字符串str1和str2，返回两个字符串的最长公共子串
举例：str1 = "1AB2345CD",str2="12345EF",返回"2345".
如果str1长度为M,str2长度为N，实现时间复杂度为O(M*N),额外空间复杂度为O(1)
*/
public int[][] getdp(char[][] str1, char[][] str2){
	int[][] dp = new int[str1.length][str2.length];
	for(int i = 0; i < str1.length; i++){
		if(str1[i] == str2[0]){
			dp[i][0] = 1;
		}
	}
	for(int j = 1; j < str2.length; j++){
		if(str2[j] == str1[0]){
			dp[0][j] = 1;
		}
	}
	for(int i = 1; i < str1.length; i++){
		for(int j = 1; j < str2.length; j++){
			if(str1[i] == str2[j]){
				dp[i][j] == dp[i-1][j-1] + 1;
			}
		}
	}
	return dp;
}

public String lcst1(String str1, String str2){
	if(str1 == null || str2 == null || str1.equals("") || str2.equals("")){
		return "";
	}
	char[] chs1 = str1.toCharArray();
	char[] chs2 = str2.toCharArray();
	int[][] dp = getdp(chs1,chs2);
	int end = 0;
	int max = 0;
	for(int i  = 0; i < str1.length; i++){
		for(int j = 0; j < str2.length; j++){
			if(dp[i][j]>max){
				max = dp[i][j];
				end = i;
			}
		}
	}
	return str1.substring(end - max + 1, end + 1);
}

public String lsct2(String str1, String str2){
	if(str1 == null || str2 ==  null || str1.equals("") || str2.equals("")){
		return "";
	}
	char[] chs1 = str1.toCharArray();
	char[] chs2 = str2.toCharArray();
	int max = 0;
	int end = 0;
	int row = 0;
	int col = chs2.length - 1;
	while(row < chs1.length){
		int len = 0;
		int i = row;
		int j = col;
		while(i < chs1.length && j < chs2.length){
			if(chs1[i] != chs2[j]){
				len = 0;
			}else{
				len++;
			}
			if(len > max){
				end = i;
				max = len;
			}
			i++;
			j++;
		}
		if(col > 0){
			col--;
		}else{
			row++;
		}
	}
	return str1.substring(end - max + 1, end + 1);
}




