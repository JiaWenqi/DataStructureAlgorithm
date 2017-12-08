//与插入排序，基本相同，初始步长为length/2,不断向前比较，遇到比自己小就交换，否则就break,遍历一遍后将步长调整为现有步长的一半
public void shellSort(int[] arr){
	if(arr == null || arr.length < 2){
		return;
	}
	int index = 0;
	int feet = arr.length/2;
	while(feet > 0){
		for(int i = 1; i < arr.length; i++){
			index = i;
			while(index > feet){
				if(arr[index-feet] > arr[index]){
					swap(arr, index-feet, index);
					index -= feet;
				}else{
					break;
				}
			}
		}
		feet/=2;
	}

public void swap(chas, index1, index2){
	 int tmp = 0;
	 tmp = chas[index1];
	 chas[index1] = chas[index2];
	 chas[index2] = tmp;
	}
}