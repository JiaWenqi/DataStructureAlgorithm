##按递归后序遍历判断二叉树是否是平衡二叉树
public class Node{
	public Node left;
	public Node right;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}

public boolean isBalance(Node head){
	boolean[] res = new boolean[1];
	res[0] = true;
	getHeight(head, 1, res);
	return res[0];
}
public int getHeight(Node head, int level, boolean[] res){
	if(head == null){
		return level;
	}
	int LH = getHeight(head.left, level+1, res[0]);
	if(!res[0]){
		return level;
	}
	int LR = getHeight(head.right, level+1, res[0]);
	if(!res[0]){
		return level;
	}
	if(Math.abs(LR-LH) > 1){
		res[0] = false;
	}
	return Math.max(LR,LH);
}