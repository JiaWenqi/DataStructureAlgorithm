//对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。
//给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。
//可以用固定长度的数组代替哈希表结构 时间复杂度是o(N)，额外空间复杂度为o(N)
public boolean chkTransform(String str1,String str2){
	if(str1 == null || str2 == null || str1.length() != str2.length()){        //字符串是length()函数
		return false;
	}
	char[] chs1 = str1.toCharArray();
	char[] chs2 = str2.toCharArray();
	int[] map = new int[256];
	for(int i = 0; i < chs1.length; i++){  //数组直接是length
		map[chs1[i]]++;
	}
	for(int i = 0; i < chs2.length; i++){
		if(map[chs2[i]]-- == 0){
			return false;
		}
	}
	return true;
}