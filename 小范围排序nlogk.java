public int[] sortElement(int[] arr, int n, int k){
	if(arr == null || arr.length == 0 || arr.length < k){
		return arr;
	}
	int[] heap = getHeap(arr,k);
	for(int i = k; i < n; i++){
		arr[i - k] = heap[0];
		heap[0] = arr[i];
		heapify(heap, 0, k);
	}
	for(int i = n-k; i < n; i++){
		arr[i] = heap[0];
		swap(heap, 0, k-1);
		heapify(heap, 0, k--);
	}
	return arr;
}
public int[] getHeap(int[] arr, int k){
	 int heap = new int[k];
	 for(int i = 0; i < k; i++){
		 heapInsert(heap, arr[i], i);
	 }
	 return heap;
}
public void heapInsert(int[] heap, int value, int index){
	heap[index] = value;
	int parent = 0;
	while(index != 0){
		int parent = (index - 1)/2;
		if(heap[parent] > heap[index]){
			swap(heap, parent, index);
			index = parent;
		}else{
			break;
		}
	}
}

public void heapify(int[] arr, int index, int heapSize){
	int left = 2 * index + 1;
	int right = 2 * index + 1;
	int smallest = index;
	while(left < heapSize){
		if(arr[smallest] > arr[left]){
			smallest = left;
		}
		if(arr[smallest] > arr[right] && right < heapSize){
			smallest = right;
		}
		if(smallest != index){
			swap(arr, smallest, index);
		}else{
			break;
		}
		index = smallest;
		left = 2 * index + 1;
		right = 2 * index + 2;
	}
}

public void swap(int[] arr, int index1, int index2) {
	int tmp = arr[index1];
	arr[index1] = arr[index2];
	arr[index2] = tmp;
}