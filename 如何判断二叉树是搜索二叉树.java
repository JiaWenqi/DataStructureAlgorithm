##按morris中序遍历判断二叉树是否是搜索二叉树
public class Node{
	public Node left;
	public Node right;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}

public boolean isBST(Node head){
	if(head == null){
		return true;
	}
	boolean res = true;
	Node cur1 = head;
	Node cur2 = null;
	Node pre = null;
	while(cur1 != null){
		cur2 = cur1.left;
		if(cur2 != null){
			while(cur2.right != null && cur2.right != cur1){
				cur2 = cur2.right;
			}
			if(cur2 == null){
				cur2.right = cur1;
				cur1 = cur1.left;
				continue;
			}else(cur2.right != null && cur.right == cur1){
				cur2 = null;
			}
		}
		if(pre != null && pre.value > cur1.value){
			res = false;
		}
		pre = cur1;
		cur1 = cur1.right;
	}
	return res;
}