##用非递归实现二叉树的中序遍历——左中右
public class Node{
	public Node left;
	public Node right;
	public int data;
	
	public Node(int data){
		this.value = data;
	}
}
public void inOrderUnRecur(Node head){
	if(head != null){
		Stack<Node> stack = new Stack<Node>();
		while(!stack.isEmpty() || head != null){
			if(head != null){
				stack.push(head);
				head = head.left;
			}
			else{
				head = stack.pop();
				System.out.print(head.value+" ");
				head = head.right;
			}
		}
	}
}