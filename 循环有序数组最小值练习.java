##用二分搜索法寻找循环有序数组元素最小值问题
public int getMin(int[] arr){
	if(arr == null || arr.length == 0){
		return -1;
	}
	int low = 0;
	int high = arr.length-1;
	int mid = 0;
	while(low < high){
		if(low == high - 1){
			break;
		}
		if(arr[low]<arr[high]){
			return arr[low];
		}
		mid = (low + high)/2;
		if(arr[low] > arr[mid]){
			high = mid;
			continue;
		}
		if(arr[mid] > arr[high]){
			low = mid;
			continue;
		}
		while(low < mid){
			if(arr[low] == arr[mid]){
				low++;
			}else if(arr[low] < arr[mid]){
				return arr[low];
			}else{
				high = mid;
				break;
			}
		}
	}
	return Math.min(arr[low],arr[high]);
}