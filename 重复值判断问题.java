//
public boolean isunique(char[] chas){
	if(chas == null){
		return true;
	}
	heapSort(chas);
	for(int i = 1; i < chas.length; i++){
		if(chas[i] == chas[i-1]){
			return false;
		}
	}
	return true;
}

public void heapSort(char[] chas){
	for(int i = 1; i < chas.length; i++){
		heapInsert(chas, i);
	}
	for(int i = chas.length - 1; i > 0; i--){
		swap(arr, 0, i);
		heapify(chas, 0, i);
	}
	
}

public void headInsert(char[] chas, int i){
	int parent = 0;
	while(i != 0){
		parent = (i-1)/2;
		if(chas[parent] > chas[i]){
			swap(chas, parent, i);
			i = parent;
		}else{
			break;
		}
	}
}

public void heapify(char[] chas, int i, int size){
	int left = 2 * i + 1;
	int right = 2 * i + 2;
	int largest = i;
	while(left < size){
		if(chas[i] < chas[left]){
			lagrgest = left;
		}
		if(right < size && chas[right] > chas[largest]){
			largest = right;
		}
		if(largest != i){
			swap(chas, i, largest);
		}else{
			break;
		}
		i = largest;
		left = 2 * i + 1;
		right = 2 * i + 1;
	}
}
 public void swap(chas, index1, index2){
	 int tmp = 0;
	 tmp = chas[index1];
	 chas[index1] = chas[index2];
	 chas[index2] = tmp;
 }