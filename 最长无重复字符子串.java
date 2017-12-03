//对于一个字符串,请设计一个高效算法，找到字符串的最长无重复字符的子串长度。
//给定一个字符串A及它的长度n，请返回它的最长无重复字符子串长度。保证A中字符全部为小写英文字符，且长度小于等于500。
/*
测试样例：
"aabcb",5
返回：3
*/
public int longestSubString(String str, int n){
	if(str == null || n == 0){
		return 0;
	}
	char[] chas = str.toCharArray();
	int[] map = new int[256];
	for(int i = 0; i < 256; i++){
		map[i] = -1;
	}
	int pre = -1;
	int cur = 0;
	int len = 0;
	for(int i = 0; i < chas.length; i++){
		pre = Math.max(pre, map[chas[i]]);
		cur = i - pre;
		len = Math.max(len,cur);
		map[chas[i]] = i;
	}
	return len;
}