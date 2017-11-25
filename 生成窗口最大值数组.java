##生成某个固定窗口的最大值数组
public int[] getMaxWindow(int [] arr, int w){
	if(w < 1 || arr.length < w || arr.length == null){
		return null;
	}
	LinkedList<Integer> qmax = new LinkedList<Integer>();
	int[] res = new int[arr.length - w + 1];
	for(int i = 0; i < arr.length; i++){
		while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
			qmax.pollLast();
		}
		qmax.addLast(i);
		if(qmax.peekFirst() == i-w){
			qmax.pollFisrt();
		}
		if(i >= w - 1){
			res[index++] = arr[qmax.peekFirst()];
		}
	}
	return res;
}