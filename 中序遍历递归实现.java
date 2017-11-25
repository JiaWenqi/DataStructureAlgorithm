##用递归实现二叉树的中序遍历——左中右
public class Node{
	public Node left;
	public Node right;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}
public void inOrderRecur(Node head){
	if(head == null){
		return;
	}
	inOrderRecur(head.left);
	System.out.print(head.value);
	inOrderRecur(head.right);
}
