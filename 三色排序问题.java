//有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。
/*
给定一个只含0，1，2的整数数组A及它的大小，请返回排序后的数组。保证数组大小小于等于500。

测试样例：
[0,1,1,0,2,2],6
返回：[0,0,1,1,2,2]
*/
public int[] sortThreeColor(int[] arr, int n) {
	// write code here
	if(arr == null || arr.length < 2){
		return;
	}
	int left = -1;
	int right = arr.length;
	int index = 0;
	while(index < right){
		if(arr[index] == 0){
			swap(arr, ++left, index);
		}else if(arr[index] == 2){
			swap(arr, index, --right);
		}else{
			index++;
		}
	}
	return arr;
}
public void swap(int[] arr, int index1, int index2) {
	int tmp = arr[index1];
	arr[index1] = arr[index2];
	arr[index2] = tmp;
}
