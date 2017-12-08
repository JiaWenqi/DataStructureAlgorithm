//堆排序
public void heapSort(int[] arr){
	if(arr == null){
		return;
	}
	for(int i = 1; i < arr.length; i++){
		heapInsert(arr, i);
	}
	for(int j = arr.length - 1; j > 0; j--){
		swap(arr, 0, j);
		heapify(arr, 0, j);
	}
}
 public void heapInsert(int[] arr, int i){
	 while(i != 0){
		int parent = (i-1)/2;
		if(arr[parent] < arr[i]){
			swap(arr, parent, i); 
			parent = i;
		}else{
			break;
		}
	 }	
 }
 
 public void heapify(int[] arr, int i, int index){
	 arr[index] = arr[0];
	 int left = 2*i+1;
	 int right = 2*i+2;
	 int largest = i;
	 while(left < index)
		 if(arr[left] > arr[largest]){
			 largest = left;
		 }
		 if(right < index && arr[right] > arr[largest]){
			 largest = right;
		 }
		 if(largest != i){
			 swap(arr, largest, i);
		 }else{
			 break;
		 }
		 i = largest;
		 left = 2*i+1;
		 right = 2*i+2;
}
 
public  void swap(int[] arr, int index1, int index2) {
	int tmp = arr[index1];
	arr[index1] = arr[index2];
	arr[index2] = tmp;
}
