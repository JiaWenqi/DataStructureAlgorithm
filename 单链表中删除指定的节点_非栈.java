##单向链表删除指定的节点
public class Node{
	public int value;
	public Node next;
	
	public Node(int data){
		this.value = data;
	}
}

public Node removeValue2(Node head, int num){
	while(head != null){
		if(head.value != num){
			break;
		}
		head = head.next;
	}
	Node pre = head;
	Node cur = head;
	while(cur != null){
		if(cur.value == pre.value){
			pre.next = cur.next;
		}else{
			pre = cur;
		}
		cur = cur.next;
	}
	return head;
}