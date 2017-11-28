//给定一个整型数组arr，其中有两个数出现了奇数次，其他的数都出现了偶数次，找到这两个数。要求时间复杂度为O(N)，额外空间复杂度为O(1)。

public class oddAppearance{
	public int[] findOdds(int[] A, int n){
		int eO = 0, eOhasOne = 0;
		for(int curNum : A){
			eO = eO ^ curNum;
		}
		int rightOne = eO & (~eO + 1);
		for(int cur : A){
			if(cur & rightOne != 0){
				eOhasOne ^= cur;
			}
		}
		int small = Math.min(eOhasOne,eOhasOne ^ eO);
		int big = Math.max(eOhasOne,eOhasOne ^ eO);	
		return new int[] {min,max};
	}
}