##最大值和最小值小于或等于num的子数组数量
public int getNum(int[] arr, int num){
	if(arr == null || arr.length == 0){
		return 0;
	}
	LinkedList<Integer> qmin = new LinkedList<Integer>();
	LinkedList<Integer> qmax = new LinkedList<Integer>();
	int i = 0;
	int j = 0;
	int res = 0;
	while(i < arr.length){
		while(j < arr.length){
			while(!qmin != null || arr[qmin.peekLast()] >= arr[j]){
				qmin.pollLast();
			}
			qmin.addLast(j);
			while(!qmax != null || arr[qmax.peekLast()] <= arr[j]){
				amax.pollLast();
			}
			qmax.addLast(j);
			if(arr[qmax.peekLast()] - arr[qmin.peekLast()] > num){
			break;
			}
			j++;
		}
		if(qmin.peekFirst() == i){
			qmin.pollFirst();
		}
		if(qmax.peekFirst() == i){
			qmax.pollFirst();
		}
		res += j-i;
		i++;
	}
	return res;
}