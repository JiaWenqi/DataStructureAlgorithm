//选择排序(与冒泡排序的区别是在比较中先进行交换序号索引，遍历一遍后再进行交换)
public void selectionSort(int[] arr){
	if(arr == null || arr.length < 2){
		return;
	}
	int mini = 0;
	for(int i = 0; i < arr.length-1; i++){
		mini = i;
		for(int j = 1; j < arr.length; j++){
			mini = arr[mini] > arr[j] ? j : mini;			
		}
		swap(arr, i, mini);
	}
 public void swap(chas, index1, index2){
	 int tmp = 0;
	 tmp = chas[index1];
	 chas[index1] = chas[index2];
	 chas[index2] = tmp;
 }
}