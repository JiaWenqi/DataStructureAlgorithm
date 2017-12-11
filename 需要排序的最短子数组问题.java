//对于一个数组，请设计一个高效算法计算需要排序的最短子数组的长度。
/*
给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的长度。(原序列位置从0开始标号,若原序列有序，返回0)。保证A中元素均为正整数。
*/
public int getMinArray(int[] arr){
	if(arr == null || arr.length < 2){
		return 0;
	}
	int noMinIndex = -1;
	int min = arr[arr.length - 1];
	for(int i = arr.length - 2; i > -1; i--){
		if(arr[i] > min){
			noMinIndex = i;
		}else{
			min = Math.min(min, arr[i]);
		}
	}
	if(noMinIndex == -1){
		return 0;
	}
	int noMaxIndex = arr.length;
	int max = arr[0];
	for(int i = 1; i < arr.length; i++){
		if(arr[i] < max){
			noMaxIndex = i;
		}else{
			max = Math.max(max, arr[i]);
		}
	}
	return noMaxIndex - noMinIndex + 1;
}
