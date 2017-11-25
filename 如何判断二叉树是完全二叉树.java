##按递归后序遍历判断二叉树是否是平衡二叉树
public class Node{
	public Node left;
	public Node right;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}

public boolean isDBT(Node head){
	if(head == null){
		return true;
	}
	Queue<Node> queue = new Queue<Node>();
	Node node = null;
	Node l = null;
	Node r = null;
	queue.offer(head);
	leaf = false;
	while(!queue.isEmpty()){
		node = queue.poll();
		l = node.left;
		r = node.right;
		if((leaf && (l != null || r != null))||(l == null && r != null)){
			return false;
		}
		if(l != null){
			queue.offer(l);
		}
		if(r!=null){
			queue.offer(r);
		}else{
			leaf = true;
		}
	}
}