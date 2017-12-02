//最长回文子串问题
public char[] manacherString(String str){
	char[] charArr = str.toCharArray();
	char[] resArr = new char[2 * charArr.length + 1];
	int index = 0;
	for(int i = 0; i<resArr.length; i++){
		resArr[i] = (i & 1) == 0 ? '#' : charArr[index++];
	}
	return resArr;
}
public int maxLcpsLength(String str){
	if(str == null || str.length == 0){
		return 0;
	}
	char[] charArr = manacherString(str);
	int[] pArr = new int[charArr.length];
	int index = -1;
	int pR = -1;
	for(int i = 0; i<charArr.length; i++){
		pArr[i] = pR > i?Math.min(pArr[2 * index -1],pR - i) : 1; 
		while(pArr[i] + i < pArr.length && i - pArr[i] > -1){
			if(charArr[i + pArr[i]] == charArr[i - pArr[i]]){
				pArr[i]++;
			}else {
				break;
			}
		}
		if(i + pArr[i] > pR){
			pR = i + pArr[i];
			index = i;
		}
		max = Math.max(max,pArr[i]);	
	}
	return max;
}