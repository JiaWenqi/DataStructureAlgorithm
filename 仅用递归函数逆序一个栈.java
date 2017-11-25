##仅用递归函数逆序一个栈
//首先实现第一个递归函数：将栈的栈底元素返回并删除
public int getAndRemoveLastElement(Stack<Integer> stack){
	int result = stack.pop();
	if(stack.isEmpty()){
		return result;
	} else {
		int last = getAndRemoveLastElement(stack);
		stack.push(result);
		return last;
	}
}
//逆序一个栈，利用第一个递归函数
public void reverse(Stack<Integer> stack){
	if(stack.isEmpty()){
		return;
	}
	int i  = getAndRemoveLastElement(stack);
	reverse(stack);
	stack.push(i);
}