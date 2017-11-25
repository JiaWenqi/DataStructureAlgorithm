##用递归实现二叉树的前序遍历
public class Node{
	public Node left;
	public Node right;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}
public void preOrderRecur(Node head){
	if(head == null){
		return;
	}
	System.out.println(head.value + " ");
	preOrderRecur(head.left);
	preOrderRecur(head.right);
}