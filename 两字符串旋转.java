//如果对于一个字符串A，将A的前面任意一部分挪到后边去形成的字符串称为A的旋转词。
//比如A="12345",A的旋转词有"12345","23451","34512","45123"和"51234"。对于两个字符串A和B，请判断A和B是否互为旋转词。
public class Rotation{
	public boolean chkRotation(String a, int lena, String b, int lenb){
		if(a == null || b == null || lena != lenb){
			return false;
		}
		a1 = a + a;
		return getIndexOf(a1, b) != -1;
	}
	##kmp
	public int getIndexOf(String s, String m){
		if(s == null || m == null || m.length() < 1 || s.length() < m.length()){
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int[] nextArr = getNextArr(ms);
		int si = 0;
		int mi = 0;
		while(si < ss.length && mi < ms.length){
			if(ss[si] == ms[mi]){
				si++;
				mi++;
			}else if(nextArr[mi] == -1){
				si++;
			}else{
				mi = nextArr[mi];
			}		
		}
		return mi == ms.length ? si - mi : -1;
	}
	public int[] getNextArr(Char[] ms){
		if(ms.length == 1){
			return new int[]{-1};
		}
		int[] nextArr = new int[ms.length];
		nextArr[0] = -1;
		nextArr[1] = 0;
		int pos = 2;
		int cn = 0;
		while(pos < nextArr.length){
			if(ms[pos-1]==mc[cn]){
				nextArr[pos++] = ++cn;
			}else if(cn > 0){
				cn = nextArr[cn];
			}else{
				nextArr[pos++] = 0;
			}
		}
		return nextArr;
	}
}
