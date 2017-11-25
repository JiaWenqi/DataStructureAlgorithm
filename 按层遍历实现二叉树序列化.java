##按层遍历实现二叉树的序列化
public String serialByLevel(Node head){
	if(head == null){
		return "#!";
	}
	Queue<Node> queue = new LinkedList<Node>();
	queue.offer(head);
	String res = head.value + "!";
	while(!queue.isEmpty()){
		if(head.left != null){
			head = queue.poll();
			queue.offer(head.left);
			res += head.left.value + "!";
		}
		else{
			res += "#!";
		}
		if(head.right != null){
			queue.offer(head.right);
			res += head.right.value + "!";
		}	
		else{
			res += "#!";
		}		
	}
	return res;
}
