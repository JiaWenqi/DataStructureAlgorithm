//给定一个等概率随机产生1~5的随机函数，除此之外，不能使用任何额外的随机机制，请实现等概率随机产生1~7的随机函数。
public int rand1To5() {
	return (int) (Math.random() * 5) + 1;
}

public int rand1to7(){
	int num = 0;
	do{
		num = (rand1To5() - 1)*5 + rand1To5() - 1;
	}while(num > 20);
	return num % 7 + 1;
}