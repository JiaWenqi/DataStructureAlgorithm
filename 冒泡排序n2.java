//冒泡排序（与选择排序的最大区别是冒泡排序比较过程中就不断的进行值交换，而不是先进行索引交换，遍历一遍后再进行值交换）
public void bubbleSort(int[] arr){
	if(arr == null || arr.length < 2){
		return;
	}
	for(int i = arr.length - 1; i >= 0;i--){
		for(int j = 0; j < i; j++){
			if(arr[j] > arr[j+1]){
				swap(arr, j, j+1);
			}
		}
	}
 public void swap(chas, index1, index2){
	 int tmp = 0;
	 tmp = chas[index1];
	 chas[index1] = chas[index2];
	 chas[index2] = tmp;
 }
}