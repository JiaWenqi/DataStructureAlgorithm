//请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
//给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。
/*
测试样例：
"Mr John Smith”,13
返回："Mr%20John%20Smith"
”Hello  World”,12
返回：”Hello%20%20World”
*/
public void replace(String str){
	if(str == null || str.length == 0){
		return;
	}
	int num = 0;
	char[] chs = str.toCharArray();
	for(int i = 0; i < str.length; i++){
		if(chs[i] == ' '){
			num++;
		}
	}
	ing j = str.length + 2 * num - 1;
	
	for(int i = str.length - 1; i > -1; i--){
		if(chs[i] != " "){
			chs[j--] = chs[i];
		}else{
			chs[j--] = '0';
			chs[j--] = '2';
			chs[j--] = '%';
		}
	}
}   
