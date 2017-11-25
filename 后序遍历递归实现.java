##用递归实现二叉树的后序遍历——左右根
public class Node{
	public Node left;
	public Node right;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}
public void postOrderRecur(Node head){
	postOrderRecur(head.left);
	postOrderRecur(head.right);
	System.out.print(head.value + " ");
}