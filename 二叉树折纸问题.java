##用二叉树的中序遍历实现折纸问题——右中左
public void printAllFolds(int N){
	printProcess(1, N, true);
}
public void printProcess(int i, int N, boolean down){
	if(i > N){
		return;
	}
	printProcess(i+1, N, true);
	System.out.print(down? "down ": "up ");
	printProcess(i+1, N, false);
}