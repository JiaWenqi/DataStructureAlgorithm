//快速排序
/*
快速排序的时间主要耗费在划分操作上，对长度为k的区间进行划分，共需k-1次关键字的比较。

（1）最坏时间复杂度 
　最坏情况是每次划分选取的基准都是当前无序区中关键字最小(或最大)的记录，划分的结果是基准左边的子区间为空(或右边的子区间为空)，而划分所得的另一个非空的子区间中记录数目，仅仅比划分前的无序区中记录个数减少一个。 
　因此，快速排序必须做n-1次划分，第i次划分开始时区间长度为n-i+1，所需的比较次数为n-i(1≤i≤n-1)，故总的比较次数达到最大值： 
Cmax = n(n-1)/2=O(n2) 
　如果按上面给出的划分算法，每次取当前无序区的第1个记录为基准，那么当文件的记录已按递增序(或递减序)排列时，每次划分所取的基准就是当前无序区中关键字最小(或最大)的记录，则快速排序所需的比较次数反而最多。

（2） 最好时间复杂度 
　在最好情况下，每次划分所取的基准都是当前无序区的”中值”记录，划分的结果是基准的左、右两个无序子区间的长度大致相等。总的关键字比较次数： 
0(nlgn) 注意： 
　用递归树来分析最好情况下的比较次数更简单。因为每次划分后左、右子区间长度大致相等，故递归树的高度为O(lgn)，而递归树每一层上各结点所对应的划分过程中所需要的关键字比较次数总和不超过n，故整个排序过程所需要的关键字比较总次数C(n)=O(nlgn)。 
　因为快速排序的记录移动次数不大于比较的次数，所以快速排序的最坏时间复杂度应为0(n2)，最好时间复杂度为O(nlgn)。
*/
public void quickSort(int[] arr){
	if(arr == null || arr.length < 2){
		return;
	}
	process(arr, 0, arr.length-1);
}
//随机找一个数，然后与最后一个数位置交换，然后进行排序，排序完可以找到这个随机数的位置，然后根据这个位置分割成两部分再进行递归分治排序。
public void process(int[] arr, int left, int right){
	if(left < right){
		int random = left + (int) Math.random() * (right - left + 1);
		swap(arr, random, right);
		mid = partition(arr, left, right);
		process(arr, left, mid - 1);
		process(arr, mid + 1, right);		
	}
}
//定义一个假想的左小区间，起始位置是left-1,将左小区间外的下一个数与最右边的数比较，若小，则将左小区间右端数与区间外下一个数交换
//若大于最右边的数，则index继续往右遍历，直到最右边，最后将最右边的数与左小区间外的下一个数交换，左小区间外的下一个数就是分界点。
public void partition(int[] arr,int left, int right){
    int index = left;
	int pivot = left - 1;
	while(index < right){
		if(arr[index] <= arr[right]){
			swap(arr, index, ++pivot);
		}
		index++;
	}
	return pivot;
}
public void swap(chas, index1, index2){
	int tmp = 0;
	tmp = chas[index1];
	chas[index1] = chas[index2];
	chas[index2] = tmp;
	}
}