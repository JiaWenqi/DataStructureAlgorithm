##两个单向链表，其中两个链表都无环
public class Node{
	public int value;
	public Node next;
	
	public Node(int data){
		this.value = data;
	}
}

public Node noLoop(Node head1, Node head2){
	if (head1 == null || head2 == null){
		return null;
	}
	Node cur1 = head1;
	Node cur2 = head2;
	int n = 0;
	while(cur1 != null){
		cur1 = cur1.next;
		n++;
	}
	while(cur2 != null){
		cur2 = cur2.next;
		n--;
	}
	if(cur1 != cur2){
		return null;
	}
	cur1 = n > 0 ? head1 : head2;
	cur2 = cur1 == head1 ? head2 : head1; 
	n = Math.abs(n);
	while(n!=0){
		n--;
		cur1 = cur1.next;
	}
	while(cur1 != cur2){
		cur1 = cur1.next;
		cur2 = cur2.next;
	}
	return cur1;
}
