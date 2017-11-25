##用递归实现二叉树的前序遍历序列化
public class Node{
	public Node left;
	public Node right;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}

public String serialByPre(Node head){
	if(head == null){
		return "#!";
	}
	String res = head.value + "!";
	res += serialByPre(head.left);
	res += serialByPre(head.right);
	return res;
}
