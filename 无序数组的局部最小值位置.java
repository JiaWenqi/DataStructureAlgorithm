##用二分搜索法寻找无序数组局部最小值问题
public int getLessIndex(int[] arr){
	if(arr = null || arr.length == 0){
		return -1;
	}
	if(arr.length == 1 ||arr[0] < arr[1]){
		return 0;
	}
	if(arr[arr.length-1] < arr[arr.length-2]){
		return arr[arr.length-1];
	}
	int left = 1;
	int right = arr.length-2;
	int mid = 0;
	while(left < right){
		mid = (left + right) / 2;
		if(arr[mid - 1] < arr[mid]){
			right = mid - 1;
		}else if(arr[mid + 1] < arr[mid]){
			left = mid + 1;
		}else{
			return mid;
		}
	}
	return left;
}
