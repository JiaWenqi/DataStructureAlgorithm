##两个单向链表相交问题
public class Node{
	public int value;
	public Node next;
	
	public Node(int data){
		this.value = data;
	}
}

public Node getIntersectNode(Node head1, Node head2){
	if(head1 == null || head2 == null){
		return null;
	}
	Node loop1 = getLoopNode(head1);
	Node loop2 = getLoopNode(head2);
	if(loop1 == null && loop2 == null){
		return noLoop(head1, head2);
	}
	if(loop1 != null && loop2 != null){
		return bothLoop(head1, loop1, head2,loop2);
	}
	return null;
}