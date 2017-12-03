//对于一个字符串，请设计一个算法，将字符串的长度为len的前缀平移到字符串的最后。要求时间复杂度是o(n),额外空间复杂度是o(1)
//给定一个字符串A和它的长度，同时给定len，请返回平移后的字符串。
/*
测试样例：
"ABCDE",5,3
返回："DEABC"
*/
public class Shift{
	public String stringShift(String str,int len, int n){
		char[] charArray = str.toCharArray();
		rotate(charArray, n);
		return String.valueOf(charArray);
	}
	public void rotate(char[] charArray, int n){
		if(charArray == null || n <= 0 || n >= charArray.length){
			return;
		}
		reverse(charArray, 0, n-1);
		reverse(charArray, n, length-1);
		reverse(charArray, 0, length-1);
	}
	public void reverse(char[] charArray, int start, int end){
		char tmp = 0;
		while(start < end){
			tmp = charArray[start];
			charArray[start] = charArray[end];
			charArray[end] = tmp;
			start++;
			end--;
		}
	}
}