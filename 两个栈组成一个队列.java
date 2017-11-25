##用两个栈实现一个队列
用stackPush和stackPop栈实现队列的add,poll以及peek方法
public class twoStacksQueue{
	public Stack<Integer> stackPush;
	public Stack<Integer> stackPop;
	
	public twoStacksQueue() {
		stackPush = new Stack<Integer>();
		stackPop = new Stack<Integer>();
	}
	
	public void add(int pushInt){
		stackPush.push(pushInt);
	}
	
	public int poll() {
		if(stackPop.isEmpty() && stackPop.isEmpty()){
			throw new RunTimeException("Queue is Empty!");
		}else if(stackPop.isEmpty()){
			while(!stackPush.isEmpty()){
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.pop();
	}
	
	public int peek() {
		if(stackPop.isEmpty() && stack.Pop.isEmpty()){
			throw new RunTimeExceptionException("Queue is Empty!");
		}else if(stackPop.isEmpty()){
			while(!stackPush.isEmpty()){
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.peek();
	}
}
