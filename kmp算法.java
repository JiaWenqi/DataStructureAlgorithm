//给定两个字符串str和match，长度分别为N和M。实现一个算法，如果字符串str中含有子串match，
//则返回match在str中的开始位置，不含有则返回-1；
//要求：如果match的长度大于str的长度（M>N），str必然不会含有match，可直接返回-1.但是如果N>=M,要求算法复杂度为O(N)
public int getIndexOf(String s, String m){
	if(s == null || m == null || m.length < 1 || s < m){
		return -1;
	}
	char[] ss = s.toCharArray();
	char[] ms = m.toCharArray();
	int si = 0;
	int mi = 0;
	int[] next = getNextArray(ms);
	while(si < ss.length && mi < ms.length){
		if(ss[si] == ms[mi]){
			si++;
			mi++;
		}else if(next[mi] == -1){
			si++;
		}else{
			mi = next[mi];
		}
	}
	return mi == ms.length ? si - mi : -1;
}

//得到next数组
public int[] next(int[] ms){
	if(ms.length == 1){
		return new int[] {-1};
	}
	int[] next = new int[ms.length];
	next[0] = -1;
	next[1] = 0;
	int cn = 0;
	int pos = 2;
	while(pos < next.length){
		if(ms[pos - 1] == ms[cn]){
			next[pos++] = ++cn;
		}else if(cn > 0){
			cn = next[cn];
		}else{
			next[pos++] = 0;
		}
		return next;
	}
}