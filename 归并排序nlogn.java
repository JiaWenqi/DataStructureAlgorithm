//归并排序主要利用了递归的分治思想
/*
归并排序的效率是比较高的，设数列长为N，将数列分开成小数列一共要logN步，每步都是一个合并有序数列的过程，时间复杂度可以记为O(N)，故一共为O(N*logN)。
因为归并排序每次都是在相邻的数据中进行操作，所以归并排序在O(N*logN)的几种排序方法（快速排序，归并排序，希尔排序，堆排序）也是效率比较高的。
*/
public void mergeSort(int[] arr){
	if(arr == null || arr.length < 2){
		return;
	}
	process(arr, 0, arr.length-1);
}
//process函数主要是将数组递归的分成若干小数组，直到分成数组长度为1的小数组
public void process(int[] arr, int left, int right){
	if(left == right){
		return;
	}
	int mid = 0;
	mid = (left + right) / 2;
	process(arr, left, mid);
	process(arr, mid+1, right);
	merge(arr, left, mid, right);
}
//merge函数主要是将两个有序数组合并到一起
public void merge(int[] arr, int left, int mid, int right){
	int[] help = new int[right - left + 1];
	int l = 0;
	int r = 0;
	l = left;
	r = mid+1;
	int index = 0;
	while(l <= mid && r <= right){
		if(arr[l] < arr[r]){
			help[index++] = arr[l++];
		}else{
			help[index++] = arr[r++];
		}
	}
	while(l <= mid){
		help[index++] = arr[l++];
	}
	while(r <= right){
		help[index++] = arr[r++];
	}
	for(int i = 0; i < help.length; i++){
		arr[left + i] = help[i];
	}
}
public void swap(chas, index1, index2){
	int tmp = 0;
	tmp = chas[index1];
	chas[index1] = chas[index2];
	chas[index2] = tmp;
	}
}