##用栈非递归实现二叉树的后序遍历——左右根
public class Node{
	public Node left;
	public Node right;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}

public void postOrderUnRecur(Node head){
	if(head != null){
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.push(head);
		while(!s1.isEmpty()){
			head = s1.pop();
			s2.push(head);
			if(head.left != null){
				s1.push(head.left);
			}
			if(head.right != null){
				s1.push(head.right);
			}
		}
		while(!s2.isEmpty()){
		System.out.print(s2.pop().value() + " ");
		}
	}
}