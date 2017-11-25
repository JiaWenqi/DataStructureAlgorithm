##单向链表删除指定的节点
public class Node{
	public int value;
	public Node next;
	
	public Node(int data){
		this.value = data;
	}
}

public Node removeValue1(Node head, int num){
	Stack<Node> stack = new Stack<Node>();
	while(head != null){
		if(head.value != num){
			stack.push(head);
		}
		head = head.next;
	}
	while(!stack.isEmpty()){
		stack.peek().next = head;
		head = stack.pop();
	}
	return head;
}