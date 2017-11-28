//有一个整型数组A，其中只有一个数出现了奇数次，其他的数都出现了偶数次，请打印这个数。
public class oddAppearance{
	public int findOdds(int[] A, int n){
		int eO = 0;
		for(int i = 0; i++; i < n){
			eO = eO ^ A[i];
		}
		return eO;
	}
}