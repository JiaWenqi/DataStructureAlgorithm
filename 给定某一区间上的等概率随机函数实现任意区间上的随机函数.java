//给定某一区间上的等概率随机函数实现任意区间上的随机函数
public int rand01p() {
	float p = 0.86;
	return Math.random() < p ? 0 : 1;
}

public int rand01(){
	int num = 0;
	do{
		num = rand01p();
	}while(num == rand01p());
	return num;
}

public int rand1To3(){
	return rand01() * 2 + rand01();
}

public int rand1To6(){
	int num = 0;
	do{
		num = rand1To3 * 4 + rand1To3;
	}while(num > 11);
	return num % 6 + 1;
}