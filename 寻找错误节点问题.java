##用二叉树的中序遍历实现错误节点寻找问题——右中左
public class Node{
	public Node left;
	public Node right;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}

public void inOrderUnRecur(Node head){
	Node[] errs = new Node[2];
	if(head == null){
		return errs;
	}
	Stack<Node> stack = new Stack<Node>();
	Node pre = null;
	while(!stack.isEmpty() || head != null){
		if(head != null){
			stack.push(head);
			head = head.left;
		}else{
			head = stack.pop();
			if(pre != null && pre.value > head.value){
				errs[0] = errs[0] == null ? pre : errs[0]; 
				errs[1] = head;
			}
			pre = head;
			head = head.right;
		}
	}
	return errs;
}