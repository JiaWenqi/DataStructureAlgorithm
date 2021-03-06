##两个单向链表，判断两个链表是否有环
public class Node{
	public int value;
	public Node next;
	
	public Node(int data){
		this.value = data;
	}
}
 public Node getLoopNode(Node head){
	 if(head == null || head.next == null || head.next.next == null){
		 return null;
	 }
	 Node n1 = head.next; // n1 -> slow
	 Node n2 = head.next.next; // n2 -> fast
	 while(n1 != n2){
		 if(n2.next == null || n2.next.next == null){
			 return null;
		 }
		 n1 = n1.next;
		 n2 = n2.next.next;
		 if(slow == fast){
			 break; 
		 }
	 }
	 
	 n2 = head;
	 while(n2 != n1){
		 n1 = n1.next;
		 n2 = n2.next;
	 }
	 
	 return n1;
 }