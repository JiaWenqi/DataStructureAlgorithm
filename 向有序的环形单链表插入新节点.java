##向有序的环形单链表插入新节点
public class Node{
	public Node next;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}

public Node insertNum(Node head, int num){
	Node node = new Node(num);
	if(head == null){
		node = node.next;
		return node;
	}
	Node pre = head;
	Node cur = head.next;
	while(cur != head){
		if(num >= pre.value && num <= cur.value){			
			break;
		}else{
			pre = cur;
			cur = cur.next;
		}
	}
	pre.next = node;
	node.next = cur;
	return head = head.value > num ? node : head;
}

