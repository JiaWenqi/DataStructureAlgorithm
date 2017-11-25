##用morris实现二叉树的后序遍历——左右根
public class Node{
	public Node left;
	public Node right;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}

public void morrisPost(Node head){
	if(head == null){
		return;
	}
	Node cur1 = head;
	Node cur2 = null;
	while(cur1 != null){
		cur2 = cur1.left;
		if(cur2 != null){
			while(cur2.right != null && cur2.right != cur1){
				cur2 = cur2.right;
			}
			if(cur2.right == null){
				cur2.right = cur1;
				cur1 = cur1.left;
			}else if(cur2 != null && cur2.right == cur1){
				cur2.right = null;
				printEdge(cur1.left);
			}
		}
		cur1 = cur1.right;
	}
	printEdge(head);
}

public void printEdge(Node head){
	Node tail = reverseEdge(head);
	Node cur = tail;
	while(cur != null){
		System.out.print(cur.value + " ");
		cur = cur.right;
	}
	reverseEdge(tail);
}

public Node reverseEdge(Node from){
	Node next = null;
	Node pre = null;
	if(from != null){
		next = from.right;
		from.right = pre;
		pre = from;
		from = next;
	}
	return pre;
}