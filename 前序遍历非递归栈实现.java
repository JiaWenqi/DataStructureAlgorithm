##用栈而非递归实现二叉树的前序遍历
public class Node{
	public Node left;
	public Node right;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}
public void preOrderUnRecur(Node head){
	if(head != null){
		Stack<Node> stack = new Stack<Node>();
		stack.add(head);
		while(!stack.isEmpty()){
			head = stack.pop();
			System.out.print(head.value + " ");
			if(head.right != null){
				stack.push(head.right);
			}
			else{
				stack.push(head.left);
			}
		}
	}
}
