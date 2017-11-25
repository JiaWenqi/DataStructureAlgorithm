##用二叉树前序遍历反序列化
public class Node{
	public Node left;
	public Node right;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}

public Node generateNodeByString(String val){
	if(val.equals("#")){
		return null;
	}
	return new Node(Integer.valueOf(val));
}

public Node reconByLevelString(String levelStr){
	int index = 0;
	String[] values = levelStr.split("!");
	Queue<Node> queue = new LinkedList<Node>();
	Node head = generateNodeByString(values[index++]);
	if(head != null){
		queue.offer(head);
	}
	Node node = null;
	while(!queue.isEmpty()){
		node = queue.poll();
		node.left = generateNodeByString(values[index++]);
		node.right = generateNodeByString(values[index++]);
		if(node.left != null){
			queue.offer(node.left);
		}
		if(node.right != null){
			queue.offer(node.right);
		}		
	}
	return head;
}