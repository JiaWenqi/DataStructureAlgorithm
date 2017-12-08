//插入排序，步长为1不断向前比较，遇到比自己小就交换，否则就break
public void insertSort(int[] arr){
	if(arr == null || arr.length < 2){
		return;
	}
	int index = 0;
	for(int i = 1; i < arr.length; i++){
		index = i;
		while(index > 0){
			if(arr[index-1] > arr[index]){
				swap(arr, index-1, index);
				index--;
			}else{
				break;
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