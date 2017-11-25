##使用hash表来复制链表
public class Node{
	public Node next;
	public Node rand;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}

public Node copyListWithRand2(Node head){
	if(head  == null){
		return null;
	}
	Node cur = head;
	Node next = null;
	/*首先将要复制的节点放到原有节点之间*/
	while(cur != null){
		next = cur.next;
		cur.next = new Node(cur.value);
		cur.next.next = next;
		cur = next;
	}
	cur = head;
	Node curCopy = null;
	//设置复制节点的rand指针
	while(cur != null){
		next = cur.next.next;
		curCopy = cur.next;
		curCopy.rand = cur.rand != null ? cur.rand.next : null;
		cur = next;
	}
	//分离链表
	Node res = head.next;
	cur = head;
	while(cur != null){
		next = cur.next.next;
		curCopy = cur.next;
		cur.next = next;
		curCopy.next = next != null ? next.next : null;
		cur = next;
	}
	return res;
}