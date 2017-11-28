//对于两个32位整数a和b，请设计一个算法返回a和b中较大的。但是不能用任何比较判断。若两数相同，返回任意一个。给定两个整数a和b，请返回较大的数。
public class Compare{
	public int flip(int n){
		return n ^ 1;
	}
	
	public int sign(int n){
		return flip((n >> 31) & 1);
	}
	
	public int getMax(int a, int b){
		int c = a - b;
		int sa = sign(a);
		int sb = sign(b);
		int sc = sign(c);
		int difSab = sa ^ sb; //a和b符号不同为1，相同为0；
		int sameSab = flip(difSab); //a和b符号相同为1，不同为0；
		int returnA = difSab * sa + sameSab * sc; //防止c溢出。当a和b符号不同的时候,c容易溢出，那么sc就有可能不正确。而符号相同的时候sameSab=0，此时sc就不起作用
		int returnB = flip(returnA);
		return a * returnA + b * returnB;
	}
}