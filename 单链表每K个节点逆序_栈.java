##单链表每K个节点逆序——借助栈实现
public class Node{
	public Node next;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}
public Node reverseKnodes1(Node head, int K){
	if(K < 2){
		return head;
	}
	Stack<Node> stack = new Stack<Node>();
	Node newHead = head;
	Node cur = head;
	Node pre = null;
	Node next = null;
	while(cur != null){
		next = cur.next;
		stack.push(cur);
		if(stack.size() == K){
			pre = resign1(stack, pre, next);
			newHead = newHead == head ? head : newHead;
		}
		cur = next;
	}
	return newHead;
}
/*这里的left代表的是上一个K逆序对的最后一个节点，right代表的是下一个K逆序对的第一个节点,stack装的是K逆序对的节点*/
 public Node resign1(Stack stack, Node left, Node right){
	 Node cur = stack.pop();
	 if(left != null){
		 left.next = cur;
	 }
	 Node next = null;
	 if(!stack.isEmpty()){
		 next = stack.pop();
		 cur.next = next;
		 cur = next;
	 }
	 cur.next = right;
	 return cur;	 
 }