##按层遍历实现二叉树的序列化
public class Node{
	public Node left;
	public Node right;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}

public void printByLevel(Node head){
	if(head == null){
		return;
	}
	Node last = head;
	Node nlast = null;
	Queue<Node> queue = new LinkedList<Node>();
	level = 1;
	System.out.print("\nLevel" + (level++) + ":");
	while(!queue.isEmpty()){
		head = queue.poll();
		System.out.print(head.value + " ");
		if(head.left != null){
			nlast = head.left;
			queue.offer(head.left);
		}
		if(head.right != null){
			nlast = head.right;
			queue.offer(head.right);
		}
		if (last == head && !queue.isEmpty()){
			System.out.print("\nLevel" + (level++) + ":");
			last = nlast;
		}
	}
}