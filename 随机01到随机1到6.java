//给定一个以p概率产生0，以1-p概率产生1的随机函数，p是固定的值，但你并不知道是多少。除此之外也不能使用任何额外的随机机制，请实现等概率随机产生0和1的随机函数。
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