//给定一个数组num，其中包含两个值，请不用任何额外变量交换这两个值，并将交换后的数组返回。
public int[] getSwap(int[] num){
	num[0] = num[0] ^ num[1];
	num[1] = num[0] ^ num[1];
	num[0] = num[0] ^ num[1];
	return num;
}