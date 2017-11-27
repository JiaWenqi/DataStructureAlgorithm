//求a的n次方
import java.util.*;
import java.math.BigInteger;

public class QuickPower {
	public int getPower(int a, int n){
		BigInteger res = BigInteger.valueOf(1);
		BigInteger tmp = BigInteger.valueOf(a);
		for(;n != 0; n >>= 1){
			if((n & 1) != 0){
				res = res.multiply(tmp);
			}
			tmp = tmp.multiply(tmp);
			res = res.mod(BigInteger.valueOf(1000000007));
			tmp = tmp.mod(BigInteger.valueOf(1000000007));
		}
		return res.mod(BigInteger.valueOf(1000000007)).intValue();
	}
}