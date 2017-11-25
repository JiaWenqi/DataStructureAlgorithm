##用morris实现二叉树的中序遍历——左中右
public Node class{
	public Node left;
	public Node right;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}

public void morrisIn(Node head){
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
				continue;
			}else if(cur2.right != null && cur2.right == cur1){
				cur2.right = null;
			}
		}			
		System.out.print(cur1.value + " ");
		cur1 = cur1.right;
	}
}
