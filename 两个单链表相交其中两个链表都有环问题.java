##两个单向链表，其中两个链表都无环
public class Node{
	public int value;
	public Node next;
	
	public Node(int data){
		this.value = data;
	}
}

public Node bothLoop(Node head1, Node loop1, Node head2, Node loop2){
	Node cur1 = null;
	Node cur2 = null;
	if (loop1 == loop2){
		cur1 = head1;
		cur2 = head2;
		int n = 0;
		while(cur1 != loop1){
			n++;
			cur1 = cur1.next;
		}
		while(cur2 != loop2){
			n--;
			cur2 = cur2.next;
		}
		cur1 = n > 0 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;
		n = Math.abs(n);
		if(n!=0){
			n--;
			cur1 = cur1.next;
		}
		while(cur1 != cur2){
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}else{
		cur1 = loop1.next;
		while(cur1 != loop1){
			if(cur1 == loop2){
				return loop1;
			}
			cur1 = cur.next;
		}
		return null;
	}
}
