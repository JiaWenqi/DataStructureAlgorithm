##单向链表的分化问题，分化后结点内部的位置关系不变
public class Node{
	public int value;
	public Node next;
	
	public Node(int data){
		this.value = data;
	}
}

public void singleLinkedListDivide(Node head, int pivot){
	Node sH = null;
	Node sT = null;
	Node eH = null;
	Node eT = null;
	Node bH = null;
	Node bT = null;
	Node next = null;
	while(head != null){
		next = head.next;
		head.next = null;
		if(head.value < pivot){
			if(sH == null){
				sH = head;
				sT = head;
			}else{				
				sT.next = head;
				sT = head;
			}
		}else if(head.value == pivot){
			if(eH == null){
				eH = head;
				eT = head;
			}else{
				eT.next = head;
				eT = head;
		}
		else{
			if(bH == null){
				bH = head;
				bT = head;
			}else{				
				bT.next = head;
				bT = head;
			}
		}
		head = next;
	}
	//小的和相等的连接在一起
	if(sT != null){
		sT.next = eH;
		eT = eT == null ? sT : eT;
	}
	//全部连接到一起
	if(eT != null){
		eT.next = bH;
	}
	return sH != null ? sH : eH != null ? eH : bH; 
}