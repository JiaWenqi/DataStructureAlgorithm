##用递归实现二叉树节点间的最大距离——左右根
public class Node{
	public Node left;
	public Node right;
	public int value;
	
	public Node(int data){
		this.value = data;
	}
}
public int biggestSubBST(Node head){
	int[] record = new int[3];
	return postOrder(head, record);
}
public int postOrder(Node head,int[] record){
	if(head == null){
		record[0] = 0;
		record[1] = Integer.MAX_VALUE;
		record[2] = Integer.MIN_VALUE;
		return null;
	}
	int value = head.value;
	Node left = head.left;
	Node right = head.right;
	Node lBST = postOrderRecur(left,record);
	int lSize = record[0];
	int lMin = record[1];
	int lMax = record[2];
	Node rBST = postOrderRecur(right,record);
	int rSize = record[0];
	int rMin = record[1];
	int rMax = record[2];
	record[1] = Math.min(lMin,value);
	record[2] = Math.max(rMax,value);
	if(left == lBST && right == rBST && value > lMax && value < rMin){
		record[0] = lSize + rSize + 1;
		return head;
	}
	record[0] = Math.max(lSize,rSize);
	return lSize > rSize ? lBST : rBST;
}