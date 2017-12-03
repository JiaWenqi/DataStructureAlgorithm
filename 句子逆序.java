//对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
//给定一个原字符串A和他的长度，请返回逆序后的字符串。
/*
测试样例：
"dog loves pig",13
返回："pig loves dog"
*/
public class Reverse{
	public String reverseSentence(String str){
		if(str == null || str.length() == 0){
			return str;
		}
		char[] charArr = str.toCharArray();
		rotateWord(charArr);
		return String.valueOf(charArr);
	}
	
	public void rotateWord(char[] charArr){
		if(charArr == null || charArr.length == 0){
			return;
		}
		reverse(charArr, 0, charArr.length-1);
		int l = -1;
		int r = -1;
		for(int i = 0; i < charArr.length; i++){
			if(charArr[i] != ' '){
				l = i == 0 || charArr[i - 1] == ' ' ? i : -1;
				r = charArr[i + 1] == ' ' || i == charArr.length ? i : -1;				
			}
			if(l != -1 && r != -1){
				reverse(charArr, l, r);
				l == -1;
				r == -1;
			}
		}
	}
	
	public void reverse(char[] charArr, start, end){
		char tmp = 0;
		while(start < end){
			tmp = charArr[start];
			charArr[start] = charArr[end];
			charArr[end] = tmp;
			start++;
			end--;
		}
	}
}