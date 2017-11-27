##用二分搜索法寻找有序数组元素最左问题
//给定一个数组arr及它的大小n，同时给定num
public int Find(int[] arr, int n){
	if(arr == null || n == 0){
		return -1;
	}
	int left = 0;
	int right = arr.length - 1;
	int mid = 0;
	int res = -1;
	while(left <= right){
		if(arr[left] > left || arr[right] < right){
			return -1;
		}
		mid = (left + right) / 2;
		if(arr[mid] < mid){
			left = mid + 1;
		}else if(arr[mid] > mid){
			right = mid - 1;
		}else{
			res = mid;
			right = mid - 1;
		}
	}
	return res;
}