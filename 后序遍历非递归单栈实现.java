##用单栈非递归实现二叉树的后序遍历——左右根
public class Node{
	public Node left;
	public Node right;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}
public void postOrderUnRecur(Node h){
	if(h != null){
		Stack<Node> stack = new Stack<Node>();
		stack.push(h);
		c = stack.peek();
		while(!stack.isEmpty()){
			if(c.left != null && h != c.left && h != c.right){
				stack.push(c.left);
			}
			else(c.right != null && h != c.right){
				stack.push(c.right);
			}
			else{
				System.out.print(stack.pop().value + " ");
				h = c;
			}
		}
	}
}