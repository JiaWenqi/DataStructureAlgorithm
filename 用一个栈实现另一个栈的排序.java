##用一个辅助栈实现另外一个栈的排序
public void sortStackByStack(Stack<Integer> stack){
	Stack<Integer> help = new Stack<Integer>();
	while(!stack.isEmpty()){
		int cur = stack.pop();
		while(help.peek() > cur && !help.isEmpty()){
			stack.push(help.pop());
		}
		help.push(cur);
	while(!help.isEmpty()){
		stack.push(help.pop());
	}
}