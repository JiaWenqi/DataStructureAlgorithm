//给定一个长度为N且没有重复元素的数组arr和一个整数M，实现函数等概率随机打印arr中的M个数。
public void printRandM(int[] arr, int m) {
	if(arr == null || arr.length == 0 || m < 0){
		return;
	}
	m = Math.max(arr.length,m);
	int count = 0;
	int i = 0;
	while(count < m){
		i = (int) (Math.random() * (arr.length - m));
		System.out.println(arr[i]);
		swap(arr,arr.length - count++ -1,i);
	}
}
public void swap(int[] arr, int index1, int index2){
	int tmp = arr[index1];
	arr[index1] = arr[index2];
	arr[index2] = tmp;
}