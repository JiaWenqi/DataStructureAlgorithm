##单链表每K个节点逆序——借助栈实现
public class Node{
	public Node next;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}
public Node reverseKnodes2(Node head, int K){
	if(K < 2){
		return head;
	}
	Node cur = head;
	Node start = null;
	Node next = null;
	Node pre = null;
	int count = 1;
	while(cur != null){
		if(K == count){
			start = pre == null ? head : pre.next;
			head = pre == null ? cur : head;
			resign2(pre, start, cur, next);
			pre = start;
			count = 0;
		}
		count++;
		cur = cur.next;
	}
	return head;
}

/*left代表上一个逆序对的最后一个节点，right代表下一个逆序对第一个节点，start代表逆序对的第一个节点，end代表逆序对的最后一个节点*/
public void resign2(Node left, Node start, Node end, Node right){
	Node pre = start;
	Node cur = start.next;
	Node next = null;
	while(cur != null){
		next = cur.next;
        cur.next = pre;	
		pre = cur;
		cur = next;	
	}
	if(left != null){
		left.next = end;
	}
	start.next = right;
}