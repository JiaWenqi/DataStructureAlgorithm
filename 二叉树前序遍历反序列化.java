##用二叉树前序遍历反序列化
public class Node{
	public Node left;
	public Node right;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}

public Node reconByPreString(String preStr){
	String[] values = preStr.split("!");
	Queue<String> queue = new LinkedList<String>();
	for(int i = 0; i < values.length; i++){
		queue.offer(values[i]);
	}
	return reconPreOrder(queue);
}

public Node reconPreOrder(Queue<String> queue){
	String value = queue.poll();
	if(value.equals("#")){
		return null;
	}
	Node head = new Node(Integer.valueOf(value));
	head.left = reconPreOrder(queue);
	head.right = reconPreOrder(queue);
	return head;	
}
