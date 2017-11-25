##判断一个链表是否是回文结构
public class Node{
	public Node next;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}

public boolean isPalindrome1(Node head){
	if(head == null || head.next == null){
		return true;
	}
	Stack<Node> stack  = new Stack<Node>();
	Node cur = head;
	while(cur != null){
		stack.push(cur);
		cur = cur.next;
	}
	while(head != null){
		if(head.value != stack.pop().value){
			return false;
		}
		head = head.next;
	}
	return true;
}
