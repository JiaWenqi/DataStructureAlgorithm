##有三种情况判断
public class Node{
	public Node left;
	public Node right;
	public Node parent;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}

public Node getNextNode(Node node){
	if(node == null){
		return node;
	}
	if(node.right != null){
		return getLeftMost(node.right);
	}else{
		 Node parent = node.parent;
		 if(parent.left != node && parent != null){
			 node = parent;
			 parent = node.parent;
		 }
		 return parent;
	}
}

public Node getLeftMost(Node node){
	if(node == null){
		return node;
	}
	while(node.left != null){
		node = node.left;
	}
	return node;
}