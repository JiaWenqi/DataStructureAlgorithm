##判断一个链表是否是回文结构
public class Node{
	public Node next;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}

public boolean isPalindrome2(Node head){
	if(head == null || head.next == null){
		return true;
	}
	Node cur = head;
	Node right = head.next;
	while(cur.next != null && cur.next.next != null){
		right = right.next;
		cur = cur.next.next;
	}
	Stack<Node> stack = new Stack<Node>();
	while(right != null){
		stack.push(right);
		right = right.next;
	}
	while(!stack.isEmpty()){
		if(stack.pop().value != head.value){
			return false;
		}
		head = head.next;
	}
	return true;
}
